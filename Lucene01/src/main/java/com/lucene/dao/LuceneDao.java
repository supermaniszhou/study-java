package com.lucene.dao;

import com.lucene.bean.Article;
import com.lucene.common.ComContants;
import com.lucene.util.LuceneUtil;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 周刘成   2020-1-6
 */
public class LuceneDao {

    public void pageindex() {

    }

    public void createIndex(Article article) throws IOException {
        IndexWriter indexWriter = LuceneUtil.getIndexWriter();
        Document document = this.beanToDocument(article);
        indexWriter.addDocument(document);
        indexWriter.close();
    }

    public void updateIndex(String key, String value, Article article) throws IOException {
        IndexWriter indexWriter = LuceneUtil.getIndexWriter();
        Term term = new Term(key, value);
        Document document = beanToDocument(article);
        indexWriter.updateDocument(term, document);
        indexWriter.close();
    }

    public void delIndex(String key, String value) throws Exception {
        IndexWriter indexWriter = LuceneUtil.getIndexWriter();
        Term term = new Term(key, value);
        indexWriter.deleteDocuments(term);
        indexWriter.close();
    }

    /**
     * @param keyWrods 搜索关键字
     * @param page     页数
     * @param pagesize 每页显示多少记录
     * @return
     * @throws Exception
     */
    public List<Article> queryIndex(String keyWrods, int page, int pagesize) throws Exception {
        Directory directory = FSDirectory.open(Paths.get(ComContants.INDEX_PATH));
        IndexReader reader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(reader);
        String[] fields = {"title", "content"};
        QueryParser queryParser = new MultiFieldQueryParser(fields, LuceneUtil.getAnalyzer());
        Query query = queryParser.parse(keyWrods);

        TopDocs topDocs = indexSearcher.search(query, (page - 1) * pagesize + pagesize);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        System.out.println("总的记录数：" + topDocs.totalHits);

        int compareResult = Math.min(scoreDocs.length, (page - 1) * pagesize + pagesize);
        List<Article> list = new ArrayList<>();
        for (int i = (page - 1) * pagesize; i < compareResult; i++) {
            int id = scoreDocs[i].doc;
            try {
                Document document = indexSearcher.doc(id);
                Article article = new Article();
                article.setId(Integer.parseInt(document.get("id")));
                article.setAuther(document.get("author"));
                article.setTitle(document.get("title"));
                article.setContent(document.get("content"));
                article.setUrl(document.get("link"));
                list.add(article);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public List<Article> queryIndex(String key, String value) throws IOException {
        IndexSearcher indexSearcher = LuceneUtil.getIndexSearcher();
        Term term = new Term(key, value);
        Query query = new TermQuery(term);
        TopDocs topDocs = indexSearcher.search(query, 100);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        List<Article> list = new ArrayList<>();
        Arrays.stream(scoreDocs).forEach(s -> {
            int id = s.doc;
            try {
                Document document = indexSearcher.doc(id);
                Article article = new Article();
                article.setId(Integer.parseInt(document.get("id")));
                article.setAuther(document.get("author"));
                article.setTitle(document.get("title"));
                article.setContent(document.get("content"));
                article.setUrl(document.get("link"));

                list.add(article);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return list;
    }


    public Document beanToDocument(Article article) {
        Document document = new Document();

        IndexableField id = new NumericDocValuesField("id", article.getId());
        IndexableField storeId = new StoredField("id", article.getId());
        IndexableField title = new TextField("title", article.getTitle(), Field.Store.YES);
        IndexableField content = new TextField("content", article.getContent(), Field.Store.YES);
        IndexableField url = new StringField("link", article.getUrl(), Field.Store.YES);

        IndexableField author = new StringField("author", article.getAuther(), Field.Store.YES);
        document.add(id);
        document.add(storeId);
        document.add(title);
        document.add(content);
        document.add(url);
        document.add(author);
        return document;

    }
}

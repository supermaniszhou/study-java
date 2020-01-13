package com.test;

import com.lucene.util.LuceneUtil;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.junit.Test;

/**
 * 周刘成   2020-1-10
 */
public class TestQuery {

    //    第一种：使用termQuery查询
    @Test
    public void termQuery() throws Exception {
        IndexSearcher indexSearcher = LuceneUtil.getIndexSearcher();
        Term term = new Term("title", "洲");
        Query query = new TermQuery(term);
        TopDocs docs = indexSearcher.search(query, 100, getSort());
        common(docs, indexSearcher);
    }

    //    第二种：多字段查询
    @Test
    public void multiQuery() throws Exception {
        String key = "洲";
        IndexSearcher indexSearcher = LuceneUtil.getIndexSearcher();
        String fields[] = {"title", "content"};
        QueryParser queryParser = new MultiFieldQueryParser(fields, new StandardAnalyzer());
        Query query = queryParser.parse(key);
        TopDocs docs = indexSearcher.search(query, 100, getSort());
        common(docs, indexSearcher);
    }

    //第三种：查询所有
    @Test
    public void queryAll() throws Exception {
        IndexSearcher indexSearcher = LuceneUtil.getIndexSearcher();
        Query query = new MatchAllDocsQuery();
        TopDocs topDocs = indexSearcher.search(query, 100);
        common(topDocs, indexSearcher);
    }

    //第四种：范围查询
    @Test
    public void rangeQuery() throws Exception {
        IndexSearcher indexSearcher = LuceneUtil.getIndexSearcher();
        Query query = IntPoint.newRangeQuery("id", 5, 15);
        TopDocs docs = indexSearcher.search(query, 100);
        common(docs, indexSearcher);

    }

    /**
     * 第五种查询，通配符拆查询
     * ?代表单个任意字符
     * *代表多个任意字符
     */
    @Test
    public void wildQuery() throws Exception {
        IndexSearcher indexSearcher = LuceneUtil.getIndexSearcher();
        Term term = new Term("content", "洲*");
        Query query = new WildcardQuery(term);
        TopDocs topDocs = indexSearcher.search(query, 100);
        common(topDocs, indexSearcher);

    }

    //第六种：模糊查询
    @Test
    public void fuzzyQuery() throws Exception {
        IndexSearcher indexSearcher = LuceneUtil.getIndexSearcher();
//        Term term=new Term("author","李胜李");
        Term term = new Term("content", "美洲");
        Query query = new FuzzyQuery(term, 2);
        TopDocs topDocs = indexSearcher.search(query, 100);
        common(topDocs, indexSearcher);
    }

    //第七种：短语查询
    @Test
    public void phraseQuery() throws Exception {
        IndexSearcher indexSearcher = LuceneUtil.getIndexSearcher();
        Query query = new PhraseQuery(11, "content", new String[]{"大", "洲"});
        TopDocs topDocs = indexSearcher.search(query, 100);
        common(topDocs, indexSearcher);
    }

    @Test
    public void testboolean() throws Exception {
        IndexSearcher indexSearcher = LuceneUtil.getIndexSearcher();
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        Query query1 = IntPoint.newRangeQuery("id", 1, 10);
        Query query2 = IntPoint.newRangeQuery("id", 5, 15);
        builder.add(query1, BooleanClause.Occur.MUST);
        builder.add(query2, BooleanClause.Occur.MUST_NOT);
        Query query = builder.build();
        TopDocs topDocs = indexSearcher.search(query, 100);
        common(topDocs, indexSearcher);
    }


    public Sort getSort() {
        SortField sortField = new SortField("id", SortField.Type.INT, true);
        Sort sort = new Sort();
        sort.setSort(sortField);
        return sort;
    }

    public void common(TopDocs docs, IndexSearcher indexSearcher) throws Exception {
        ScoreDoc[] scoreDocs = docs.scoreDocs;
        for (int i = 0; i < scoreDocs.length; i++) {
            int id = scoreDocs[i].doc;
            Document document = indexSearcher.doc(id);
            System.out.println(document.get("id"));
            System.out.println(document.get("author"));
            System.out.println(document.get("title"));
            System.out.println(document.get("content"));
        }
    }

}

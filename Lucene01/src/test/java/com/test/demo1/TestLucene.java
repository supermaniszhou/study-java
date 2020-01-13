package com.test.demo1;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * 周刘成   2020-1-5
 */
public class TestLucene {

    @Test
    public void sortId() throws Exception {
//        IndexSearcher searcher = LuceneUtil.getIndexSearcher("index/");
//        Query query = new MultiFields();
//        searcher.search(query, 100);
    }

    @Test
    public void createIndex() throws IOException {
        Directory directory = FSDirectory.open(Paths.get("index/"));
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, config);

        Document document = new Document();
        IndexableField id = new IntPoint("id", 1);
        IndexableField storeField = new StoredField("id", String.valueOf(id));
        IndexableField title = new StringField("title", "java 基础，黑马培训", Field.Store.YES);
        IndexableField content = new TextField("content", "java 基础，黑马培训,致力于培养优秀的人才", Field.Store.YES);

        document.add(id);
        document.add(title);
        document.add(content);
        document.add(storeField);
        indexWriter.addDocument(document);

        indexWriter.close();
    }

    @Test
    public void serachIndex() throws Exception {
        Directory directory = FSDirectory.open(Paths.get("index"));
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        Term term = new Term("content", "基");
        Query query = new TermQuery(term);
        TopDocs topDocs = indexSearcher.search(query, 100);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        Arrays.stream(scoreDocs).forEach(s -> {
            int id = s.doc;
            try {
                Document doc = indexSearcher.doc(id);
                System.out.println(doc.get("id"));
                System.out.println(doc.get("title"));
                System.out.println(doc.get("content"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}

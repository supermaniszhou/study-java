package com.test;

import com.lucene.common.ComContants;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.SortedDocValuesField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.nio.file.Paths;

/**
 * 周刘成   2020-1-10
 */
public class TestSort {

    @Test
    public void testSort() throws Exception {
        String keywords = "洲";
        Directory directory = FSDirectory.open(Paths.get(ComContants.INDEX_PATH));
        IndexReader reader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(reader);
        Analyzer analyzer = new StandardAnalyzer();
        String field[] = {"title"};
        QueryParser queryParser = new MultiFieldQueryParser(field, analyzer);
        Query query = queryParser.parse(keywords);
        SortField sortField = new SortField("id", SortField.Type.INT,true);//默认是升序
        Sort sort = new Sort();
        sort.setSort(sortField);
        TopDocs docs = indexSearcher.search(query, 100, sort);
        ScoreDoc[] scoreDocs=docs.scoreDocs;
        for (int i = 0; i < scoreDocs.length; i++) {
            int id=scoreDocs[i].doc;
            Document document=indexSearcher.doc(id);
            System.out.println(document.get("id"));
            System.out.println(document.get("title"));
            System.out.println(document.get("content"));
        }

    }

}

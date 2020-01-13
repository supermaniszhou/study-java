package com.test;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.LogDocMergePolicy;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.nio.file.Paths;

/**
 * 周刘成   2020-1-11
 */
public class TestOptimise {

    @Test
    public void testOptimise() throws Exception {
        Directory directory = FSDirectory.open(Paths.get("optimise"));
        Analyzer analyzer = new IKAnalyzer(true);
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        LogDocMergePolicy mergePolicy=new LogDocMergePolicy();
        /**
         *
         * 1:mergeFactor
         *
         * 当这个值越小，更少的内存被运用在创建索引的时候，搜索的时候越快，创建索引的时候越慢..
         *
         * 当这个值越大，更多的内存被运用在创建索引的时候，搜索的时候越慢，创建的时候越快...
         *
         *
         * smaller  value   2 < smaller  value  <10
         *
         */
        mergePolicy.setMergeFactor(6);
        config.setMergePolicy(mergePolicy);
        IndexWriter indexWriter = new IndexWriter(directory, config);

    }
}

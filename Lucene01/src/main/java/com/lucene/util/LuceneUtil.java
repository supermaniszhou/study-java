package com.lucene.util;

import com.lucene.common.ComContants;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * 周刘成   2020-1-6
 */
public class LuceneUtil {

    private static Directory directory = null;

    static {
        try {
            directory = FSDirectory.open(Paths.get(ComContants.INDEX_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static IndexWriter getIndexWriter() throws IOException {
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, config);
        return indexWriter;
    }

    public static IndexSearcher getIndexSearcher() throws IOException {
        IndexReader reader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(reader);
        return searcher;
    }

    public static Analyzer getAnalyzer() {
        Analyzer analyzer = new StandardAnalyzer();
        return analyzer;
    }
}

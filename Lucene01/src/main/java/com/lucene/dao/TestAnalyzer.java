package com.lucene.dao;

import com.lucene.util.IKAnalyzer4Lucene8;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;

/**
 * 周刘成   2020-1-9
 */
public class TestAnalyzer {

    public static void main(String[] args) throws Exception {
//        Analyzer analyzer = new StandardAnalyzer();
        Analyzer analyzer = new IKAnalyzer();
        String text = "hello, 牛传智播客我的世界丰富多彩";
        tset(analyzer, text);
    }

    public static void tset(Analyzer analyzer, String text) throws IOException {
        TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(text));
        tokenStream.addAttribute(CharTermAttribute.class);
        tokenStream.reset();
        while (tokenStream.incrementToken()) {
            CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
            System.out.println(charTermAttribute.toString());
        }
    }

    @Test
    public void testStandar() throws Exception {
        //
//        Analyzer analyzer = new IKAnalyzer4Lucene8(false);
        Analyzer analyzer=new IKAnalyzer(false);
        String etext = "Analysis is one of the main causes of slow indexing. Simply put, the more you analyze the slower analyze the indexing (in most cases).";
        String chineseText = "张三说的确实在理。传智播客";
        TokenStream ts = analyzer.tokenStream("content", chineseText);
        ts.reset();
        CharTermAttribute charTermAttribute = ts.getAttribute(CharTermAttribute.class);
        while (ts.incrementToken()) {
            System.out.print(charTermAttribute + "|");
        }
        ts.end();
        ts.close();

    }

}

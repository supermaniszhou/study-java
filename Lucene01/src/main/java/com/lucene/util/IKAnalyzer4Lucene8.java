package com.lucene.util;

import org.apache.lucene.analysis.Analyzer;

/**
 * 周刘成   2020-1-10
 */
public class IKAnalyzer4Lucene8 extends Analyzer {

    private boolean useSmart=false;

    public IKAnalyzer4Lucene8() {
    }

    public IKAnalyzer4Lucene8(boolean useSmart) {
        this.useSmart = useSmart;
    }

    public boolean isUseSmart() {
        return useSmart;
    }

    public void setUseSmart(boolean useSmart) {
        this.useSmart = useSmart;
    }

    @Override
    protected TokenStreamComponents createComponents(String s) {
        IKTokenizer4Lucene8 tokenizer=new IKTokenizer4Lucene8(this.useSmart);
        return new TokenStreamComponents(tokenizer);
    }
}

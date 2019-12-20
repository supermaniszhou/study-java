package com.zhou.listener.demo2;

/**
 * 周刘成   2019-12-19
 */
public class StudentEvent {

    private Object source;

    public StudentEvent(Object source) {
        this.source = source;
    }

    public Object getSource() {
        return source;
    }
}

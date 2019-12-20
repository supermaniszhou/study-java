package com.zhou.listener.demo2;

/**
 * 周刘成   2019-12-19
 */
public class Student {
    private String name;

    private StudentListener listener;

    public void study() {
        if (listener != null) {
            listener.preStudy(new StudentEvent(this));
        }
        System.out.println(getName() + "在学习");
    }

    public void sleep() {
        if (listener != null) {
            listener.preSleep(new StudentEvent(this));
        }
        System.out.println(getName() + "在睡觉");
    }

    public void setListener(StudentListener listener) {
        this.listener = listener;
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

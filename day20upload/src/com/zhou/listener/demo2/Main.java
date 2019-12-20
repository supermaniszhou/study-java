package com.zhou.listener.demo2;

/**
 * 周刘成   2019-12-19
 */
public class Main {
    public static void main(String[] args) {
        Student s = new Student("云云");
        s.setListener(new StudentListener() {
            @Override
            public void preStudy(StudentEvent event) {
                Student student = (Student) event.getSource();
                System.out.println(student.getName() + "别学的太晚了");
            }

            @Override
            public void preSleep(StudentEvent event) {
                Student student2 = (Student) event.getSource();
                System.out.println(student2.getName() + "睡觉前讲个鬼故事吧");
            }
        });
        s.sleep();
        s.study();
    }
}

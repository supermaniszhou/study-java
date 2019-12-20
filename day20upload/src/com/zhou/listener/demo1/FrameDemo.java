package com.zhou.listener.demo1;

import java.awt.*;

/**
 * 周刘成   2019-12-19
 */
public class FrameDemo {
    public static void main(String[] args) {
        Frame f = new Frame("我的小窗口");
        f.setSize(600, 400);
        f.addWindowListener(new MyWindowListener());
        f.setVisible(true);
    }
}

package com.zhou.listener.demo1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 周刘成   2019-12-19
 */
public class MyWindowListener extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        Frame f = (Frame) e.getSource();
        f.dispose();
    }
}

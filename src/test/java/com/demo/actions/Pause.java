package com.demo.actions;

public class Pause {
    public static void forMilliseconds(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.demo.actions;

public class Pause {
    public static void  forMilliseconds(long duration) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

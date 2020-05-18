package com.demo.data;

public class RandomEmail {
    public static String address() {
        return "test_user_" + System.currentTimeMillis() + "@acme.com";
    }
}

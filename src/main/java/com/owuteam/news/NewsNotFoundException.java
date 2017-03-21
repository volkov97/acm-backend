package com.owuteam.news;

public class NewsNotFoundException extends Exception {

    public NewsNotFoundException(String message) {
        super(message);
    }

    public NewsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
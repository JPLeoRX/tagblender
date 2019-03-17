package com.tekleo.tagblender.api;

public class TagblenderApiFactory {
    public static TagblenderApi create() {
        return new TagblenderApiImpl();
    }
}
package com.tekleo.tagblender.parser;

public class TagblenderParserFactory {
    public static TagblenderParser create() {
        return new TagblenderParserImpl();
    }
}
package com.tekleo.tagblender.parser;

import com.tekleo.tagblender.objects.Tagblender;
import org.jsoup.nodes.Document;

public interface TagblenderParser {
    Tagblender parse(Document document) throws TagblenderParserException;
}
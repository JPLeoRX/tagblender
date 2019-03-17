package com.tekleo.tagblender.api;

import com.tekleo.tagblender.objects.Tagblender;
import com.tekleo.tagblender.parser.TagblenderParser;
import com.tekleo.tagblender.parser.TagblenderParserFactory;
import org.jsoup.Jsoup;

public class TagblenderApiImpl implements TagblenderApi {
    private static final String URL = "https://www.tagblender.net/";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0";
    private static final String REFERRER = "http://www.google.com";
    private final TagblenderParser parser = TagblenderParserFactory.create();

    @Override
    public Tagblender get() throws TagblenderApiException {
        try {
            return parser.parse(Jsoup.connect(URL).userAgent(USER_AGENT).referrer(REFERRER).get());
        } catch (Exception e) {
            throw new TagblenderApiException(e);
        }
    }
}
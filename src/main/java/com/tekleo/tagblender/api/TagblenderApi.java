package com.tekleo.tagblender.api;

import com.tekleo.tagblender.objects.Tagblender;

public interface TagblenderApi {
    Tagblender get() throws TagblenderApiException;
}
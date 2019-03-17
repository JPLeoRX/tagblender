package com.tekleo.tagblender.api;

import com.tekleo.tagblender.objects.Tagblender;
import com.tekleo.tagblender.objects.TagblenderCategory;
import com.tekleo.tagblender.objects.TagblenderSubCategory;
import org.junit.Test;

import static org.junit.Assert.*;

public class TagblenderApiTest {
    private TagblenderApi api = TagblenderApiFactory.create();

    @Test
    public void test() {
        Tagblender tagblender = null;
        boolean exceptions = false;

        try {
            tagblender = api.get();
        } catch (Exception e) {
            exceptions = true;
        }

        // Make sure api call went fine
        assertNotNull(tagblender);
        assertFalse(exceptions);

        // Make sure page loaded successfully
        assertFalse(tagblender.getCategories().isEmpty());
        assertEquals(25, tagblender.getCategories().size());

        // Make sure each category has content
        for (TagblenderCategory category : tagblender.getCategories()) {
            assertFalse(category.getName().isEmpty());
            assertFalse(category.getSubCategories().isEmpty());

            // Make sure each sub category has content
            for (TagblenderSubCategory subCategory : category.getSubCategories()) {
                assertFalse(subCategory.getName().isEmpty());
                assertFalse(subCategory.getHashtags().isEmpty());
            }
        }
    }
}
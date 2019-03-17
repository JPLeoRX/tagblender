package com.tekleo.tagblender.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TagblenderSubCategory implements Serializable, Cloneable {
    private String name;
    private List<String> hashtags;

    public TagblenderSubCategory(String name, List<String> hashtags) {
        this.name = name;
        this.hashtags = hashtags;
    }

    public String getName() {
        return name;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagblenderSubCategory that = (TagblenderSubCategory) o;
        return Objects.equals(name, that.name) && Objects.equals(hashtags, that.hashtags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hashtags);
    }

    @Override
    public String toString() {
        return "TagblenderSubCategory{" +
                "name='" + name + '\'' +
                ", hashtags=" + hashtags +
                '}';
    }

    @Override
    protected TagblenderSubCategory clone() {
        return new TagblenderSubCategory(name, new ArrayList<>(hashtags));
    }
}
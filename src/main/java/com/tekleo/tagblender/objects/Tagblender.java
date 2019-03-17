package com.tekleo.tagblender.objects;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Tagblender implements Serializable, Cloneable {
    private List<TagblenderCategory> categories;

    public Tagblender(List<TagblenderCategory> categories) {
        this.categories = categories;
    }

    public List<TagblenderCategory> getCategories() {
        return categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tagblender that = (Tagblender) o;
        return Objects.equals(categories, that.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categories);
    }

    @Override
    public String toString() {
        return "Tagblender{" +
                "categories=" + categories +
                '}';
    }

    @Override
    protected Tagblender clone() {
        return new Tagblender(categories.stream().map(TagblenderCategory::clone).collect(Collectors.toList()));
    }
}
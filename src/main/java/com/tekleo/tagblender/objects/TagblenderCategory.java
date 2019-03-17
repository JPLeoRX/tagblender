package com.tekleo.tagblender.objects;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TagblenderCategory implements Serializable, Cloneable {
    private String name;
    private List<TagblenderSubCategory> subCategories;

    public TagblenderCategory(String name, List<TagblenderSubCategory> subCategories) {
        this.name = name;
        this.subCategories = subCategories;
    }

    public String getName() {
        return name;
    }

    public List<TagblenderSubCategory> getSubCategories() {
        return subCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagblenderCategory that = (TagblenderCategory) o;
        return Objects.equals(name, that.name) && Objects.equals(subCategories, that.subCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subCategories);
    }

    @Override
    public String toString() {
        return "TagblenderCategory{" +
                "name='" + name + '\'' +
                ", subCategories=" + subCategories +
                '}';
    }

    @Override
    protected TagblenderCategory clone() {
        return new TagblenderCategory(name, subCategories.stream().map(TagblenderSubCategory::clone).collect(Collectors.toList()));
    }
}
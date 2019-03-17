package com.tekleo.tagblender.parser;

import com.tekleo.tagblender.objects.Tagblender;
import com.tekleo.tagblender.objects.TagblenderCategory;
import com.tekleo.tagblender.objects.TagblenderSubCategory;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TagblenderParserImpl implements TagblenderParser {
    @Override
    public Tagblender parse(Document document) throws TagblenderParserException {
        return parseInternal(document);
    }

    private static Tagblender parseInternal(Document document) throws TagblenderParserException {
        try {
            // Find names and containers
            Elements categoryNames = document.getElementsByClass("categoryName");
            Elements categoryContainers = document.getElementsByClass("categoryContainer");

            // Create a list of categories
            List<TagblenderCategory> categories = new ArrayList<>(categoryContainers.size());

            // For each category
            for (int i = 0; i < categoryContainers.size(); i++) {
                // Find name and container
                String categoryName = categoryNames.get(i).text().replace("*", "").replace(" (Requests)", "");
                Element categoryContainer = categoryContainers.get(i);

                // Add new category
                categories.add(toCategory(categoryName, categoryContainer));
            }

            // Return tagblender
            return new Tagblender(categories);
        }

        catch (Exception e) {
            throw new TagblenderParserException(e);
        }
    }

    private static TagblenderCategory toCategory(String categoryName, Element categoryContainer) throws TagblenderParserException {
        try {
            // Find tag block rows from container
            Elements tagBlockRows = categoryContainer.getElementsByClass("tagBlockRow");

            // Create a list of subcategories
            List<TagblenderSubCategory> subCategories = new ArrayList<>(tagBlockRows.size());

            // For each tag blocks
            for (Element tagBlockRow : tagBlockRows)
                subCategories.add(toSubCategory(tagBlockRow));

            // Return category
            return new TagblenderCategory(categoryName, subCategories);
        }

        catch (Exception e) {
            throw new TagblenderParserException(e);
        }
    }

    private static TagblenderSubCategory toSubCategory(Element tagBlockRow) throws TagblenderParserException {
        try {
            // Find name and tag box
            String tagBlockName = tagBlockRow.getElementsByTag("h2").get(0).text();
            String tagBox = tagBlockRow.getElementsByClass("tagBox").get(0).text();
            List<String> tags = Arrays.asList(tagBox.replace("#", "").split(" "));

            // Return sub categories
            return new TagblenderSubCategory(tagBlockName, tags);
        }

        catch (Exception e) {
            throw new TagblenderParserException(e);
        }
    }
}
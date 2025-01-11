package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private final String tittle;
    private final String text;

    public Article(String tittle, String text) {
        this.tittle = tittle;
        this.text = text;
    }

    @Override
    public String toString() {
        return tittle + '\n' + text;
    }


    @Override
    public String getSearchTerm() {
        return this + " " + getTypeContent();
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() {
        return tittle + "\nТип - ARTICLE";
    }

    public String getTittle() {
        return tittle;
    }

    public String getText() {
        return text;
    }
}

package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {

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
    }

    @Override
    public String getTypeContent() {
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

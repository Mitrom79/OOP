package org.skypro.skyshop.search;

public interface Searchable {
    String getSearchTerm();

    String getTypeContent();

    String getName();


    default String getStringRepresentation() {
        return "имя" + getName() + "-объекта - тип" + getTypeContent() + "-объекта";
    }
}

package org.skypro.skyshop.search;

import org.skypro.skyshop.comparator.TheLongestInverseOrderComparator;
import org.skypro.skyshop.exception.BestResultNotFoundException;

import java.util.*;

public class SearchEngine {
    Set<Searchable> searchables;

    public SearchEngine() {
        searchables = new HashSet<>();
    }

    public Set<Searchable> search(String searchTerm) {
        Set<Searchable> results = new TreeSet<>(new TheLongestInverseOrderComparator());
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(searchTerm)) {
                results.add(searchable);
            }
        }
        return results;
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Searchable getBestMatchSearchTerm(String search) throws BestResultNotFoundException {
        Searchable bestMatch = null;
        int bestCount = 0;

        for (Searchable searchable : searchables) {
            int newCount = countSubstrings(searchable.toString(), search);
            if (newCount > bestCount) {
                bestCount = newCount;
                bestMatch = searchable;
            }
        }

        if(bestMatch == null) throw new BestResultNotFoundException("Для " + search + " запроса не нашлось подходящей статьи");
        return bestMatch;
    }

    private int countSubstrings(String str, String subStr) {
        if (str == null || subStr == null || subStr.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;
        int subIndex = str.indexOf(subStr, index);

        while(subIndex != -1){
            count++;
            index = index + subStr.length();
            subIndex = str.indexOf(subStr, index);
        }

        return count;
    }
}
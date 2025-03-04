package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFoundException;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        SimpleProduct product1 = new SimpleProduct("Чипсы", 100);
        DiscountedProduct product2 = new DiscountedProduct("Молоко", 50, 10);
        DiscountedProduct product3 = new DiscountedProduct("Хлеб", 30, 5);
        SimpleProduct product3_1 = new SimpleProduct("Хлеб", 90);
        FixPriceProduct product4 = new FixPriceProduct("Печенье");
        FixPriceProduct product5 = new FixPriceProduct("Пепси");
        SimpleProduct product6 = new SimpleProduct("Сосиски", 200);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);
        basket.addProduct(product3_1);

        basket.printBasket();


        List removedProducts = basket.removeProduct("Хлеб");
        basket.printBasket();
        System.out.println("Удаленные товары: " + removedProducts);

        List removedProductsTry = basket.removeProduct("Торт");
        if (removedProductsTry.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            basket.printBasket();
        }
        System.out.println("Удаленные товары: " + removedProductsTry);

        System.out.println("Цена корзины: " + basket.fullPrice() + " руб.");

        System.out.println(basket.isHasProduct("Пепси"));
        System.out.println(basket.isHasProduct("Колбаса"));

        basket.deleteBasket();
        basket.printBasket();
        System.out.println(basket.fullPrice());
        System.out.println(basket.isHasProduct("Колбаса"));

        System.out.println("\n===SearchEngine===\n");

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(product6);

        Article article1 = new Article("Название статьи 1", "Текст статьи 1");
        Article article2 = new Article("Название статьи 2", "Текст статьи 2");
        Article article3 = new Article("Название статьи 3", "Текст статьи 3");
        Article article4 = new Article("Название статьи 4", "Текст статьи 4");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);

        Map<String, Searchable> searchResults = searchEngine.search("PRODUCT");
        for (Map.Entry<String, Searchable> result : searchResults.entrySet()) {
            if (result == null) continue;
            System.out.println(result);
        }
        System.out.println();

        searchResults = searchEngine.search("ARTICLE");
        for (Map.Entry<String, Searchable> result : searchResults.entrySet()) {
            if(result == null) continue;
            System.out.println(result);
        }
        System.out.println();

        searchResults = searchEngine.search("Кола");
        for (Map.Entry<String, Searchable> result : searchResults.entrySet()) {
            if(result == null) continue;
            System.out.println(result);
        }


        System.out.println();
        System.out.println("Exceptions");
        ProductBasket basketTryException = new ProductBasket();

        try {
            basketTryException.addProduct(new SimpleProduct("   ", 12));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            basketTryException.addProduct(new SimpleProduct("kkk", 0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            basketTryException.addProduct(new DiscountedProduct("fff", 12, 120));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            basketTryException.addProduct(new DiscountedProduct("hhh", 12, -12));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            basketTryException.addProduct(new DiscountedProduct(null, 12, 120));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(searchEngine.getBestMatchSearchTerm("rrr"));
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(searchEngine.getBestMatchSearchTerm("xxx"));
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
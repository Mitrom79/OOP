package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product("Чипсы", 100);
        Product product2 = new Product("Молоко", 50);
        Product product3 = new Product("Хлеб", 30);
        Product product4 = new Product("Печенье", 60);
        Product product5 = new Product("Пепси", 70);
        Product product6 = new Product("Сосиски", 200);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);

        basket.printBasket();

        System.out.println("Цена корзины: " + basket.fullPrice() + " руб.");

        System.out.println(basket.isHasProduct("Пепси"));
        System.out.println(basket.isHasProduct("Колбаса"));

        basket.deleteBasket();
        basket.printBasket();
        System.out.println(basket.fullPrice());
        System.out.println(basket.isHasProduct("Колбаса"));

    }
}
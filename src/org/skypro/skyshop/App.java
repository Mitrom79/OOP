package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        SimpleProduct product1 = new SimpleProduct("Чипсы", 100);
        DiscountedProduct product2 = new DiscountedProduct("Молоко", 50, 10);
        DiscountedProduct product3 = new DiscountedProduct("Хлеб", 30, 5);
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
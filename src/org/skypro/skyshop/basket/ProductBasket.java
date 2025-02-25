package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public class ProductBasket {
    private LinkedList<Product> basket;

    public ProductBasket() {
        basket = new LinkedList<>();
    }

    public void addProduct(Product product) {
        basket.add(product);
    }

    public List removeProduct(String name) {
        if (basket.isEmpty()) return new ArrayList<Product>();
        ArrayList<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = basket.iterator();
        while(iterator.hasNext()) {
            Product p = iterator.next();
            if(p.getName().equals(name)) {
                removedProducts.add(p);
                iterator.remove();
            };
        }
        return removedProducts;
    }


    public int fullPrice() {
        if (basket.isEmpty()) return 0;
        int fullPrice = 0;
        for (Product product : basket) {
            fullPrice += product.getPrice();
        }
        return fullPrice;
    }

    public void printBasket() {
        StringBuilder basketPrint = new StringBuilder();
        for (Product product : basket) {

            basketPrint.append(product.getName()).append(": ").append(product.getPrice()).append("\n");
        }
        System.out.println(basketPrint);
        if (basketPrint.isEmpty()) {
            basketPrint.append("В корзине пусто");
        }
        System.out.println(basketPrint);
    }

    public boolean isHasProduct(String name) {
        if (basket.isEmpty()) return false;
        for (Product product : basket) {
            if (product.getName().equals(name)) return true;
        }
        return false;
    }

    public void deleteBasket() {
        basket = new LinkedList<>();
    }
}

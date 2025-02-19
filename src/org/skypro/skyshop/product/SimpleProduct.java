package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;
    public SimpleProduct(String name, int price) {
        super(name);
        if(price <= 0) throw new IllegalArgumentException("Цена не может быть отрицательной или равной 0");
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }


}

package com.accenture.session1.homework.ex2;

import com.accenture.session1.homework.ex1.Category;
import com.accenture.session1.homework.ex1.Product;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var shop = new Shop();
        shop.add(new Product("Product 1", 10, List.of(Category.ELECTRONICS)),20);
        shop.add(new Product("Product 2", 12, List.of(Category.ELECTRONICS)),30);

        shop.buy("Product 1", 10);
        shop.buy("Product 1", 11);

        shop.printStock();
    }
}

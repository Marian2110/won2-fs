package com.accenture.session1.homework.ex2;

import com.accenture.session1.homework.ex1.Product;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Shop {
    private final Set<Product> products;
    private final Map<String, Integer> stock;

    public Shop() {
        this.products = new java.util.HashSet<>();
        this.stock = new java.util.HashMap<>();
    }

    public void add(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product is null");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity is negative");
        }
        if (products.contains(product)) {
            stock.put(product.getName(), stock.get(product.getName()) + quantity);
            return;
        }
        products.add(product);
        stock.put(product.getName(), quantity);
    }

    public void buy(String name, int quantity) {
        if (name == null || !stock.containsKey(name)) {
            throw new IllegalArgumentException("Product is null or doesn't exist");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity is negative");
        }
        int currentQuantity = stock.get(name);
        if (currentQuantity < quantity) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Only " + currentQuantity + " left in stock. Do you want to buy all of them? (y/n)");
            String answer = scanner.nextLine();

            switch (answer) {
                case "y" -> {
                    stock.put(name, 0);
                    System.out.println("Bought only " + currentQuantity + " " + name);
                    return;
                }
                case "n" -> {
                    System.out.println("Thank you! The stock will be updated soon.");
                    return;
                }
                default -> buy(name, quantity);
            }
            return;
        }
        stock.put(name, currentQuantity - quantity);
        System.out.println("Bought " + quantity + " " + name);
    }

    public void printStock() {
        for (String name : stock.keySet()) {
            System.out.println(name + ": " + stock.get(name) + " left");
        }
    }
}


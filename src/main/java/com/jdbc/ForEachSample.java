package com.jdbc;

import java.util.ArrayList;
import java.util.List;

public class ForEachSample {
    public static void main(String[] args) {
        // Creating a list of strings
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Grapes");
        fruits.add("Mango");

        // Using forEach to print each element of the list
        fruits.forEach(fruit -> System.out.println(fruit));

        // Another way of writing it using method reference
        // fruits.forEach(System.out::println);
    }
}

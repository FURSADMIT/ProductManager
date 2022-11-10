package ru.netology.javaqa;

public class Book extends Product {
    protected String author;

    public Book(int id, String name, int cost, String author) {
        super(id, name, cost);
        this.author = author;
    }
}
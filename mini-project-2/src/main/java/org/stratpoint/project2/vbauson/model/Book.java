package org.stratpoint.project2.vbauson.model;

import org.stratpoint.project2.vbauson.model.Category;

public class Book extends Category {
    private String title, author;
    private int isbn;

    public Book(String title, String author, int isbn,  String type) {
        super(type);
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    //getter and setters

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

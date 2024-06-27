package com.vashtibauson.library.model;

import com.vashtibauson.library.model.Category;

public class EBook extends Category {
    private String title, author;
    private int isbn;
    private double fileSize;
    private String format;


    public EBook(String type, String title, String author, int isbn, double fileSize, String format) {
        super(type);
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.fileSize = fileSize;
        this.format = format;
    }

    //getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}

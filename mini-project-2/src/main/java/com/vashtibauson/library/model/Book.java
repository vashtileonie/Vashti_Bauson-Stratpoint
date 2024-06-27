package com.vashtibauson.library.model;

/**
 * Represents a physical book extending the Category class.
 */
public class Book extends Category {

    private String title, author; // Title and author of the book
    private int isbn; // ISBN number of the book

    /**
     * Constructs a new Book object with the specified title, author, ISBN, and type.
     *
     * @param title  The title of the book
     * @param author The author of the book
     * @param isbn   The ISBN number of the book
     * @param type   The type of the book (e.g., "Book")
     */
    public Book(String title, String author, int isbn, String type) {
        super(type); // Call the constructor of the superclass with the provided type
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    /**
     * Returns the author of the book.
     *
     * @return The author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     *
     * @param author The author of the book to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Returns the ISBN number of the book.
     *
     * @return The ISBN number of the book
     */
    public int getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN number of the book.
     *
     * @param isbn The ISBN number of the book to set
     */
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    /**
     * Returns the title of the book.
     *
     * @return The title of the book
     */
    public String getTitle() {
        return title;
    }
}

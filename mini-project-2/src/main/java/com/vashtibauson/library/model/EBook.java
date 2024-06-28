package com.vashtibauson.library.model;

/**
 * Concrete subclass representing an E-Book.
 */
public class EBook extends Category {

    private String title;   // Title of the E-Book
    private String author;  // Author of the E-Book
    private int isbn;       // ISBN of the E-Book
    private double fileSize;    // File size of the E-Book in MB
    private String format;  // Format of the E-Book file

    /**
     * Constructs a new EBook object with the specified properties.
     *
     * @param type     The type of the E-Book (e.g., "E-Book")
     * @param title    The title of the E-Book
     * @param author   The author of the E-Book
     * @param isbn     The ISBN of the E-Book
     * @param fileSize The file size of the E-Book in MB
     * @param format   The format of the E-Book file
     */
    public EBook(String type, String title, String author, int isbn, double fileSize, String format) {
        super(type);
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.fileSize = fileSize;
        this.format = format;
    }

    /**
     * Retrieves the title of the E-Book.
     *
     * @return The title of the E-Book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the E-Book.
     *
     * @param title The new title of the E-Book
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the author of the E-Book.
     *
     * @return The author of the E-Book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the E-Book.
     *
     * @param author The new author of the E-Book
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Retrieves the ISBN of the E-Book.
     *
     * @return The ISBN of the E-Book
     */
    public int getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of the E-Book.
     *
     * @param isbn The new ISBN of the E-Book
     */
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    /**
     * Retrieves the file size of the E-Book.
     *
     * @return The file size of the E-Book in MB
     */
    public double getFileSize() {
        return fileSize;
    }

    /**
     * Sets the file size of the E-Book.
     *
     * @param fileSize The new file size of the E-Book in MB
     */
    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * Retrieves the format of the E-Book file.
     *
     * @return The format of the E-Book file
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the format of the E-Book file.
     *
     * @param format The new format of the E-Book file
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Prints the type of the E-Book.
     */
    @Override
    public void printType() {
        System.out.println("This is an E-Book.");
    }
}

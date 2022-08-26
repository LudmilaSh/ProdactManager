package ru.netology.ProductManager;

public class Book extends Product {
    protected String bookName;
    protected String author;

    public Book(int id, String productName, int price, String bookName, String author) {
        super(id, productName, price);
        this.bookName = bookName;
        this.author = author;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}

package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1, "book1", 100, "First", "Pushkin");
    Product book2 = new Book(2, "book2", 200, "Second", "Esenin");
    Product book3 = new Book(3, "book3", 300, "Third", "Lermontov");
    Product smartphone1 = new Smartphone(4, "smartphone1", 3_000, "A1", "Nokia");
    Product smartphone2 = new Smartphone(5, "smartphone2", 10_000, "A2", "Samsung");
    Product smartphone3 = new Smartphone(6, "smartphone3", 20_000, "A3", "Redmi");

    @Test
    public void searchByBook() {
        manager.save(book1);
        manager.save(book2);
        manager.save(book3);
        manager.save(smartphone1);
        manager.save(smartphone2);
        manager.save(smartphone3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = manager.searchBy("book");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNoNameProduct() {
        manager.save(book1);
        manager.save(book2);
        manager.save(book3);
        manager.save(smartphone1);
        manager.save(smartphone2);
        manager.save(smartphone3);


        Product[] expected = {};
        Product[] actual = manager.searchBy("lipstick");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByEmptyManager() {
        //     manager.save(book1);
        //     manager.save(book2);
        //     manager.save(book3);
        //     manager.save(smartphone1);
        //     manager.save(smartphone2);
        //     manager.save(smartphone3);


        Product[] expected = {};
        Product[] actual = manager.searchBy("smartphone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBySmartphone() {
        manager.save(book1);
        manager.save(book2);
        manager.save(book3);
        manager.save(smartphone1);
        manager.save(smartphone2);
        manager.save(smartphone3);


        Product[] expected = {smartphone1, smartphone2, smartphone3};
        Product[] actual = manager.searchBy("smartphone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByOneProduct() {
        manager.save(book1);
        manager.save(book2);
        manager.save(book3);
        manager.save(smartphone1);
        manager.save(smartphone2);
        manager.save(smartphone3);


        Product[] expected = {smartphone2};
        Product[] actual = manager.searchBy("smartphone2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTwoProduct() {
        manager.save(book1);
        manager.save(book2);
        manager.save(book3);
        manager.save(smartphone1);
        manager.save(smartphone2);
        manager.save(smartphone3);


        Product[] expected = {book2, smartphone2};
        Product[] actual = manager.searchBy("2");

        Assertions.assertArrayEquals(expected, actual);
    }


}

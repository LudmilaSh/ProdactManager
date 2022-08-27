package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();
    Product book1 = new Book(1, "book", 100, "First", "Pushkin");
    Product book2 = new Book(2, "book", 200, "Second", "Esenin");
    Product book3 = new Book(3, "book", 300, "Third", "Lermontov");
    Product smartphone1 = new Smartphone(4, "smartphone", 3_000, "A1", "Nokia");
    Product smartphone2 = new Smartphone(5, "smartphone", 10_000, "A2", "Samsung");
    Product smartphone3 = new Smartphone(6, "smartphone", 20_000, "A3", "Redmi");


    @Test
    public void shouldRemoveByIdTwoProducts() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
        repository.removeById(2);
        repository.removeById(5);

        Product[] expected = {book1, book3, smartphone1, smartphone3};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdOneProducts() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
        repository.removeById(1);


        Product[] expected = {book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindId() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(8);
        });
    }

    @Test
    public void shouldNotFindNegativeId() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(-100);
        });
    }


}

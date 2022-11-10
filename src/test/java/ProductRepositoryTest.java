import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.*;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product product1 = new Product(1, "Product 1", 100);
    Product product2 = new Product(2, "Product 2", 200);
    Product product3 = new Product(3, "Product 3", 300);

    Book book1 = new Book(4, "Book4", 400, "Author4");
    Book book2 = new Book(5, "Book5", 500, "Author5");
    Book book3 = new Book(6, "Book6", 600, "Author6");

    Smartphone phone1 = new Smartphone(7, "Phone7", 700, "Man7");
    Smartphone phone2 = new Smartphone(8, "Phone8", 800, "Man8");
    Smartphone phone3 = new Smartphone(9, "Phone9", 900, "Man9");

    @BeforeEach
    void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);


    }


    @Test
    void searchByIdTest() {
        Product[] expected = {phone2};
        Product[] actual = manager.searchBy("Phone8");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void getCostTest() {
        int expected = 400;
        int actual = book1.getCost();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeByIdTest() {
        repo.removeById(book2.getId());

        Product[] expected = {product1, product2, product3, book1, book3, phone1, phone2, phone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
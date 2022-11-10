import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.Repository;

public class RepositoryTest {
    Repository repo = new Repository();
    ProductManager manager;
    Book book1;
    Book book2;
    Book book3;
    Smartphone phone1;
    Smartphone phone2;
    Smartphone phone3;

    public RepositoryTest() {
        this.manager = new ProductManager(this.repo);
        this.book1 = new Book(101, "War and Peace", 3000, "Tolstoy");
        this.book2 = new Book(10, "Traitor", 3100, "Mishel");
        this.book3 = new Book(1, "Food", 3800, "Parker");
        this.phone1 = new Smartphone(11, "Apple", 62000, "China");
        this.phone2 = new Smartphone(88, "Xiaomi", 68000, "USA");
        this.phone3 = new Smartphone(105, "Samsung", 32000, "South Korea");
    }

    @BeforeEach
    void setup() {
        this.manager.add(this.book1);
        this.manager.add(this.phone2);
        this.manager.add(this.book3);
        this.manager.add(this.book2);
        this.manager.add(this.phone1);
        this.manager.add(this.phone3);
    }

    @Test
    void searchProductBook() {
        Product[] expected = new Product[]{this.book3};
        Product[] actual = this.manager.searchBy("Food");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchProductPhone() {
        Product[] expected = new Product[]{this.phone1};
        Product[] actual = this.manager.searchBy("Apple");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void getCostTest() {
        int expected = 68000;
        int actual = this.phone2.getPrice();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeByIdTest() {
        this.repo.removeById(this.phone1.getId());
        Product[] expected = new Product[]{this.book1, this.phone2, this.book3, this.book2, this.phone3};
        Product[] actual = this.repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}

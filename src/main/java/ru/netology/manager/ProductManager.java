package ru.netology.manager;
import ru.netology.domain.Product;
import ru.netology.repository.Repository;

public class ProductManager {
    protected Repository repo;

    public ProductManager(Repository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        this.repo.addProduct(product);
    }

    public void removeById(int id) {
        this.repo.removeById(id);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        Product[] var3 = this.repo.findAll();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Product product = var3[var5];
            if (this.matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];

                for(int i = 0; i < result.length; ++i) {
                    tmp[i] = result[i];
                }

                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }

        return result;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}

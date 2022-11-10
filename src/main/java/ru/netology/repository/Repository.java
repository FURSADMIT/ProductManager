package ru.netology.repository;

import ru.netology.domain.Product;

public class Repository {
    protected Product[] products = new Product[0];

    public Repository() {
    }

    public void addProduct(Product product) {
        Product[] tmp = new Product[this.products.length + 1];

        for(int i = 0; i < this.products.length; ++i) {
            tmp[i] = this.products[i];
        }

        tmp[tmp.length - 1] = product;
        this.products = tmp;
    }

    public Product[] findAll() {
        return this.products;
    }

    public void removeById(int id) {
        Product[] tmp = new Product[this.products.length - 1];
        int copyToIndex = 0;
        Product[] var4 = this.products;
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Product product = var4[var6];
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                ++copyToIndex;
            }
        }

        this.products = tmp;
    }
}

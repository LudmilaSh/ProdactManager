package ru.netology.ProductManager;

public class ProductManager {
    protected ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void save(Product product) {
        repo.save(product);
    }

    public void removeById(int id) {
        repo.removeById(id);
    }

    public Product[] findAll() {
        return repo.findAll();
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }

        }
        return result;
    }


    public boolean matches(Product product, String search) {
        if (product.getProductName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}

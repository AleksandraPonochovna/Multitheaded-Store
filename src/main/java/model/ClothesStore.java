package model;

import dao.ProductDao;
import dao.StoreDao;
import dao.jdbc.ProductJDBCDao;
import dao.jdbc.StoreJDBCDao;
import model.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class ClothesStore implements Store {

    private int id;
    private String title;
    private List<Category> categories = new ArrayList<>();
    private static ClothesStore instance;
    private static StoreDao storeDao = new StoreJDBCDao();

    private ClothesStore() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public static Store getInstance() {
        if (instance == null) {
            synchronized (ClothesStore.class) {
                if (instance == null) {
                    instance = new ClothesStore();
                    instance.setId(1);
                    instance = (ClothesStore) storeDao.read(instance);
                }
            }
        }
        return instance;
    }

    public void updatePrice(List<Product> products) {
        ProductDao productDao = new ProductJDBCDao();
        for (Product product : products) {
            productDao.update(product);
        }
    }

    public void addProduct(List<Product> products) {
        for (Category category : instance.getCategories()) {
            for (Product product : products) {
                if (category.getId() == product.getCategoryId())
                    category.getProducts().add(product);
            }
        }
        ProductJDBCDao productsJdbcDao = new ProductJDBCDao();
        for (Product product : products) {
            productsJdbcDao.create(product);
        }
    }

    public void updateProductsStatus(List<Product> products, Status status) {
        ProductDao productDao = new ProductJDBCDao();
        for (Category category : instance.getCategories()) {
            for (Product product : products) {
                if (category.getId() == product.getCategoryId()) {
                    product.setStatus(status);
                    productDao.update(product);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "ClothesStore{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", categories=" + categories +
                '}';
    }

}

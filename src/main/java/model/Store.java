package model;

import model.enums.Status;

import java.util.List;

public interface Store {

    int getId();

    void setId(int id);

    void setTitle(String title);

    void setCategories(List<Category> categories);

    List<Category> getCategories();

    void updatePrice(List<Product> products);

    void addProduct(List<Product> products);

    void updateProductsStatus(List<Product> products, Status status);

}

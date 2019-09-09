package dao;

import model.Product;

import java.util.List;

public interface ProductDao {

    void create(Product product);

    void update(Product product);

    List<Product> getByCategoriesId(int id);

}
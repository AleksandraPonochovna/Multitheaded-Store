package model;

import model.enums.CategoryName;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private int id;
    private int storeId;
    private CategoryName categoryName;
    private List<Product> products = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", storeId=" + storeId +
                ", categoryName=" + categoryName +
                ", products=" + products +
                '}';
    }

}

package model;

import model.enums.Status;

public class Product {

    private int id;
    private float price;
    private String title;
    private Status status;
    private int CategoryId;

    public Product() {
    }

    public Product(int id, float price, String title, Status status, int categoryId) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.status = status;
        CategoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", CategoryId=" + CategoryId +
                '}';
    }

}

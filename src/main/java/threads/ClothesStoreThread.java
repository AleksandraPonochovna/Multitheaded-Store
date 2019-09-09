package threads;

import factory.StoreFactory;
import factory.impl.ElectroStoreFactory;
import factory.impl.StoreCreator;
import model.Category;
import model.Product;
import model.Store;
import model.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class ClothesStoreThread extends Thread {

    private Store store;

    @Override
    public void run() {
        StoreCreator storeCreator = new ElectroStoreFactory();
        StoreFactory storeFactory = storeCreator.createStore("ElectroStore");
        store = storeFactory.getStore();
        System.out.println("Thread ElectroStore was started.");
        addNewProducts();
        updateStatus();
        updatePrice();
        System.out.println("Thread ElectroStore was finished.");
    }

    private void addNewProducts() {
        List<Product> new_products = new ArrayList<>();
        new_products.add(new Product(201, 140.0f, "title1", Status.AVAILABLE, 3));
        new_products.add(new Product(202, 150.0f, "title2", Status.AVAILABLE, 3));
        new_products.add(new Product(203, 160.0f, "title3", Status.AVAILABLE, 3));
        new_products.add(new Product(204, 170.0f, "title4", Status.AVAILABLE, 3));
        new_products.add(new Product(205, 180.0f, "title5", Status.AVAILABLE, 4));
        new_products.add(new Product(206, 190.0f, "title6", Status.AVAILABLE, 4));
        new_products.add(new Product(207, 200.0f, "title7", Status.AVAILABLE, 4));
        new_products.add(new Product(208, 300.0f, "title8", Status.AVAILABLE, 4));
        store.addProduct(new_products);
    }

    private void updateStatus() {
        for (Category category : store.getCategories()) {
            List<Product> productForUpdate = new ArrayList<>();
            if (category.getId() == 3) {
                store.updateProductsStatus(category.getProducts(), Status.ABSENT);
            } else {
                for (Product product : category.getProducts()) {
                    if (product.getId() % 2 != 0) {
                        productForUpdate.add(product);
                    }
                }
                store.updateProductsStatus(productForUpdate, Status.EXPECTED);
            }
        }
    }

    private void updatePrice() {
        for (Category category : store.getCategories()) {
            List<Product> productForUpdate = new ArrayList<>();
            for (Product product : category.getProducts()) {
                if (product.getStatus().equals(Status.AVAILABLE)) {
                    product.setPrice(product.getPrice() * 1.2f);
                    productForUpdate.add(product);
                }
            }
            store.updatePrice(productForUpdate);
        }
    }

}

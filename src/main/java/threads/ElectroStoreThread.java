package threads;

import factory.StoreFactory;
import factory.impl.ClothesStoreFactory;
import factory.impl.StoreCreator;
import model.Category;
import model.Product;
import model.Store;
import model.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class ElectroStoreThread extends Thread {

    private Store store;

    @Override
    public void run() {
        StoreCreator storeCreator = new ClothesStoreFactory();
        StoreFactory storeFactory = storeCreator.createStore("ClothesStore");
        store = storeFactory.getStore();
        System.out.println("Thread ClothesStore was started.");
        addNewProducts();
        updateStatus();
        updatePrice();
        System.out.println("Thread ClothesStore was finished.");
        System.out.println("All threads was finished.");
    }

    private void addNewProducts() {
        List<Product> new_products = new ArrayList<>();
        new_products.add(new Product(301, 12.50f, "name_1", Status.AVAILABLE, 1));
        new_products.add(new Product(302, 15.50f, "name_2", Status.AVAILABLE, 1));
        new_products.add(new Product(303, 166.50f, "name_3", Status.AVAILABLE, 1));
        new_products.add(new Product(304, 18.50f, "name_4", Status.AVAILABLE, 1));
        new_products.add(new Product(305, 2.50f, "name_5", Status.AVAILABLE, 2));
        new_products.add(new Product(306, 175.50f, "name_6", Status.AVAILABLE, 2));
        new_products.add(new Product(307, 146.50f, "name_7", Status.AVAILABLE, 2));
        new_products.add(new Product(308, 100.50f, "name_8", Status.AVAILABLE, 2));
        store.addProduct(new_products);
    }

    private void updateStatus() {
        for (Category category : store.getCategories()) {
            List<Product> productForUpdate = new ArrayList<>();
            if (category.getId() == 1) {
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

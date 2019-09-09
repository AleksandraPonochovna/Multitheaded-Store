package factory.impl;

import factory.ElectroStoreFactory;
import factory.StoreFactory;

public class ClothesStoreFactory implements StoreCreator {

    @Override
    public StoreFactory createStore(String name) {
        if ("ClothesStore".equals(name)){
            return new ElectroStoreFactory();
        }
        return null;
    }
}

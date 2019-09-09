package factory.impl;

import factory.ClothesStoreFactory;
import factory.StoreFactory;

public class ElectroStoreFactory implements StoreCreator {

    @Override
    public StoreFactory createStore(String name) {
        if("ElectroStore".equals(name)){
            return new ClothesStoreFactory();
        }
        return null;
    }

}

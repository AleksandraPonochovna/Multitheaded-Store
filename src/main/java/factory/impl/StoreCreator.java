package factory.impl;

import factory.StoreFactory;

public interface StoreCreator {

    StoreFactory createStore(String name);

}

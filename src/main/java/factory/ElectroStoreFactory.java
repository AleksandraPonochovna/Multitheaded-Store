package factory;

import model.ClothesStore;
import model.Store;

public class ElectroStoreFactory implements StoreFactory {

    @Override
    public Store getStore() {
        return ClothesStore.getInstance();
    }

}
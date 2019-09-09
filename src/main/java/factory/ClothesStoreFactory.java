package factory;

import model.ElectroStore;
import model.Store;

public class ClothesStoreFactory implements StoreFactory {

    @Override
    public Store getStore() {
        return ElectroStore.getInstance();
    }

}
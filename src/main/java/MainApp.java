import threads.ClothesStoreThread;
import threads.ElectroStoreThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {

    public static void main(String[] args) throws InterruptedException {
        long COUNT_OF_MILLISECONDS = 10000;
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Thread clothesStoreThread = new ClothesStoreThread();
        Thread electroStoreThread = new ElectroStoreThread();
        executor.execute(clothesStoreThread);
        Thread.sleep(COUNT_OF_MILLISECONDS);
        executor.execute(electroStoreThread);
        executor.shutdown();
    }

}

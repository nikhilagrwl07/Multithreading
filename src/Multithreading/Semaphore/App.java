package Multithreading.Semaphore;

import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Connection connection = Connection.getConnection();

        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i=1;i<=200;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    connection.connect();
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);

    }
}

package Multithreading.Callable;

/**
 * Created by nikhilagrawal on 10/08/16.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class MyCallableExample implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        int randomNumber = ThreadLocalRandom.current().nextInt(1, 10);
        if (randomNumber > 5) {
            throw new IOException("Number is greater than 5");
        }

        Thread.sleep(1000);

        return randomNumber;
    }
}

class Main {
    public static void main(String args[]) {

        //Get ExecutorService from Executors utility class, thread pool size is 10
        ExecutorService executor = Executors.newFixedThreadPool(10);

        //create a list to hold the Future object associated with Callable
        List<Future<Integer>> list = new ArrayList<>();

        //Create MyCallable instance
        Callable<Integer> callable = new MyCallableExample();

        for (int i = 0; i < 100; i++) {
            //submit Callable tasks to be executed by thread pool
            Future<Integer> future = executor.submit(callable);
            //add Future to the list, we can get return value using Future
            list.add(future);
        }


        for (Future<Integer> fut : list) {
            try {
                //print the return value of Future, notice the output delay in console
                // because Future.get() waits for task to get completed
                System.out.println(fut.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                IOException ioException = (IOException) e.getCause();
                System.out.println(ioException.getMessage());
            }
        }
        //shut down the executor service now
        executor.shutdown();
    }

}

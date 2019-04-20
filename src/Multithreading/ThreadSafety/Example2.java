package Multithreading.ThreadSafety;

/**
 * Created by nikhilagrawal on 10/08/16.
 */
public class Example2 {

    public static void main(String[] args) throws InterruptedException {

        ProcessingRunnable runnable = new ProcessingRunnable();
        Thread t1 = new Thread(runnable, "t1");
        t1.start();
        Thread t2 = new Thread(runnable, "t2");
        t2.start();
        //wait for threads to finish processing
        t1.join();
        t2.join();
        System.out.println("Processing count="+runnable.getCount());
    }

}

class ProcessingRunnable implements Runnable{

    private int count;
    private final Object mutex;

    ProcessingRunnable() {
        mutex = new Object();
    }

    @Override
    public void run() {
        for(int i=1; i < 5; i++){
            processSomething(i);
            synchronized (mutex){
                count++;
            }
        }
    }

    public int getCount() {
        return this.count;
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i*200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
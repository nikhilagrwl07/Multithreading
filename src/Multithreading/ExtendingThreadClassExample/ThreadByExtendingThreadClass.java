package Multithreading.ExtendingThreadClassExample;

/**
 * Created by nikhilagrawal on 10/08/16.
 */

class SimpleThread extends Thread {
    public SimpleThread(String str) {
        super(str);
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println(getName() + " says " + i);
            try {
                sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {

            }
        }
        System.out.println(getName() + " is done.");
    }
}


public class ThreadByExtendingThreadClass {

    public static void main(String[] args) {

        (new SimpleThread("First Thread")).start();
        (new SimpleThread("Second Thread")).start();
        (new SimpleThread("Third Thread")).start();
    }
}


package Multithreading.DiningPhilosopherProblem;

/**
 * Created by nikhilagrawal on 29/08/16.
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Everything about a particular chopstick
class Chopstick {
    public Lock lock;
    public String name;

    public void setName(String s) {
        name = s;
    }

    // type of lock I want to put
    public Chopstick() {
        lock = new ReentrantLock();
    }

    public boolean pickup() {
        System.out.println("Trying to pickup");
        return lock.tryLock();
    }

    public void putDown() {
        System.out.println("ChopStick Put down");
        lock.unlock();
    }

}

// Now class of person (philosopher in this case)
// I am writing for one person

class Philosopher extends Thread {
    private int bites = 10;
    Chopstick left;
    Chopstick right;

    public Philosopher(Chopstick l, Chopstick r) {
        this.left = l;
        this.right = r;
    }

    // Now the function to eat
    public void eat() {
        if (pickup()) {
            chew();
            putDown();
        }

    }

    public void chew() {
        System.out.println(Thread.currentThread().getName() + " started chewing");
        try {
            Thread.sleep(250);
        } catch (InterruptedException ex) {
            System.out.println("Philosopher cannot chew the food");
        }
    }

    public boolean pickup() {

        if (!left.pickup()) {
            return false;
        }
        System.out.println(Thread.currentThread().getName() + " Pickup left chopstick");


        if (!right.pickup()) {
            left.putDown();
            return false;
        }
        System.out.println(Thread.currentThread().getName() + " Pickup right chopstick");

        return true;
    }

    public void putDown() {

        left.putDown();
        System.out.println(Thread.currentThread().getName() + " PutDown left chopstick");
        right.putDown();
        System.out.println(Thread.currentThread().getName() + " PutDown right chopstick");
    }

    @Override
    public void run() {
        // this is for running until stomach of person is full
        for (int i = 0; i < bites; i++) {
            System.out.println(Thread.currentThread().getName() + " Bite number = " + (i + 1));
            eat();
        }
    }


}

public class DiningPhilosopherProblem {
    public static void main(String args[]) {
        // How many chopstick are there on table
        int NumberOfChopSticks = 3, j;
        Chopstick c[] = new Chopstick[NumberOfChopSticks];

        for (j = 0; j < NumberOfChopSticks; j++) {
            c[j] = new Chopstick();
            c[j].setName("C" + (j + 1));
        }


        int NumberOfPhilosopher = 3, i;
        Philosopher p[] = new Philosopher[NumberOfPhilosopher];


        for (i = 0; i < NumberOfPhilosopher; i++) {
            if (i <= NumberOfPhilosopher - 2) {
                p[i] = new Philosopher(c[i], c[i + 1]);
                p[i].setName("P" + (i + 1));
                p[i].start();
            } else {
                p[i] = new Philosopher(c[i], c[0]);
                p[i].setName("P" + (i + 1));
                p[i].start();
            }

        }


    }
}

package Multithreading.Runnable;

/**
 * Created by nikhilagrawal on 10/08/16.
 */


public class RunnableThreadExample implements Runnable {
    public int count = 0;

    @Override
    public void run() {
        System.out.println("Runnable thread starting.");
        try {
            while (count < 5) {
                System.out.println(Thread.currentThread().getName() + " ==>count = " + count);
                Thread.sleep(500);
                count++;
            }
        } catch (InterruptedException exc) {
            System.out.println("Runnable thread interrupted");
        }
        System.out.println("Runnable thread terminating.");
    }
}

class Main {

    public static void main(String args[]) {
        Runnable runnableInstance = new RunnableThreadExample();

        Thread thread = new Thread(runnableInstance);
        thread.setName("Thread 1");

        Thread thread2 = new Thread(runnableInstance);
        thread2.setName("Thread 2");

//No new address will be created and process will run in same add space
//method will simply be executed in the same Thread and new Thread will not be created
        //runnableInstance.run();

//When we call start() method of Thread class Java Virtual machine execute run() method
// of that Thread class into separate Thread other than calling thread.
        thread.start();
        thread2.start();
//        System.gc();

        // Waits until above thread counts to 5(Slowly)
//        while(runnableInstance.count<=5){
//            try{
//                System.out.println("Inside Main ==> count= "+runnableInstance.count);
//                Thread.sleep(250);
//                //runnableInstance.count++;
//            } catch(InterruptedException exc){
//                exc.printStackTrace();
//            }
//        }
    }

}

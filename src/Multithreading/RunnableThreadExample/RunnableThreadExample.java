package Multithreading.RunnableThreadExample;

/**
 * Created by nikhilagrawal on 10/08/16.
 */


public class RunnableThreadExample
{
    private static int count=0;
    public static void main(String args[])
    {
        new Thread(RunnableThreadExample::RunLogic, "Thread1").start();
        new Thread(RunnableThreadExample:: RunLogic , "Thread2").start();
    }

     private static void RunLogic() {
        System.out.println("Runnable thread starting.");
        try{
            while(count<5)
            {
                System.out.println(Thread.currentThread().getName()+" ==>count = "+count);
                Thread.sleep(500);
                count++;
            }
        }
        catch(InterruptedException exc)
        {
            System.out.println("Runnable thread interrupted");
        }

        System.out.println("Runnable thread terminating.");
    }


}

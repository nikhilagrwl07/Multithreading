package Multithreading.Semaphore;

import java.util.concurrent.Semaphore;

public class Connection {

    private static Connection connection = new Connection();

    private int connections = 0;

    // Allowing only 10 concurrent connection with semaphore
    private Semaphore semaphore = new Semaphore(10, true);

    private Connection() {
    }

    public static Connection getConnection(){
        return connection;
    }


    // Reason for creating connect() is - in case if doConnect() throws an exception, then
    // also finally block will execute and release the semaphore
    public void connect(){

        try{
            semaphore.acquire();
            doConnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }

    }

    // function for connecting to database and updating connections variable to hold current count
    public void doConnect() throws InterruptedException {

     // Acquiring connection
        synchronized (this){
            connections++;
            System.out.println("Current connections : " + connections);
        }

        Thread.sleep(2000);

        // Releasing connection
        synchronized (this){
            connections--;
        }
    }
}

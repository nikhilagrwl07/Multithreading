package Multithreading.BankTransaction;

public class Bank implements Runnable{

    private AccountOperation accountOperation = AccountOperationImpl.accountOperation(new Account());

    public static void main(String[] args) {
        Bank ts = new Bank();
        Thread t1 = new Thread(ts, "person 1");
        Thread t2 = new Thread(ts, "person 2");
        Thread t3 = new Thread(ts, "person 3");
        t1.start();
        t2.start();
        t3.start();

       // System.out.println("Final Balance - " + ts.accountOperation.getBal());
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            Transaction transaction = new Transaction(accountOperation);

            transaction.withdraw(100);
            if (accountOperation.getBal() < 0) {
                System.out.println("account is overdrawn!");
            }
            transaction.deposit(200);
        }
    }
}
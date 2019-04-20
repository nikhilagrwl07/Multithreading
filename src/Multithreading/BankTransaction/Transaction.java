package Multithreading.BankTransaction;

public class Transaction {

    private AccountOperation accountOperation;

    public Transaction(AccountOperation accountOperation) {
        this.accountOperation =accountOperation;
    }

     synchronized void withdraw(int bal){
        if (accountOperation.getBal()>=bal) {
            System.out.println(Thread.currentThread().getName()+" balance before withdraw " + accountOperation.getBal());

//            try {
//                Thread.sleep(100);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

            accountOperation.withdraw(bal);
            System.out.println(Thread.currentThread().getName()+" balance after withdraw " + accountOperation.getBal());
        }else{
            System.out.println(Thread.currentThread().getName()+ " doesn't have enough money for withdraw ");
        }
    }

     synchronized void deposit(int bal){
        if (bal>0) {
            System.out.println(Thread.currentThread().getName()+" balance before deposit " + accountOperation.getBal());
//            try {
//                Thread.sleep(100);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            accountOperation.deposit(bal);
            System.out.println(Thread.currentThread().getName()+" balance after deposit " + accountOperation.getBal());
        }else{
            System.out.println(Thread.currentThread().getName()+ " doesn't have enough money for deposit");
        }
    }
}

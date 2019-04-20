package Multithreading.BankTransaction;

public class AccountOperationImpl implements AccountOperation {

    private static Account acc;
    private static AccountOperationImpl accountOperation;

    private AccountOperationImpl() {
    }

    static AccountOperationImpl accountOperation(Account account){
        if(account==null) return null;

        if(accountOperation==null){
            accountOperation = new AccountOperationImpl();
            acc=account;
        }
        return accountOperation;
    }

     public  void withdraw(int bal){
        acc.getBalance().compareAndSet(acc.getBalance().get(), acc.getBalance().get()-bal);
    }

    public  void deposit(int bal){
        acc.getBalance().addAndGet(bal);
    }

    public  Integer getBal() {
        return acc.getBalance().get();
    }
}

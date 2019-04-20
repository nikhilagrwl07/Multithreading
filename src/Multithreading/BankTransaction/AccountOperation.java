package Multithreading.BankTransaction;

public interface AccountOperation {
    void withdraw(int bal);
    void deposit(int bal);
    Integer getBal();
}

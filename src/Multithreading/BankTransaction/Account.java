package Multithreading.BankTransaction;

import java.util.concurrent.atomic.AtomicInteger;

public class Account {
//    private int balance= 1000;

    AtomicInteger balance = new AtomicInteger(1000);

    public AtomicInteger getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance.set(balance);
    }
}

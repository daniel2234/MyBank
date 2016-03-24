package com.example.spiffy.mybank;

/**
 * Created by Spiffy on 3/24/2016.
 */
public class BankAccount {
    private double balance;
    public static final double OVERDRAFT_FEE = 30;

    public void withdraw(double amount){
        balance -= amount;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public double getBalance(){
        return balance;
    }
}

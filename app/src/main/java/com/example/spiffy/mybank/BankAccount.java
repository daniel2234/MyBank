package com.example.spiffy.mybank;

import java.util.ArrayList;

/**
 * Created by Spiffy on 3/24/2016.
 */
public class BankAccount {
    private static final String Tag = "BankAccount";
    private ArrayList<Double> mTransactions;
    public static final double OVERDRAFT_FEE = 30;

    public enum Type{
        CHECKING, SAVINGS;
    }

    private Type mType;

    BankAccount(Type accountType){
        mTransactions = new ArrayList<Double>();
        mType = accountType;
    }

    public void withdraw(double amount){
        if (mType == Type.SAVINGS){
            if (numberOfWithdrawals()  >= 3){
                return;
            }
        }
        mTransactions.add(-amount);

        if (getBalance() < 0){
           mTransactions.add(-OVERDRAFT_FEE);
        }
    }

    private int numberOfWithdrawals(){
        int count = 0;
        for (int i = 0; i < mTransactions.size(); i++){
            if (mTransactions.get(i) < 0){
                count++;
            }
        }
        return count;
    }

    public void deposit(double amount){
        mTransactions.add(amount);
    }

    public double getBalance(){
        double total = 0;
        for (int i = 0; i<mTransactions.size();i++){
            total += mTransactions.get(i);
        }
        return total;
    }
}

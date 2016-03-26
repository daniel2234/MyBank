package com.example.spiffy.accounts;

import com.example.spiffy.accounts.BankAccount;

/**
 * Created by Spiffy on 3/25/2016.
 */
public class SavingsAccount extends BankAccount {
    private static final String TAG = "SavingsAccount";

    @Override
    public void withdraw(double amount) {
        if (numberOfWithdrawals() >=3){
            return;
        }
        super.withdraw(amount);
    }
}

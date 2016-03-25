package com.example.spiffy.mybank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    EditText mAmountInput;
    Button mWithdrawButton;
    Button mDepositButton;
    TextView mAmountDisplay;
    BankAccount currentAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(200);
        arrayList.add(300);

        Log.d(TAG, "Size is " +arrayList.size());

        currentAccount = new BankAccount(BankAccount.Type.CHECKING);

        mAmountDisplay = (TextView)findViewById(R.id.balance_display);
        mDepositButton = (Button) findViewById(R.id.deposit_button);
        mWithdrawButton = (Button) findViewById(R.id.withdraw_button);
        mAmountInput = (EditText)findViewById(R.id.amount_input);

        mWithdrawButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String amount = mAmountInput.getText().toString();
               currentAccount.withdraw(Double.parseDouble(amount));
               mAmountDisplay.setText("Balance is " +currentAccount.getBalance());
           }
       });

        mDepositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = mAmountInput.getText().toString();
                currentAccount.deposit(Double.parseDouble(amount));
                mAmountDisplay.setText("Balance is " + currentAccount.getBalance());
            }
        });

//        View.OnClickListener ocl = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String amount = mAmountInput.getText().toString();
//                mAmountDisplay.setText(amount);
//            }
//        };
//
//        mWithdrawButton.setOnClickListener(ocl);
//        mDepositButton.setOnClickListener(ocl);
    }
}

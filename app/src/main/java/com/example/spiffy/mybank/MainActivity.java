package com.example.spiffy.mybank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    EditText amountInput;
    Button withdrawButton;
    Button depositButton;
    TextView amountDisplay;
    BankAccount currentAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentAccount = new BankAccount();

        amountDisplay = (TextView)findViewById(R.id.balance_display);
        depositButton = (Button) findViewById(R.id.deposit_button);
        withdrawButton = (Button) findViewById(R.id.withdraw_button);
        amountInput = (EditText)findViewById(R.id.amount_input);

        withdrawButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String amount = amountInput.getText().toString();
               currentAccount.withdraw(Double.parseDouble(amount));
               amountDisplay.setText("Balance is " +currentAccount.getBalance());
           }
       });

        depositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = amountInput.getText().toString();
                currentAccount.deposit(Double.parseDouble(amount));
                amountDisplay.setText("Balance is " + currentAccount.getBalance());
            }
        });

//        View.OnClickListener ocl = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String amount = amountInput.getText().toString();
//                amountDisplay.setText(amount);
//            }
//        };
//
//        withdrawButton.setOnClickListener(ocl);
//        depositButton.setOnClickListener(ocl);
    }
}

package com.example.janetaa.dollarconvertion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double amountEntered = 0.0;
    double amountConverted;
    double conversionRate = 19.11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText amount = (EditText) findViewById(R.id.txtAmount);
        final RadioButton USDToMXN = (RadioButton) findViewById(R.id.radUSDToMXN);
        final RadioButton MXNToUSD = (RadioButton) findViewById(R.id.radMXNToUSD);
        Button converter = (Button) findViewById(R.id.btnConverter);
        final TextView result = (TextView) findViewById(R.id.txtResult);

    converter.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {
                 amountEntered = Double.parseDouble(amount.getText().toString());

                 DecimalFormat currency = new DecimalFormat("$###,###.##");
                 if (USDToMXN.isChecked()) {
                     if (amountEntered > 0) {
                         amountConverted = amountEntered * conversionRate;
                         result.setText(currency.format(amountConverted) + " Pesos");
                     } else if (amountEntered <= 0) {
                         Toast.makeText(MainActivity.this, "Please enter the amount you need to convert",
                                 Toast.LENGTH_LONG).show();
                     }

                 }
                 if (MXNToUSD.isChecked()) {
                     if (amountEntered > 0) {
                         amountConverted = amountEntered / conversionRate;
                         result.setText(currency.format(amountConverted) + " Dollars");
                     } else if (amountEntered <= 0) {
                         Toast.makeText(MainActivity.this, "Please enter the amount you need to convert ",
                                 Toast.LENGTH_LONG).show();
                     }
                 }
             }

     } );

    }
}

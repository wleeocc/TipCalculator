package edu.orangecoastcollege.cs273.wlee44.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Associate the controller with the needed views
    private EditText amountEditText;
    private TextView amountTextView;
    private TextView totalTextView;
    private TextView tipTextView;
    private TextView percentTextView;
    private SeekBar percentSeekBar;

    // Associate the controller with the needed model
    RestaurantBill currentBill = new RestaurantBill();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect the controller with the widgets in out app
        amountEditText = (EditText) findViewById(R.id.amountEditText);
        amountTextView = (TextView) findViewById(R.id.amountTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        tipTextView = (TextView) findViewById(R.id.tipTextView);
        percentTextView = (TextView) findViewById(R.id.percentTextView);
        percentSeekBar = (SeekBar) findViewById(R.id.percentSeekBar);

        // Define a listener for the amountEditText (onTextChanged)
        amountEditText.addTextChangedListener(amountTextChangedListener);
    }

    private TextWatcher amountTextChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // Do nothing
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // Try to get the amount from amountEditText
            try {
                double amount = Double.parseDouble(charSequence.toString()) / 100.0;
                currentBill.setAmount(amount);
            }
            catch (NumberFormatException e)
            {
                amountEditText.setText("");
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // Do nothing
        }
    };
}

package id.co.iak.part3lastproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Views
    private EditText edtDistance;
    private EditText edtPrice;
    private EditText edtTips;
    private TextView txtTotalPrice;

    // Const
//    private final static int multiply = 100;

    // Global Data
    private double distance = 0.0;
    private double initialPrice = 3000.0;
    private double tips = 0.0;
    private double discount = 0.0;
    private double totalPrice = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        // init
        edtDistance = (EditText) findViewById(R.id.edt_distance);
        edtPrice = (EditText) findViewById(R.id.edt_price);
        edtTips = (EditText) findViewById(R.id.edt_tips);
        txtTotalPrice = (TextView) findViewById(R.id.txt_totalprice);

        // default value
        edtDistance.setText(Double.toString(distance));
        edtPrice.setText("Rp. " + Double.toString(initialPrice));
        edtTips.setText(Double.toString(tips));
    }

    public void cash(View v) {
        // get value
        distance = Double.parseDouble(edtDistance.getText().toString());
        tips = Double.parseDouble(edtTips.getText().toString());

        // calculate
        double grossPrice = initialPrice * distance;
        double modulus = grossPrice % 100;
        double floor = modulus != 0 ? (100 - modulus) : 0;
        double fixedPrice = grossPrice + floor;
        totalPrice = fixedPrice + tips;

        // display
        edtPrice.setText("Rp. " + Double.toString(fixedPrice));
        txtTotalPrice.setText("Rp. " + Double.toString(totalPrice));
    }

    public void voucher(View v) {
        // get value
        distance = Double.parseDouble(edtDistance.getText().toString());
        tips = Double.parseDouble(edtTips.getText().toString());

        // calculate
        double grossPrice = initialPrice * distance;
        double modulus = grossPrice % 100;
        double floor = modulus != 0 ? (100 - modulus) : 0;
        double fixedPrice = grossPrice + floor;
        discount = fixedPrice * 0.05;
        totalPrice = fixedPrice + tips - discount;

        // display
        edtPrice.setText("Rp. " + Double.toString(fixedPrice));
        txtTotalPrice.setText("Rp. " + Double.toString(totalPrice));
    }
}

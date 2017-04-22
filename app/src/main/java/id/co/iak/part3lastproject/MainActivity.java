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

    // Data
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
        edtDistance = (EditText) findViewById(R.id.edt_distance);
        edtPrice = (EditText) findViewById(R.id.edt_price);
        edtTips = (EditText) findViewById(R.id.edt_tips);
        txtTotalPrice = (TextView) findViewById(R.id.txt_totalprice);

        // default value
        edtDistance.setText(Double.toString(distance));
        edtPrice.setText(Double.toString(initialPrice));
        edtTips.setText(Double.toString(tips));
    }

    public void cash(View v) {
        distance = Double.parseDouble(edtDistance.getText().toString());
        tips = Double.parseDouble(edtTips.getText().toString());
        totalPrice = initialPrice * distance + tips;
        txtTotalPrice.setText("Rp. " + Double.toString(totalPrice));
    }

    public void voucher(View v) {
        distance = Double.parseDouble(edtDistance.getText().toString());
        tips = Double.parseDouble(edtTips.getText().toString());
        discount = ((initialPrice * distance) * 0.05);
        totalPrice = (initialPrice * distance) + tips - discount;
        txtTotalPrice.setText("Rp. " + Double.toString(totalPrice));
    }
}

package id.co.iak.part3lastproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Views
    private TextView txtTotalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        txtTotalPrice = (TextView) findViewById(R.id.txt_totalprice);
    }


    public void cash(View v) {
        txtTotalPrice.setText("Rp. Tunai");
    }

    public void voucher(View v) {
        txtTotalPrice.setText("Rp. Voucher");
    }
}

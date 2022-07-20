package com.example.grosury.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import com.example.grosury.R;

public class ProductDescriptionActivity extends AppCompatActivity {

    TextView buyNow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_description);

        buyNow=findViewById(R.id.buynow);
        buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),BuyActivity.class);
                startActivity(intent);

            }
        });
    }
}
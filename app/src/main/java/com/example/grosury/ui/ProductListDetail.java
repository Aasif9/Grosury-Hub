package com.example.grosury.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import com.example.grosury.Adapter.GridAdapter;
import com.example.grosury.Adapter.ProductDetailAdapter;
import com.example.grosury.Model.GridItem;
import com.example.grosury.Model.ProductDetail;
import com.example.grosury.R;

import java.util.ArrayList;
import java.util.List;

public class ProductListDetail extends AppCompatActivity {

    RecyclerView recyclerDetailView;
    //variables
    private Context mContext;
    private List<ProductDetail> productDetailList;
   TextView plus,minus,quantity,addToCart;
    int count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list_detail);

        plus=findViewById(R.id.quantity_plus);
        minus=findViewById(R.id.quantity_minus);
        quantity=findViewById(R.id.quantity);

        addToCart=findViewById(R.id.add_to_cart);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),BuyActivity.class);
                startActivity(intent);
            }
        });
       /* plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                quantity.setText(String.valueOf(count));
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count>1) {
                    count--;
                }
                quantity.setText(String.valueOf(count));
            }
        });

       */
        productDetailList=new ArrayList<>();

        productDetailList.add(new ProductDetail(R.drawable.fruitveg,"Apple",550,10,"1"));
        productDetailList.add(new ProductDetail(R.drawable.bakery,"Mango",100,15,"1"));
        productDetailList.add(new ProductDetail(R.drawable.oilspices,"Tomato",520,10,"1"));
        productDetailList.add(new ProductDetail(R.drawable.sugargrains,"Apple",500,20,"1"));
        productDetailList.add(new ProductDetail(R.drawable.trop,"Apple",150,30,"1"));
        productDetailList.add(new ProductDetail(R.drawable.trop,"Apple",250,30,"1"));

        recyclerDetailView=findViewById(R.id.recyclerDetailView);
        ProductDetailAdapter productDetailAdapter=new ProductDetailAdapter(this,productDetailList);

        recyclerDetailView.setLayoutManager(new LinearLayoutManager(this));
        recyclerDetailView.setAdapter(productDetailAdapter);
        recyclerDetailView.setHasFixedSize(true);
    }
}
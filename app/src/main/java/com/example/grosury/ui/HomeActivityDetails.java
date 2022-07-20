package com.example.grosury.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

import com.example.grosury.Adapter.BestSellerAdapter;
import com.example.grosury.Adapter.GridAdapter;
import com.example.grosury.Adapter.SliderAdapter;
import com.example.grosury.Adapter.TopSellerAdapter;
import com.example.grosury.MainActivity;
import com.example.grosury.Model.BestSeller;
import com.example.grosury.Model.GridItem;
import com.example.grosury.Model.TopSeller;
import com.example.grosury.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivityDetails extends AppCompatActivity {

    SliderView sliderView;

    int[] images = {R.drawable.fruit,
            R.drawable.bakery,
            R.drawable.beverages,
            R.drawable.homeappliance,
            R.drawable.household,
            R.drawable.oilspices
    };

    private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    RecyclerView recyclerView, bestProductRecyclerView, topBrandRecyView;
    //variables
    private Context mContext;
    private List<GridItem> productList;
    private List<BestSeller> bestSell;
    private List<TopSeller> topSell;
     TextView hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity_details);

        sliderView = findViewById(R.id.imageSlider);

        SliderAdapter sliderAdapter = new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();



        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                Log.i("GGG", "onIndicatorClicked: " + sliderView.getCurrentPagePosition());
            }
        });


        productList = new ArrayList<>();

        productList.add(new GridItem(R.drawable.fruit, "Fruit"));
        productList.add(new GridItem(R.drawable.fruitveg, "Vegetables"));
        productList.add(new GridItem(R.drawable.oilspices, "Oil & Spices"));
        productList.add(new GridItem(R.drawable.sugargrains, "Sugar & Salt"));
        productList.add(new GridItem(R.drawable.beverages, "Beverages & Drinks"));
        productList.add(new GridItem(R.drawable.bakery1, "Bakery"));
        productList.add(new GridItem(R.drawable.atta, "Atta ,Rice & Dal"));
        productList.add(new GridItem(R.drawable.species, "Masala"));
        productList.add(new GridItem(R.drawable.sauces, "Sauces & Spreads"));


        recyclerView = findViewById(R.id.recyclerView);

        GridAdapter gridAdapter = new GridAdapter(this, productList);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(gridAdapter);
        recyclerView.setHasFixedSize(true);

        // myRef= FirebaseDatabase.getInstance().getReference();


        hello = findViewById(R.id.hello);
        hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BuyActivity.class);
                startActivity(intent);
            }
        });


        bestSell = new ArrayList<>();

        bestSell.add(new BestSeller(R.drawable.fruit));
        bestSell.add(new BestSeller(R.drawable.fruit));
        bestSell.add(new BestSeller(R.drawable.fruit));
        bestSell.add(new BestSeller(R.drawable.fruit));



        //bestRecycler View
        bestProductRecyclerView=findViewById(R.id.bestHorizontalRecycler);
        bestProductRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);


        topSell = new ArrayList<>();


        topSell.add(new TopSeller(R.drawable.fruit));
        topSell.add(new TopSeller(R.drawable.fruit));
        topSell.add(new TopSeller(R.drawable.fruit));
        topSell.add(new TopSeller(R.drawable.fruit));
        topSell.add(new TopSeller(R.drawable.fruit));



        BestSellerAdapter bestSellerAdapter=new BestSellerAdapter(bestSell);

        bestProductRecyclerView.setAdapter(bestSellerAdapter);
        bestProductRecyclerView.setHasFixedSize(true);


        //top Recycler View
        topBrandRecyView=findViewById(R.id.topHorizontalRecycler);
        topBrandRecyView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);

        TopSellerAdapter topSellerAdapter=new TopSellerAdapter(topSell);
        topBrandRecyView.setAdapter(topSellerAdapter);
        topBrandRecyView.setHasFixedSize(true);


    }

}

package com.example.grosury;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grosury.Adapter.SliderAdapter;
import com.example.grosury.Model.SliderItem;
import com.example.grosury.ui.LoginActivity;
import com.example.grosury.ui.ProductDescriptionActivity;
import com.example.grosury.ui.SignUpActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseAuth mAuth;
    MenuItem menuItem;
    NavigationView navigationView;
    TextView textViewMobileNav, textViewNameNav;
    CircleImageView imageViewProfileNav;
    private  DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //    Toolbar toolbar=findViewById(R.id.toolbar);


        mAuth = FirebaseAuth.getInstance();
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,
                //toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //navigation Drawer
        navigationView = findViewById(R.id.nav_view);
        //getting the navigation headerview
        View headerView = navigationView.getHeaderView(0);
        textViewMobileNav = headerView.findViewById(R.id.mobileeNavigationDrawer);
        textViewNameNav = headerView.findViewById(R.id.displayNameNavigationDrawer);
        imageViewProfileNav = headerView.findViewById(R.id.displayImageNavigationdrawer);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id) {

            case R.id.aboutUsNav:
                Intent about = new Intent(MainActivity.this, ProductDescriptionActivity.class);
                startActivity(about);
                break;

            case R.id.shopByCatNav:

                Intent category = new Intent(MainActivity.this, ProductDescriptionActivity.class);
                startActivity(category);
                break;

            case R.id.addressesNav:
                Intent address = new Intent(MainActivity.this, ProductDescriptionActivity.class);
                startActivity(address);
                break;

            case R.id.cartNavigationDrawer:

                Intent cart = new Intent(MainActivity.this, ProductDescriptionActivity.class);
                startActivity(cart);
                break;


            case R.id.ordeHistorysNav:
                Intent orders = new Intent(MainActivity.this, ProductDescriptionActivity.class);
                startActivity(orders);
                break;

            case R.id.logoutNav:

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.shareNav:

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "coming soon";
                String shareSub = "Share Application";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                break;

            case R.id.editNav:

                Intent editProfile = new Intent(MainActivity.this, ProductDescriptionActivity.class);
                startActivity(editProfile);
                break;


        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
package com.example.propertyproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

                // drawer layout instance to toggle the menu icon to open
                // drawer and back button to close drawer
                drawerLayout = findViewById(R.id.my_drawer_layout);
                actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
                firebaseAuth = FirebaseAuth.getInstance();


        // pass the Open and Close toggle for the drawer layout listener
                // to toggle the button
                drawerLayout.addDrawerListener(actionBarDrawerToggle);
                actionBarDrawerToggle.syncState();

                // to make the Navigation drawer icon always appear on the action bar
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.PropertyMenu:
                startActivity(new Intent(HomePage.this, PropertyActivity.class));
                return true;
            case R.id.ContractorMenu:
                startActivity(new Intent(HomePage.this, contractorActivity.class));
                return true;
            case R.id.CovidMenu:
                startActivity(new Intent(HomePage.this, C19Tracker.class));
                return true;
            case R.id.WeatherMenu:
                startActivity(new Intent(HomePage.this, WeatherActivity.class));
                return true;
            case R.id.MapsMenu:
                startActivity(new Intent(HomePage.this, MapsActivity.class));
                return true;
            case R.id.logout:
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(HomePage.this, MainActivity.class));
                return true;
            default: return super.onOptionsItemSelected(item);
        }

    }

        }

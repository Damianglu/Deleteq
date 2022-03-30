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
import android.view.View;
import android.widget.Button;

import com.example.propertyproject.chart.ContractorChartActivity;
import com.example.propertyproject.chart.RentChartActivity;
import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    Button mpropertyHome, mcontractorHome, mrentStatsHome, mcontractorStatsHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mpropertyHome = findViewById(R.id.propertyHome);
        mcontractorHome = findViewById(R.id.contractorHome);
        mrentStatsHome = findViewById(R.id.rentStatsHome);
        mcontractorStatsHome = findViewById(R.id.contractorStatsHome);

        mpropertyHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, PropertyActivity.class));
            }
        });

        mcontractorHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, contractorActivity.class));
            }
        });

        mrentStatsHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, RentChartActivity.class));
            }
        });

        mcontractorStatsHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, ContractorChartActivity.class));
            }
        });

    }
}

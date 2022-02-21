package com.madyan.mobiledevelopmentproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String username;
    private FloatingActionButton cartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        username = getIntent().getStringExtra("USERNAME");

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        cartButton = findViewById(R.id.fab);

        tabLayout.addTab(tabLayout.newTab().setText("Chairs"));
        tabLayout.addTab(tabLayout.newTab().setText("Desks"));
        tabLayout.addTab(tabLayout.newTab().setText("Shelves"));
        tabLayout.addTab(tabLayout.newTab().setText("Beds"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final HomeAdapter adapter = new HomeAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Cart.class);
                intent.putExtra("USERNAME", username);
                startActivity(intent);
            }
        });
    }

    public String getUsername() {
        return username;
    }
}
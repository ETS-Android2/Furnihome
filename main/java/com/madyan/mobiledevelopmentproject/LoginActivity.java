package com.madyan.mobiledevelopmentproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {
    public static DBHelper userDB;
    private TabLayout tablayout;
    private ViewPager viewpager;
    private float alpha = 0;
    private FloatingActionButton gmail_button;
    private FloatingActionButton instagram_button;
    private FloatingActionButton twitter_button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userDB = new DBHelper(this);

        gmail_button = findViewById(R.id.fab_google);
        instagram_button = findViewById(R.id.fab_instagram);
        twitter_button = findViewById(R.id.fab_twitter);
        tablayout = findViewById(R.id.tabLayout);
        viewpager = findViewById(R.id.viewPager);

        tablayout.addTab(tablayout.newTab().setText("Log in"));
        tablayout.addTab(tablayout.newTab().setText("Sign up"));
        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(), this, tablayout.getTabCount());
        viewpager.setAdapter(adapter);
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

        instagram_button.setTranslationY(300);
        gmail_button.setTranslationY(300);
        twitter_button.setTranslationY(300);
        tablayout.setTranslationY(300);

        instagram_button.setAlpha(alpha);
        gmail_button.setAlpha(alpha);
        twitter_button.setAlpha(alpha);
        tablayout.setAlpha(alpha);

        twitter_button.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        gmail_button.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        instagram_button.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        tablayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();

        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        instagram_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri insta_page = Uri.parse("https://www.instagram.com/furnihomedxb/");
                Intent intent = new Intent(Intent.ACTION_VIEW, insta_page);
                startActivity(intent);
            }
        });

        twitter_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri twitter_page = Uri.parse("https://twitter.com/FurniHome2");
                Intent intent = new Intent(Intent.ACTION_VIEW, twitter_page);
                startActivity(intent);
            }
        });

        gmail_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:FurniHomeDXB@gmail.com"));
                startActivity(intent);
            }
        });
    }
}
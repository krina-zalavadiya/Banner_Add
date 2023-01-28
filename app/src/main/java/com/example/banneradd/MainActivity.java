package com.example.banneradd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout adContainer = findViewById(R.id.adMobView11);
        Banner bannerAdClass = new Banner(this, adContainer);
        bannerAdClass.fbpripor();
    }
}
package com.example.lifehack;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import java.util.Locale;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.menu_action_settings);
        setSupportActionBar(toolbar);

        ImageView il = findViewById(R.id.settings_ImageView_IL);
        ImageView us = findViewById(R.id.settings_ImageView_US);

        il.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.flag_il));
        us.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.flag_us));

        il.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setLocale("ar");
            }
        });

        us.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setLocale("en");
            }
        });
    }

    void setLocale(String language){
        Locale locale = new Locale(language);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(locale);
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        finish();
        startActivity(refresh);
    }
}

package com.example.lifehack;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.Locale;
import java.util.Set;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.menu_action_settings);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.getNavigationIcon().setAutoMirrored(true);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(Settings.this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setLocale(String language){
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(locale);
        res.updateConfiguration(conf, dm);

        Intent refresh = getIntent();
        finish();
        startActivity(refresh);
    }

}

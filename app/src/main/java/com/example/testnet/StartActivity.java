package com.example.testnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import java.io.InputStream;

public class StartActivity extends AppCompatActivity {
    private ImageView logoIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        this.logoIv = findViewById(R.id.logoIV);

        loadLogo();

        //Move to the next activity after X time.
        int secondsDelayed = 4;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(StartActivity.this, LoginActivity.class));
                finish();
            }
        }, secondsDelayed * 1000);
    }

    private void loadLogo(){
        AssetManager assets = getAssets();
        InputStream stream;

        try {
            stream = assets.open("logo.png");
            Drawable img = Drawable.createFromStream(stream, null);
            this.logoIv.setImageDrawable(img);
        }
        catch (Exception e){
            return;
        }
    }
}

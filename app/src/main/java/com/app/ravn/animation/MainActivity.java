package com.app.ravn.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button fadeIn;
    Button blink;

    TextView tvFadeIn;
    TextView tvBlink;

    Button zoomIn;
    TextView tvZoomIn;

    Button btnAnother;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        fadeIn = (Button) findViewById(R.id.btnFadeIn);
        tvFadeIn = (TextView) findViewById(R.id.tvFadeIn);
        blink = (Button) findViewById(R.id.btnBlink);
        tvBlink = (TextView) findViewById(R.id.tvBlink);

        zoomIn = (Button) findViewById(R.id.btnZoomIn);
        tvZoomIn = (TextView) findViewById(R.id.tvZoomIn);

        fadeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fade_in);
                tvFadeIn.startAnimation(animFadein);
            }
        });


        blink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blink);
                tvBlink.startAnimation(animFadein);
            }
        });


        zoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.zoom_in);
                tvZoomIn.startAnimation(animFadein);
            }
        });




        btnAnother = (Button) findViewById(R.id.btnAnother);

        btnAnother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent another = new Intent(MainActivity.this, StoreData.class);
                startActivity(another);
            }
        });


    }


}

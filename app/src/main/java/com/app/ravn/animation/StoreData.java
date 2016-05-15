package com.app.ravn.animation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StoreData extends AppCompatActivity {

    public static final String PREFERENCE = "MyData";

    EditText etname;
    EditText etemail;

    TextView savedName;
    TextView savedEmail;

    Button btnSave;
    Button btnRetrieve;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_data);

        etname = (EditText) findViewById(R.id.etName);
        etemail = (EditText) findViewById(R.id.etEmail);
        btnSave = (Button) findViewById(R.id.btnSave);

        savedEmail = (TextView) findViewById(R.id.savedEmail);
        savedName = (TextView) findViewById(R.id.savedName);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = etname.getText().toString();
                String email = etemail.getText().toString();

                sharedpreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);


                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("name", name);
                editor.putString("email", email);
                editor.commit();

                Intent back = new Intent(StoreData.this, MainActivity.class);
                startActivity(back);

            }
        });
        btnRetrieve = (Button) findViewById(R.id.btnRetrieve);
        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedpreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
                String name = sharedpreferences.getString("name", null);
                Log.e("saved me", name);
                savedName.setVisibility(View.VISIBLE);
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fade_in);
                savedName.startAnimation(animFadein);
            }
        });


    }
}


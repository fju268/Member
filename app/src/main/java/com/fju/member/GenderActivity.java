package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class GenderActivity extends AppCompatActivity {

    private EditText edgender;
    private ImageView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        edgender = findViewById(R.id.wgender);
        home = findViewById(R.id.tohome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("exam",MODE_PRIVATE);
                pref.edit().putString("gender",edgender.getText().toString()).commit();
                Log.d("789", "onClick: "+edgender.getText().toString());
                GenderActivity.this.setResult(40);
                finish();
            }
        });
    }
}

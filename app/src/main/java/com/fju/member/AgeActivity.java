package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class AgeActivity extends AppCompatActivity {

    private EditText edage;
    private ImageView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        edage = findViewById(R.id.wage);
        next = findViewById(R.id.togender);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("exam",MODE_PRIVATE);
                pref.edit().putString("age",edage.getText().toString()).commit();
                Log.d("456", "onClick: "+edage.getText().toString());
                Intent intent = new Intent(AgeActivity.this,GenderActivity.class);
                startActivityForResult(intent,20);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==20){
            if (resultCode==40){
                Log.d("rere", "onActivityResult: ");
                SharedPreferences pref = getSharedPreferences("exam",MODE_PRIVATE);
                if (!pref.getString("gender","").equals("")&&!pref.getString("age","").equals("")) {
                    Log.d("222", "onActivityResult: ");
                    AgeActivity.this.setResult(70);
                    finish();
                }
            }
        }
    }
}

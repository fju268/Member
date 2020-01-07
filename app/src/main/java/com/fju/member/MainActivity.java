package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText edname;
    private EditText edage;
    private EditText edgender;
    private String n;
    private String a;
    private String g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        SharedPreferences perf = getSharedPreferences("exam",MODE_PRIVATE);
        edname = findViewById(R.id.name);
        edage = findViewById(R.id.age);
        edgender = findViewById(R.id.gender);
        String age = edname.getText().toString();
        String b = edage.getText().toString();
        String c = edgender.getText().toString();
        n = perf.getString("name","");
        a = perf.getString("age","");
        g = perf.getString("gender","");
        if (n.equals("")&&a.equals("")&&g.equals("")){
            Intent intent = new Intent(MainActivity.this,NicknameActivity.class);
            startActivity(intent);
        }

    }
}

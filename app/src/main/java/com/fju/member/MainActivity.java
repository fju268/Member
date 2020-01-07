package com.fju.member;

import androidx.annotation.Nullable;
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==10){
            if (resultCode==RESULT_OK){
                SharedPreferences perf = getSharedPreferences("exam",MODE_PRIVATE);
                n = perf.getString("name","");
                a = perf.getString("age","");
                g = perf.getString("gender","");
                edname.setText(n+"");
                edage.setText(a+"");
                edgender.setText(g+"");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        edname = findViewById(R.id.name);
        edage = findViewById(R.id.age);
        edgender = findViewById(R.id.gender);
        String age = edname.getText().toString();
        String b = edage.getText().toString();
        String c = edgender.getText().toString();

        if (age.equals("")&&b.equals("")&&c.equals("")){
            Intent intent = new Intent(MainActivity.this,NicknameActivity.class);
            startActivityForResult(intent,10);
        }

    }

}

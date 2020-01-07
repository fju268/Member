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

public class NicknameActivity extends AppCompatActivity {

    private EditText ednickname;
    private ImageView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        ednickname = findViewById(R.id.nickname);
        next = findViewById(R.id.toage);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("exam",MODE_PRIVATE);
                pref.edit().putString("name",ednickname.getText().toString()).commit();
                NicknameActivity.this.setResult(RESULT_OK);
                Log.d("123", "onClick: "+ednickname.getText().toString());
                Intent intent = new Intent(NicknameActivity.this,AgeActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if (requestCode==100){
//            if (resultCode==70){
//                SharedPreferences pref = getSharedPreferences("exam",MODE_PRIVATE);
//                if (!pref.getString("gender","").equals("")&&!pref.getString("age","").equals("")&&!pref.getString("name","").equals("")){
//                    finish();
//                }
//
//            }
//        }
//    }
}

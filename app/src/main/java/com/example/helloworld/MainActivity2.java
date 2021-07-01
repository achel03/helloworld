package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText et;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et = findViewById(R.id.etYear);

        b1 = findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast();
            }
        });
        //b1.setOnLongClickListener();
    }
    private void Toast(){
        //Toast.makeText()
    }

    public void onYearClick(View view) {
        //1. editText 생년 가져오기
        String year = et.getText().toString();
        //2. 생년 나이로 바꾸기
        int iyear = Integer.parseInt(year);
        int age = 2021-iyear+1;
        //3. 나이 토스트로 띄우기
        Toast.makeText(this, "당신의 나이는 "+age+"입니다. ",Toast.LENGTH_SHORT).show();

    }
}
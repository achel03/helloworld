package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //int count = 0;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        textView = findViewById(R.id.txtCount);
    }
    public void onToastClick(View view){
        //메세지 박스 띄우기
        Toast.makeText(this, "Hello Toast", Toast.LENGTH_SHORT).show();
    }
    public void onCountClick(View view){
        //메세지 박스 띄우기
        //Toast.makeText(this, "Hello Count...", Toast.LENGTH_SHORT).show();
        int count = Integer.parseInt(textView.getText().toString());
        //count++;
        textView.setText((count++)+"");//문자열 더해주면 자동으로 문자열로 바뀜 와우
    }
}
package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    Button b2, b3;
    EditText et4;
    TextView tv, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
    }
    private void init(){
        b2 = findViewById(R.id.btnBack);
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                callBack();
            }
        });
        b3 = findViewById(R.id.btnResend);
        tv = findViewById(R.id.tvMsg);
        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");
        String msg2 = intent.getStringExtra("msg2");
        tv.setText(msg);

        String msg3 = intent.getStringExtra("msg3");
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMsg();
            }
        });

        tv2 = findViewById(R.id.tvMsg2);


        tv2.setText(msg2);
        tv3 = findViewById(R.id.tvMsg4);
        tv3.setText(msg3);
        et4 = findViewById(R.id.etMsg4);
    }

    private void sendMsg() {
        Intent intent = new Intent(this, FirstActivity.class);
        intent.putExtra("msg4", et4.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    private void callBack(){
        finish();
    }
}
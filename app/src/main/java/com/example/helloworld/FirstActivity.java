package com.example.helloworld;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    Button b1,b2,b3;
    EditText et, et2, et3;
    TextView tv3;

    private final static int REQUEST_CODE_1 = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        b1 = findViewById(R.id.btnCall);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                callSecondActivity();
            }
        });
        b2 = findViewById(R.id.btnMsg);
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                callSecondActivityWithMsg();
            }
        });
        b3 = findViewById(R.id.btnMsg3);
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                callSecondActivityWithMsg3();
            }
        });
        et = findViewById(R.id.etMsg);
        et2 = findViewById(R.id.etMsg2);
        et3 = findViewById(R.id.etMsg3);

        tv3 = findViewById(R.id.tvMsg3);
        Intent intent = getIntent();
        String msg3 = intent.getStringExtra("msg3");
        tv3.setText(msg3);
    }

    private void callSecondActivityWithMsg3() {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("msg3", et3.getText().toString()); // intent를 만들어 보낼 때 msg라는 값으로 전송
        startActivityForResult(intent, REQUEST_CODE_1);
    }

    private void callSecondActivityWithMsg() {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("msg", et.getText().toString()); // intent를 만들어 보낼 때 msg라는 값으로 전송
        intent.putExtra("msg2", et2.getText().toString());
        startActivity(intent);
    }

    private void callSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_1) {
            if (resultCode == RESULT_OK) {
                String msg = data.getStringExtra("msg4");
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
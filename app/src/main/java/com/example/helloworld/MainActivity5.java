package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    public static final String EXTRA_REPLY = "REPLY";
    EditText mReply;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity4.EXTRA_MESSAGE);
        tv = findViewById(R.id.txtMsg);
        tv.setText(msg);
        tv.setVisibility(View.VISIBLE);
        mReply = findViewById(R.id.etSecond);
    }

    public void returnReply(View view) {
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, mReply.getText().toString());
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
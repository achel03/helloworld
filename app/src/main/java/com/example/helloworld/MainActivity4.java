package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity4 extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    private static final String LOG_TAG =
            MainActivity4.class.getSimpleName();
    public static final String EXTRA_MESSAGE ="com.example.helloworld.extra.msg";
    private TextView tvHeadRp;
    private TextView tvRp;
    private EditText etMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        etMsg = findViewById(R.id.etMain);
        tvHeadRp = findViewById(R.id.txtHeader_reply);
        tvRp = findViewById(R.id.txtMsg_reply);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivity5.class);
        intent.putExtra(EXTRA_MESSAGE, etMsg.getText().toString());
        startActivityForResult(intent, TEXT_REQUEST); // putExtra 이후 startActivityForResult 순서 중요
    }
    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply =
                        data.getStringExtra(MainActivity5.EXTRA_REPLY);
                tvHeadRp.setVisibility(View.VISIBLE);
                tvRp.setText(reply);
                tvRp.setVisibility(View.VISIBLE);
            }
        }
    }
}
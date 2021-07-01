package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    EditText etame, etlate, etmoca;
    TextView txtmenu, txtsale, txttotal;
    CheckBox ck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        etame = findViewById(R.id.etAmericano);
        etlate = findViewById(R.id.etLatte);
        etmoca = findViewById(R.id.etMoca);

        txtmenu = findViewById(R.id.txtMenu);
        txtsale = findViewById(R.id.txtSale);
        txttotal = findViewById(R.id.txtTotal);

        ck = (CheckBox) findViewById(R.id.ckbox);
    }

    public void onMenuClick(View view) {
        int ctame = Integer.parseInt(etame.getText().toString());
        int ctlatte = Integer.parseInt(etlate.getText().toString());
        int ctmoca = Integer.parseInt(etmoca.getText().toString());

        int count = 0;
        int sale, mny, total = 0;

        count = ctame+ctlatte+ctmoca;
        mny = 1000*ctame+1500*ctlatte+1700*ctmoca;

        if(ck.isChecked()){
            sale = (int)(mny*(0.1));
            total = mny - sale;
        }else{
            sale = 0;
            total = mny;
        }

        txtmenu.setText("주문개수: "+count+"개");
        txtsale.setText("할인금액: "+sale+"원");
        txttotal.setText("결제금액: "+total+"원");

    }


}
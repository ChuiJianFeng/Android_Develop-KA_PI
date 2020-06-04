package com.example.KA_PI_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Choose extends AppCompatActivity {

    Button bt_1,bt_2,bt_3,bt_4;
    Bundle bundle ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        bundle = new Bundle();
        bt_1 = findViewById(R.id.bt_1);
        bt_2 = findViewById(R.id.bt_2);
        bt_3 = findViewById(R.id.bt_3);
        bt_4 = findViewById(R.id.bt_4);
        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String bt = "coffeehunter";
                int id = v.getId();
                bundle.putString("bt",bt);
                bundle.putInt("id",id);
                Intent it = new Intent(Choose.this,MainActivity.class);
                it.putExtras(bundle);
                startActivity(it);
            }
        });

        bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bt = "cook";
                int id = v.getId();
                bundle.putString("bt",bt);
                bundle.putInt("id",id);
                Intent it = new Intent(Choose.this,MainActivity.class);
                it.putExtras(bundle);
                startActivity(it);
            }
        });

        bt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bt = "barista";
                int id = v.getId();
                bundle.putString("bt",bt);
                bundle.putInt("id",id);
                Intent it = new Intent(Choose.this,MainActivity.class);
                it.putExtras(bundle);
                startActivity(it);
            }
        });

        bt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Choose.this,Record.class);
                startActivity(it);
            }
        });
    }
}

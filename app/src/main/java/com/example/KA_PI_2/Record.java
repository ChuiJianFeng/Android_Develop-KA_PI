package com.example.KA_PI_2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Record extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner sptool, spbean;
    Button btstore, btView;
    EditText etdegree, ettime, ettem, etbeang, etwater;
    Bundle bundle;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btstore = findViewById(R.id.btstore);
        btView = findViewById(R.id.btView);
        sptool = findViewById(R.id.sptool);
        spbean = findViewById(R.id.spbean);
        etdegree = findViewById(R.id.etdegree);
        ettime = findViewById(R.id.ettime);
        ettem = findViewById(R.id.ettem);
        etbeang = findViewById(R.id.etbeang);
        etwater = findViewById(R.id.etwater);

        helper = new DatabaseHelper(this);
        Log.v("CC", "Record");

        String types[] = {"V60", "Kalita濾杯", "Batch Brewers", "聰明杯", "法式濾壓壺", "愛樂壓", "Expresso", "摩卡壺", "虹吸壺", "土耳其壺"};
        int img[] = {R.drawable.v60, R.drawable.kalita,R.drawable.brewers,R.drawable.smart,R.drawable.franch,R.drawable.lovepush,R.drawable.machine,R.drawable.moka,R.drawable.sock,R.drawable.turkey};

        String beantypes[] = {"瓜地馬拉 拉米尼塔 花神 咖啡豆","mojoblend混合豆","坦桑尼亞 克里曼加羅AA咖啡豆","QualitàOro 金磚咖啡豆","衣索比亞耶加雪菲咖啡豆","台灣德文咖啡豆","哥斯大黎加 卡內特 莫札特 咖啡豆","我的咖啡豆","我的咖啡豆","我的咖啡豆","我的咖啡豆","我的咖啡豆","我的咖啡豆"};

        sptool.setOnItemSelectedListener(this);
        Spinner_Adapter spinner_adapter = new Spinner_Adapter(getApplicationContext(), img, types);
        sptool.setAdapter(spinner_adapter);

        ArrayAdapter beanadapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, beantypes);
        spbean.setAdapter(beanadapter);

        btstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Beang = etbeang.getText().toString();
                int Degree = Integer.parseInt(etdegree.getText().toString());
                int Time = Integer.parseInt(ettime.getText().toString());
                int Temperature = Integer.parseInt(ettem.getText().toString());
                int Water = Integer.parseInt(etwater.getText().toString());
                //bean

                Coffee_Customer model = new Coffee_Customer(Beang, Degree, Time, Temperature, Water);
                boolean a = helper.insertCoffeeRecord(model.beang, model.degree, model.time, model.Temperature, model.water);
                //lv.invalidateViews();//something
                Toast.makeText(Record.this, model.toString(), Toast.LENGTH_SHORT).show();
                if (a)
                    Toast.makeText(Record.this, "you success", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Record.this, "Wrong", Toast.LENGTH_SHORT).show();

            }
        });

        btView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Record.this, List_Data.class);
                startActivity(it);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}



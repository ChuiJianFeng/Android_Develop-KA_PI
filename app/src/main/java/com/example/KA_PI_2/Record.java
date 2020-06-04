package com.example.KA_PI_2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Record extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner sptool,spbean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        String types[] = {"V60","Kalita濾杯","america"};
        int img[] = {R.drawable.american,R.drawable.capuccino};

        String beantypes[] = {"MoJo","粉紅波旁"};

        sptool= findViewById(R.id.sptool);
        spbean = findViewById(R.id.spbean);

        sptool.setOnItemSelectedListener(this);
        Spinner_Adapter spinner_adapter = new Spinner_Adapter(getApplicationContext(),img,types);
        sptool.setAdapter(spinner_adapter);

        ArrayAdapter beanadapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,beantypes);
        spbean.setAdapter(beanadapter);

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

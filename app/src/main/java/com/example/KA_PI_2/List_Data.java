package com.example.KA_PI_2;

import android.database.Cursor;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class List_Data extends AppCompatActivity {
    ListView lv;
    DatabaseHelper mhelper= new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        lv = findViewById(R.id.lv);

        ArrayList <String> list_data = mhelper.getAllCoffeeRecord();
        Cursor data = mhelper.getData();
        //data.moveToFirst();
        if(data.getCount() ==0 ){
            Toast.makeText(List_Data.this,"The Database is empty",Toast.LENGTH_SHORT).show();
        }else{
            while (data.moveToNext()){
                //list_data.add(data.getString(1));
                ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list_data);
                lv.setAdapter(adapter);
            }
        }



    }
}

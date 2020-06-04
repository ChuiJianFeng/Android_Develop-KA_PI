package com.example.KA_PI_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Spinner_Adapter extends BaseAdapter {
    Context context;
    int flags[];
    String[] types;
    LayoutInflater inflter;

    public Spinner_Adapter(Context context, int[] flags, String[] types) {
        this.context = context;
        this.flags = flags;
        this.types = types;
        inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return flags.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflter.inflate(R.layout.spinner_item, null);
        ImageView icon = (ImageView) convertView.findViewById(R.id.imageView);
        TextView names = (TextView) convertView.findViewById(R.id.textView);
        icon.setImageResource(flags[position]);
        names.setText(types[position]);
        return convertView;
    }
}

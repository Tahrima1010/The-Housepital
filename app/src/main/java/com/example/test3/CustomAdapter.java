package com.example.test3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Medicine> {
    private Activity context;
    private List<Medicine> medicineList;

    public CustomAdapter( Activity context,  List<Medicine> medicineList) {
        super(context, R.layout.demolayout, medicineList);

        this.context = context;
        this.medicineList = medicineList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.demolayout,null,true);
        Medicine medicine=medicineList.get(position);
        TextView t1=view.findViewById(R.id.demo1);
        TextView t2=view.findViewById(R.id.demo2);
        t1.setText("Name : "+medicine.getName());
        t2.setText("Dose : "+medicine.getDose());
        return view;
    }
}

package com.example.test3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomView1 extends BaseAdapter {

    int[] pics;
    String[] motherchild;
    Context context;
    private LayoutInflater inflater;

    CustomView1(Context context,String[] motherchild,int[] pics){
        this.context=context;
        this.motherchild=motherchild;
        this.pics=pics;

    }
    @Override
    public int getCount() {
        return motherchild.length;
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

        if(convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sample_view,parent,false);


        }

        ImageView imageview = (ImageView) convertView.findViewById(R.id.imageviewid) ;
        TextView textView = (TextView) convertView.findViewById(R.id.textviewid1);
        imageview.setImageResource(pics[position]);
        textView.setText(motherchild[position]);
        return convertView;
    }


}

package com.example.test3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomView2 extends BaseAdapter {

    int[] image;
    String[] firstaid;
    Context context;
    private LayoutInflater inflater;

    CustomView2(Context context,String[] firstaid,int[] image){
        this.context=context;
        this.firstaid=firstaid;
        this.image=image;

    }
    @Override
    public int getCount() {
        return firstaid.length;
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
            convertView = inflater.inflate(R.layout.sample_view2,parent,false);


        }

        ImageView imageview = (ImageView) convertView.findViewById(R.id.imageviewid) ;
        TextView textView = (TextView) convertView.findViewById(R.id.textviewid1);
        imageview.setImageResource(image[position]);
        textView.setText(firstaid[position]);
        return convertView;
    }

}

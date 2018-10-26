package com.example.mrbuggy.appbanhangonlie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrbuggy.appbanhangonlie.R;
import com.example.mrbuggy.appbanhangonlie.model.Loaisp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoaispAdapter extends BaseAdapter {
    ArrayList<Loaisp> arrayList;
    Context context;

    public LoaispAdapter(ArrayList<Loaisp> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class viewHolder{
        TextView textView;
        ImageView imageView;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        viewHolder viewHolder =  null;
        if(convertView == null){
            viewHolder =  new viewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_listview_loaisp,null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.tvloaisp);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.ivloaisp);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (viewHolder) convertView.getTag();
        }
        Loaisp loaisp =  (Loaisp) getItem(position);
        viewHolder.textView.setText(loaisp.getTenLoaiSp());
        Picasso.with(context).load(loaisp.getHinhAnhLoaiSp()).into(viewHolder.imageView);
        return convertView;
    }
}

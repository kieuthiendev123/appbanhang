package com.example.mrbuggy.appbanhangonlie.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrbuggy.appbanhangonlie.R;
import com.example.mrbuggy.appbanhangonlie.model.Sanphamnew;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class LapTopAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanphamnew> arrayList;

    public LapTopAdapter(Context context, ArrayList<Sanphamnew> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
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
        public TextView txtTenLapTop,txtGiaLapTop,tvMoTaLapTop;
        public ImageView imgLapTop;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LapTopAdapter.viewHolder viewHolder =  null;
        if(viewHolder == null){
            viewHolder = new viewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_laptop,null);
            viewHolder.txtTenLapTop = (TextView) convertView.findViewById(R.id.tvLaptop);
            viewHolder.txtGiaLapTop = (TextView) convertView.findViewById(R.id.tvgiasp);
            viewHolder.tvMoTaLapTop = (TextView) convertView.findViewById(R.id.tvMoTasp);
            viewHolder.imgLapTop = (ImageView) convertView.findViewById(R.id.imgLaptop);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (LapTopAdapter.viewHolder) convertView.getTag();

        }
        Sanphamnew sanPham = (Sanphamnew) getItem(position);
        viewHolder.txtTenLapTop.setText(sanPham.getTenSanPham());
        DecimalFormat decimalFormat =  new DecimalFormat("###,###,###");
        viewHolder.txtGiaLapTop.setText("Giá :" +decimalFormat.format(sanPham.getGiaSanPham())+" Đ");
        viewHolder.tvMoTaLapTop.setMaxLines(2);
        viewHolder.tvMoTaLapTop.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.tvMoTaLapTop.setText(sanPham.getMoTaSanPham());
        Picasso.with(context).load(sanPham.getHinhAnhSanPham())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(viewHolder.imgLapTop);;

        return convertView;
    }
}

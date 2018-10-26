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

public class DienThoaiAdapter  extends BaseAdapter{
    Context  context;
    ArrayList<Sanphamnew> arrayList;

    public DienThoaiAdapter(Context context, ArrayList<Sanphamnew> arrayList) {
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
        public TextView txtTenDT,txtGiaDT,tvMoTaDT;
        public ImageView imgDT;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder viewHolder =  null;
        if(viewHolder == null){
            viewHolder = new viewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_dienthoai,null);
            viewHolder.txtTenDT = (TextView) convertView.findViewById(R.id.tvDienThoai);
            viewHolder.txtGiaDT = (TextView) convertView.findViewById(R.id.tvgiasp);
            viewHolder.tvMoTaDT = (TextView) convertView.findViewById(R.id.tvMoTasp);
            viewHolder.imgDT = (ImageView) convertView.findViewById(R.id.imgDienThoai);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (DienThoaiAdapter.viewHolder) convertView.getTag();

        }
        Sanphamnew sanPham = (Sanphamnew) getItem(position);
        viewHolder.txtTenDT.setText(sanPham.getTenSanPham());
        DecimalFormat decimalFormat =  new DecimalFormat("###,###,###");
        viewHolder.txtGiaDT.setText("Giá :" +decimalFormat.format(sanPham.getGiaSanPham())+" Đ");
        viewHolder.tvMoTaDT.setMaxLines(2);
        viewHolder.tvMoTaDT.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.tvMoTaDT.setText(sanPham.getMoTaSanPham());
        Picasso.with(context).load(sanPham.getHinhAnhSanPham())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(viewHolder.imgDT);

        return convertView;
    }
}

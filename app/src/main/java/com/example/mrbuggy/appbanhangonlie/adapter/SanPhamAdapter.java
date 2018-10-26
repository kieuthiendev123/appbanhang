package com.example.mrbuggy.appbanhangonlie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.Volley;
import com.example.mrbuggy.appbanhangonlie.R;
import com.example.mrbuggy.appbanhangonlie.activity.ChiTietSanPham;
import com.example.mrbuggy.appbanhangonlie.model.Sanphamnew;
import com.example.mrbuggy.appbanhangonlie.ultil.CheckConnection;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.ItemHodler> {
    Context context;
    ArrayList<Sanphamnew> arrayList;

    public SanPhamAdapter(Context context, ArrayList<Sanphamnew> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public ItemHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_sp_new,null);
        ItemHodler itemHodler =  new ItemHodler(v);
        return itemHodler;
    }

    @Override
    public void onBindViewHolder(ItemHodler holder, int position) {
        Sanphamnew sanphamnew =  arrayList.get(position);
        holder.txtTenSp.setText(sanphamnew.getTenSanPham());
        DecimalFormat decimalFormat =  new DecimalFormat("###,###,###");
        holder.txtGiaSp.setText("Giá :" +decimalFormat.format(sanphamnew.getGiaSanPham())+" Đ");
        Picasso.with(context).load(sanphamnew.getHinhAnhSanPham())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.hinhSanPham);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class  ItemHodler extends RecyclerView.ViewHolder{
        public ImageView hinhSanPham;
        public TextView txtTenSp,txtGiaSp;

        public ItemHodler(View itemView) {
            super(itemView);
            hinhSanPham = (ImageView) itemView.findViewById(R.id.imgsanpham);
            txtGiaSp = (TextView) itemView.findViewById(R.id.tvgiasp);
            txtTenSp = (TextView) itemView.findViewById(R.id.tvTenSanPham);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =  new Intent(context, ChiTietSanPham.class);
                    intent.putExtra("thongtinsanpham",arrayList.get(getPosition()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    CheckConnection.ShowToast_Short(context,arrayList.get(getPosition()).getTenSanPham());
                    context.startActivity(intent);
                }
            });
        }
    }
}

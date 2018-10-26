package com.example.mrbuggy.appbanhangonlie.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.mrbuggy.appbanhangonlie.R;
import com.example.mrbuggy.appbanhangonlie.model.Sanphamnew;
import com.squareup.picasso.Picasso;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ChiTietSanPham extends AppCompatActivity {
    Toolbar tbChiTiet;
    ImageView imgChiTiet;
    TextView tvTen,tvGia,tvMota;
    Spinner spinner;
    Button btnGioHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        anhXa();
        actionTooBar();
        getData();
    }


    private void actionTooBar() {
        setSupportActionBar(tbChiTiet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbChiTiet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void anhXa() {
        tbChiTiet = (Toolbar) findViewById(R.id.tbDetail);
        tvTen = (TextView) findViewById(R.id.tvTenSanPham);
        tvGia = (TextView) findViewById(R.id.tvgiasp);
        tvMota = (TextView) findViewById(R.id.motaChiTien);
        spinner = (Spinner) findViewById(R.id.spDetail);
        imgChiTiet = (ImageView) findViewById(R.id.imgChiTiet);
    }

    public void getData() {
        int id = 0;
        String tenChiTiet = "";
        int giaChiTiet = 0;
        String motaChiTien  = "";
        String hinhAnhsp = "";
        int idSanpham = 0;
        Sanphamnew sanpham = (Sanphamnew) getIntent().getSerializableExtra("thongtinsanpham");
        id = sanpham.getId();
        tenChiTiet = sanpham.getTenSanPham();
        giaChiTiet =  sanpham.getGiaSanPham();
        hinhAnhsp = sanpham.getHinhAnhSanPham();
        motaChiTien = sanpham.getMoTaSanPham();
        idSanpham =  sanpham.getIdSanPhams();

        tvTen.setText(tenChiTiet);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tvGia.setText("Giá :" + decimalFormat.format((giaChiTiet))+ " Đ");
        tvMota.setText(motaChiTien);
        Picasso.with(getApplicationContext()).load(hinhAnhsp)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imgChiTiet);


    }
}

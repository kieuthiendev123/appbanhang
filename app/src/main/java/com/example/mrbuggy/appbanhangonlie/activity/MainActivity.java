package com.example.mrbuggy.appbanhangonlie.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.mrbuggy.appbanhangonlie.R;
import com.example.mrbuggy.appbanhangonlie.adapter.LoaispAdapter;
import com.example.mrbuggy.appbanhangonlie.adapter.SanPhamAdapter;
import com.example.mrbuggy.appbanhangonlie.model.Loaisp;
import com.example.mrbuggy.appbanhangonlie.model.Sanphamnew;
import com.example.mrbuggy.appbanhangonlie.ultil.CheckConnection;
import com.example.mrbuggy.appbanhangonlie.ultil.Server;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    NavigationView navigationView;
    ListView listViewTrangChu;
    DrawerLayout drawerLayout;
    ArrayList<Loaisp> arrayList;
    LoaispAdapter loaispAdapter;
    ImageView imgSpnew;
    int id = 0;
    String tenLoaisp = "";
    String hinhAnhsp = "";
    ArrayList<Sanphamnew> arrayListnew;
    SanPhamAdapter sanPhamAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
            ActionBar();
            ActionViewFlipper();
            GetDulieuLoaiSp();
            GetDulieuLSpnew();
            CatChonItemListView();
        }else {
            CheckConnection.ShowToast_Short(getApplicationContext(),"Kiêm tra lại kết nối");
            finish();
        }

    }

    private void CatChonItemListView() {
        listViewTrangChu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this,MainActivity.class);
                            startActivity(intent);
                        }else{
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hay kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this,DienThoaiAcitity.class);
                            intent.putExtra("idloaisp",arrayList.get(position).getId());
                            startActivity(intent);
                        }else{
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hay kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this,LaptopActivity.class);
                            intent.putExtra("idloaisp",arrayList.get(position).getId());
                            startActivity(intent);
                        }else{
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hay kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 3:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this,LienHeActivity.class);
                            startActivity(intent);
                        }else{
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hay kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 4:
                        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this,ThongTinActivity.class);
                            startActivity(intent);
                        }else{
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hay kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
            }
        });
    }

    private void GetDulieuLSpnew() {
        final RequestQueue requestQueue =  Volley.newRequestQueue(getApplicationContext());
        final JsonArrayRequest jsonArrayRequest =  new JsonArrayRequest(Server.duongDanSpnew, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response != null){
                    int ID = 0;
                    String tenSp = "";
                    Integer giaSp = 0;
                    String hinhAnhSp = "";
                    String motaSP = "";
                    int idSanham = 0;
                    for(int i = 0 ; i <response.length(); i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            ID = jsonObject.getInt("id");
                            tenSp = jsonObject.getString("tensp");
                            giaSp = jsonObject.getInt("giasp");
                            hinhAnhSp =  jsonObject.getString("hinhanhsp");
                            motaSP =  jsonObject.getString("motasp");
                            idSanham = jsonObject.getInt("idsp");
                            arrayListnew.add(new Sanphamnew(ID,tenSp,giaSp,hinhAnhSp,motaSP,idSanham));
                            sanPhamAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void GetDulieuLoaiSp() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest =  new JsonArrayRequest(Server.duongDanLoaiSp, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response != null){
                    for(int i = 0 ;i <response.length() ; i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tenLoaisp = jsonObject.getString("tenLoaisp");
                            hinhAnhsp = jsonObject.getString("hinhanhloaisp");
                            arrayList.add(new Loaisp(id,tenLoaisp,hinhAnhsp));

                            loaispAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    arrayList.add(new Loaisp(3,"Liên Hệ","http://kingsdown.com.vn/wp-content/themes/FEFV/images/FEFV-contact-icon-03.jpg"));
                    arrayList.add(new Loaisp(4,"Thông tin","http://cdn1.iconfinder.com/data/icons/Pretty_office_icon_part_2/128/personal-information.png"));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast_Short(getApplicationContext(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void ActionViewFlipper() {
        ArrayList<String> arrQuangCao = new ArrayList<>();
        arrQuangCao.add("http://tinhte.cdnforo.com/store/2014/08/2572609_Hinh_2.jpg");
        arrQuangCao.add("https://photo2.tinhte.vn/data/attachment-files/2018/09/4431019_Nokia_Fan_Day-7.jpg");
        arrQuangCao.add("https://photo2.tinhte.vn/data/attachment-files/2018/01/4231339_cover_mua_dien_thoai_android_cu.jpg");
        arrQuangCao.add("https://photo2.tinhte.vn/data/attachment-files/2018/09/4430202_Cover.jpg");
        for(int i = 0 ; i< arrQuangCao.size(); i ++){
            ImageView imageView =  new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(arrQuangCao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation);
        viewFlipper.setOutAnimation(animation_out);
    }

    private  void ActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);

            }
        });
    }
    private void AnhXa() {
        toolbar = (Toolbar) findViewById(R.id.toolbarTrangChu);
        viewFlipper = (ViewFlipper) findViewById(R.id.vftrangchu);
        recyclerView =  (RecyclerView) findViewById(R.id.recTrangChu);
        navigationView = (NavigationView) findViewById(R.id.NVtrangchu);
        listViewTrangChu = (ListView) findViewById(R.id.listViewTrangChu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        arrayList =  new ArrayList<>();
        arrayList.add(new Loaisp(0,"Trang chủ","https://vi.seaicons.com/wp-content/uploads/2017/04/home-icon2.png"));
        loaispAdapter = new LoaispAdapter(arrayList,getApplicationContext());
        listViewTrangChu.setAdapter(loaispAdapter);
        arrayListnew =  new ArrayList<>();
        sanPhamAdapter =  new SanPhamAdapter(getApplicationContext(),arrayListnew);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView.setAdapter(sanPhamAdapter);
    }
}

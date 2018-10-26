package com.example.mrbuggy.appbanhangonlie.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mrbuggy.appbanhangonlie.R;
import com.example.mrbuggy.appbanhangonlie.adapter.LapTopAdapter;
import com.example.mrbuggy.appbanhangonlie.model.Sanphamnew;
import com.example.mrbuggy.appbanhangonlie.ultil.CheckConnection;
import com.example.mrbuggy.appbanhangonlie.ultil.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LaptopActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView lvDt;
    LapTopAdapter lapTopAdapter;
    ArrayList<Sanphamnew> arrayList;
    int idLT = 0;
    int page = 1;
    View proCessbar;
    boolean isLoading = false;
    mHandler mHandler;
    boolean limmitData = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop);
        anhXa();
        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
            getIdSp();
            ActionTooBar();
            getData(page);
            loadMore();
        }else {
            CheckConnection.ShowToast_Short(getApplicationContext(),"bạn kiểm tra lại Internt");
        }
    }

    private void anhXa() {
        toolbar =  (Toolbar) findViewById(R.id.tbLaptop);
        lvDt = (ListView) findViewById(R.id.lvLaptop);
        arrayList =  new ArrayList<>();
        lapTopAdapter = new LapTopAdapter(getApplicationContext(),arrayList);
        lvDt.setAdapter(lapTopAdapter);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        proCessbar =  inflater.inflate(R.layout.progerbass,null);
        mHandler = new mHandler();
    }
    public void getIdSp() {
        idLT =  getIntent().getIntExtra("idloaisp",-1);
    }
    private void ActionTooBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void loadMore() {
        lvDt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),ChiTietSanPham.class);
                intent.putExtra("Thongtinsanpham",arrayList.get(position));
                startActivity(intent);
            }
        });
        lvDt.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount != 0 && isLoading == false && limmitData == false){
                    isLoading = true;
                    ThreadData threadData =  new ThreadData();
                    threadData.start();
                }
            }
        });
    }
    public void getData(int pages) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongDan = Server.duongDienThoai+String.valueOf(pages);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, duongDan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id = 0;
                String tenLT = "";
                Integer giaLT =  0;
                String hinhAnhLT = "";
                String moTaLT = "";
                int idLTsp = 0;
                if(response != null && response.length() != 2){
                    lvDt.removeFooterView(proCessbar);
                    try {
                        JSONArray jsonArray =  new JSONArray(response);
                        for(int i = 0; i<jsonArray.length();i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tenLT = jsonObject.getString("tensp");
                            giaLT = jsonObject.getInt("giasp");
                            hinhAnhLT = jsonObject.getString("hinhanhsp");
                            moTaLT = jsonObject.getString("motasp");
                            idLTsp = jsonObject.getInt("idsanpham");
                            arrayList.add(new Sanphamnew(id,tenLT,giaLT,hinhAnhLT,moTaLT,idLTsp));
                            lapTopAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else {
                    limmitData = true;
                    lvDt.removeFooterView(proCessbar);
                    CheckConnection.ShowToast_Short(getApplicationContext(),"Đã hết dữ liệu");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param = new HashMap<String,String>();
                param.put("idsanpham",String.valueOf(idLT));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }
    public class mHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    lvDt.addFooterView(proCessbar);
                    break;
                case 1:
                    page++;
                    getData(page);
                    isLoading= false;
                    break;
            }
            super.handleMessage(msg);
        }
    }
    public  class  ThreadData extends  Thread{
        @Override
        public void run() {
            mHandler.sendEmptyMessage(0);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = mHandler.obtainMessage(1);
            mHandler.sendMessage(message);
            super.run();
        }
    }
}

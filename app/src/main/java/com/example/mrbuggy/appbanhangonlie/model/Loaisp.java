package com.example.mrbuggy.appbanhangonlie.model;

public class Loaisp {
    public int id;
    public String tenLoaiSp;
    public String hinhAnhLoaiSp;

    public Loaisp(int id, String tenLoaiSp, String hinhAnhLoaiSp) {
        this.id = id;
        this.tenLoaiSp = tenLoaiSp;
        this.hinhAnhLoaiSp = hinhAnhLoaiSp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaiSp() {
        return tenLoaiSp;
    }

    public void setTenLoaiSp(String tenLoaiSp) {
        this.tenLoaiSp = tenLoaiSp;
    }

    public String getHinhAnhLoaiSp() {
        return hinhAnhLoaiSp;
    }

    public void setHinhAnhLoaiSp(String hinhAnhLoaiSp) {
        this.hinhAnhLoaiSp = hinhAnhLoaiSp;
    }
}

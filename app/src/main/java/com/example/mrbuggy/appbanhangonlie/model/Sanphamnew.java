package com.example.mrbuggy.appbanhangonlie.model;

import java.io.Serializable;

public class Sanphamnew implements Serializable {
    public int id;
    public String tenSanPham;
    public int giaSanPham;
    public String hinhAnhSanPham;
    public String moTaSanPham;
    public int idSanPhams;

    public Sanphamnew(int id, String tenSanPham, int giaSanPham, String hinhAnhSanPham, String moTaSanPham, int idSanPhams) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
        this.hinhAnhSanPham = hinhAnhSanPham;
        this.moTaSanPham = moTaSanPham;
        this.idSanPhams = idSanPhams;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(int giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public String getHinhAnhSanPham() {
        return hinhAnhSanPham;
    }

    public void setHinhAnhSanPham(String hinhAnhSanPham) {
        this.hinhAnhSanPham = hinhAnhSanPham;
    }

    public String getMoTaSanPham() {
        return moTaSanPham;
    }

    public void setMoTaSanPham(String moTaSanPham) {
        this.moTaSanPham = moTaSanPham;
    }

    public int getIdSanPhams() {
        return idSanPhams;
    }

    public void setIdSanPhams(int idSanPhams) {
        this.idSanPhams = idSanPhams;
    }
}

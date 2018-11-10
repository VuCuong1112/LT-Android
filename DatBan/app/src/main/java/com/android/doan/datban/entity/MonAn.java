package com.android.doan.datban.entity;

import android.graphics.drawable.BitmapDrawable;

import java.io.Serializable;

public class MonAn implements Serializable{
    private int maMon;
    private String tenMon;
    private double donGia;
    private String loaiMon;
    private int hinhAnh;

    public MonAn(int maMon, String tenMon, double donGia, String loaiMon, int hinhAnh) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.donGia = donGia;
        this.loaiMon = loaiMon;
        this.hinhAnh = hinhAnh;
    }

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getLoaiMon() {
        return loaiMon;
    }

    public void setLoaiMon(String loaiMon) {
        this.loaiMon = loaiMon;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}

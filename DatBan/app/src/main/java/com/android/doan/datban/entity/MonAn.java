package com.android.doan.datban.entity;

import android.graphics.drawable.BitmapDrawable;

import java.io.Serializable;

public class MonAn implements Serializable{
    private int maMon;
    private String tenMon;
    private int maLoai;
    private double donGia;
    private byte[] hinhAnh;

    public MonAn() {
    }

    public MonAn(int maMon, String tenMon, int maLoai, double donGia) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.maLoai = maLoai;
        this.donGia = donGia;
    }

    public MonAn(int maMon, String tenMon, int maLoai, double donGia, byte[] hinhAnh) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.maLoai = maLoai;
        this.donGia = donGia;
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

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}

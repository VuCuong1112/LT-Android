package com.android.doan.datban.entity;

import android.graphics.drawable.BitmapDrawable;

import java.io.Serializable;

public class NhanVien implements Serializable {
    private int maNhanVien;
    private String tenNhanVien;
    private String diaChi;
    private String soDienThoai;
    private BitmapDrawable hinhDrawable;

    public NhanVien(int maNhanVien, String tenNhanVien, String diaChi, String soDienThoai, BitmapDrawable hinhDrawable) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.hinhDrawable = hinhDrawable;
    }

    public BitmapDrawable getHinhDrawable() {
        return hinhDrawable;
    }

    public void setHinhDrawable(BitmapDrawable hinhDrawable) {
        this.hinhDrawable = hinhDrawable;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}

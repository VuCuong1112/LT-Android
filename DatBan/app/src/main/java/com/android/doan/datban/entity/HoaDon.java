package com.android.doan.datban.entity;

import java.io.Serializable;
import java.util.Date;

public class HoaDon implements Serializable {
    private int maHoaDon;
    private int maBan;
    private double tongTien;
    private Date ngayLap;

    public HoaDon(int maHoaDon, int maBan, double tongTien, Date ngayLap) {
        this.maHoaDon = maHoaDon;
        this.maBan = maBan;
        this.tongTien = tongTien;
        this.ngayLap = ngayLap;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaBan() {
        return maBan;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }
}

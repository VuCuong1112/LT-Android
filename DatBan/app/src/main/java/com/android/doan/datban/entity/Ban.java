package com.android.doan.datban.entity;

import java.io.Serializable;

public class Ban implements Serializable{
    private int maBan;
    private int soNguoi;

    public Ban(int maBan, int soNguoi) {
        this.maBan = maBan;
        this.soNguoi = soNguoi;
    }

    public int getMaBan() {
        return maBan;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }
}

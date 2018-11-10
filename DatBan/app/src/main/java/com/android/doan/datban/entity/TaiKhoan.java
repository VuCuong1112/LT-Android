package com.android.doan.datban.entity;

import java.io.Serializable;

public class TaiKhoan implements Serializable {
    private int maNhanVien;
    private String userName;
    private String password;

    public TaiKhoan(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
}

package com.android.doan.datban.entity;

import java.io.Serializable;
import java.util.List;

public class ChiTietHoaDon implements Serializable{
    private int maHoaDon;
    private List<MonAn> dsMonAn;

    public ChiTietHoaDon(int maHoaDon, List<MonAn> dsMonAn) {
        this.maHoaDon = maHoaDon;
        this.dsMonAn = dsMonAn;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public List<MonAn> getDsMonAn() {
        return dsMonAn;
    }

    public void setDsMonAn(List<MonAn> dsMonAn) {
        this.dsMonAn = dsMonAn;
    }
}

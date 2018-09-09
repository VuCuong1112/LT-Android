package com.example.vucuong.modules;

/**
 * Created by VuCuong on 9/5/2018.
 */

public class Music {
    private int maBH;
    private String tenBH;
    private String CaSi;
    private boolean soThich;

    public Music(int maBH, String tenBH, String caSi, boolean soThich) {
        this.maBH = maBH;
        this.tenBH = tenBH;
        this.CaSi = caSi;
        this.soThich = soThich;
    }

    public Music() {
    }

    public int getMaBH() {
        return maBH;
    }


    public void setMaBH(int maBH) {
        this.maBH = maBH;
    }

    public String getTenBH() {
        return tenBH;
    }

    public void setTenBH(String tenBH) {
        this.tenBH = tenBH;
    }

    public String getCaSi() {
        return CaSi;
    }

    public void setCaSi(String caSi) {
        CaSi = caSi;
    }

    public boolean isSoThich() {
        return soThich;
    }

    public void setSoThich(boolean soThich) {
        this.soThich = soThich;
    }
}

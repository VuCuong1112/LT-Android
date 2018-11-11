package com.android.doan.datban.control;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBManager extends SQLiteOpenHelper{
    public static final String DATABASE_NAME ="QuanLyDatMon.sqlite";
    private static final String CREATE_TABLE_BAN= "CREATE TABLE if not EXISTS Ban(" +
            "MaBan Integer primary key AUTOINCREMENT ," +
            "SoNguoi Integer)";
    private static final String CREATE_TABLE_LOAIMON="CREATE TABLE if not EXISTS LoaiMon(" +
            "MaLoai Integer primary key AUTOINCREMENT," +
            "TenLoai TEXT)";
    private static final String CREATE_TABLE_MONAN="CREATE TABLE if not EXISTS MonAn(" +
            "MaMonAn Integer primary key AUTOINCREMENT ," +
            "TenMon TEXT," +
            "MaLoai Integer," +
            "DonGia REAL," +
            "HinhAnh BLOB," +
            "FOREIGN KEY(MaLoai) REFERENCES LoaiMon(MaLoai) ON DELETE CASCADE)";
    private static final String CREATE_TABLE_NHANVIEN="CREATE TABLE IF NOT EXISTS NhanVien(" +
            "MaNhanVien Integer primary key AUTOINCREMENT," +
            "TenNhanVien TEXT," +
            "DiaChi TEXT," +
            "SoDienThoai TEXT," +
            "HinhAnh BLOB)";
    private static final String CREATE_TABLE_TAIKHOAN="CREATE TABLE IF NOT EXISTS TaiKhoan(" +
            "Username TEXT primary key," +
            "MaNhanVien Integer," +
            "Password TEXT," +
            "FOREIGN KEY(MaNhanVien) REFERENCES NhanVien(MaNhanVien) ON DELETE CASCADE)";
    private  static final String CREATE_TABLE_HOADON="CREATE TABLE IF NOT EXISTS HoaDon(" +
            "MaHoaDon Integer primary key AUTOINCREMENT," +
            "MaBan Integer," +
            "MaNhanVien Integer," +
            "TongTien REAL," +
            "NgayLap DATE, " +
            "FOREIGN KEY(MaNhanVien) REFERENCES NhanVien(MaNhanVien) ON DELETE CASCADE," +
            "FOREIGN KEY(MaBan) REFERENCES Ban(MaBan) ON DELETE CASCADE)";

    private static final String CREATE_TABLE_CHITIETHD="CREATE TABLE IF NOT EXISTS ChiTietHoaDon(" +
            "MaHoaDon Integer," +
            "MaMonAn Integer," +
            "SoLuong Integer," +
            "Dongia REAL," +
            "FOREIGN KEY(MaHoaDon) REFERENCES HoaDon(MaHoaDon) ON DELETE CASCADE," +
            "FOREIGN KEY(MaMonAn) REFERENCES MonAn(MaMonAn) ON DELETE CASCADE)";
    private Context context;

    public DBManager(Context context) {
        super(context, DATABASE_NAME,null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_BAN);
        db.execSQL(CREATE_TABLE_LOAIMON);
        db.execSQL(CREATE_TABLE_MONAN);
        db.execSQL(CREATE_TABLE_NHANVIEN);
        db.execSQL(CREATE_TABLE_TAIKHOAN);
        db.execSQL(CREATE_TABLE_HOADON);
        db.execSQL(CREATE_TABLE_CHITIETHD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("Drop table ChiTietHoaDon");
        db.execSQL("Drop table HoaDon");
        db.execSQL("Drop table ChiTietHoaDon");
        db.execSQL("Drop table TaiKhoan");
        db.execSQL("Drop table NhanVien");
        db.execSQL("Drop table MonAn");
        db.execSQL("Drop table LoaiMon");
        db.execSQL("Drop table Ban");
        onCreate(db);
    }
}

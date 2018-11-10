package com.android.doan.datban.control;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBManager extends SQLiteOpenHelper{
    public static final String DATABASE_NAME ="QuanLyDatMon.sqlite";
    private static final String CREATE_TABLE_BAN= "CREATE TABLE if not EXISTS Ban(" +
            "MaBan integer primary key AUTOINCREMENT ," +
            "SoNguoi integer)";
    private static final String CREATE_TABLE_MONAN="CREATE TABLE if not EXISTS MonAn(" +
            "MaMonAn integer primary key AUTOINCREMENT ," +
            "TenMon TEXT," +
            "LoaiMon TEXT," +
            "DonGia REAL," +
            "HinhAnh BLOB";
    private  static final String CREATE_TABLE_HOADON="CREATE TABLE IF NOT EXISTS HoaDon(" +
            "MaHoaDon integer IDENTITY(1,1)," +
            "MaBan interger," +
            "MaMonAn interger," +
            "TongTien REAL," +
            "NgayLap DATE, " +
            "primary key(MaHoaDon,MaBan,MaMonAn))";
    private static final String CREATE_TABLE_NHANVIEN="CREATE TABLE IF NOT EXISTS NhanVien(" +
            "MaNhanVien integer primary key AUTOINCREMENT," +
            "TenNhanVien TEXT," +
            "DiaChi TEXT," +
            "SoDienThoai TEXT," +
            "HinhAnh BLOB)";
    private static final String CREATE_TABLE_TAIKHOAN="CREATE TABLE IF NOT EXISTS TaiKhoan(" +
            "Username TEXT primary key," +
            "MaNhanVien interger," +
            "Password TEXT," +
            "FOREIGN KEY(MaNhanVien) REFERENCES NhanVien(MaNhanVien))";

    private Context context;

    public DBManager(Context context) {
        super(context, DATABASE_NAME,null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_BAN);
        db.execSQL(CREATE_TABLE_MONAN);
        db.execSQL(CREATE_TABLE_HOADON);
        db.execSQL(CREATE_TABLE_NHANVIEN);
        db.execSQL(CREATE_TABLE_TAIKHOAN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

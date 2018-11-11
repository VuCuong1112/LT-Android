package com.android.doan.datban;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Activity;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TabHost;

import com.android.doan.datban.adapter.AdapterBan;
import com.android.doan.datban.adapter.AdapterMonAn;
import com.android.doan.datban.entity.Ban;
import com.android.doan.datban.entity.MonAn;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainActivity extends Activity {
    TabHost tabHost;
    GridView gvBan;
    ArrayList<Ban> dsBan;
    AdapterBan adapter;

    ListView lvMonAn;
    ArrayList<MonAn> dsMonAn;
    AdapterMonAn adapterMonAn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // database=new DBManager(this);
        tabHost=(TabHost) findViewById(R.id.tabhost);
        tabHost.setup();
        TabHost.TabSpec tabDatMon=tabHost.newTabSpec("tabDatMon");
        tabDatMon.setContent(R.id.tab1);
        tabDatMon.setIndicator("Đặt món");
        tabHost.addTab(tabDatMon);
        addControllTab1();

        TabHost.TabSpec tabMonAn=tabHost.newTabSpec("tabMonAn");
        tabMonAn.setContent(R.id.tab2);
        tabMonAn.setIndicator("Menu món ăn");
        tabHost.addTab(tabMonAn);
        addControllTab2();

        TabHost.TabSpec tabThanhToan=tabHost.newTabSpec("tabThanhToan");
        tabThanhToan.setContent(R.id.tab2);
        tabThanhToan.setIndicator("Thanh toán");
        tabHost.addTab(tabThanhToan);
    }




    private void addControllTab2() {
        lvMonAn=(ListView) findViewById(R.id.mh3_lvMonAn);
        dsMonAn=new ArrayList<>();
        Drawable hinh1=getResources().getDrawable(R.drawable.cafe_da);
        byte[] anh1=convertDrawableToByte(hinh1);

        Drawable hinh2=getResources().getDrawable(R.drawable.ts_tranchau);
        byte[] anh2=convertDrawableToByte(hinh2);

        Drawable hinh3=getResources().getDrawable(R.drawable.cua_rang_me);
        byte[] anh3=convertDrawableToByte(hinh3);
        dsMonAn.add(new MonAn(1,"cafe",1,15000,anh1));
        dsMonAn.add(new MonAn(2,"Trà sữa trân châu",2,50000,anh2));
        dsMonAn.add(new MonAn(3,"Cua rang me",3,150000,anh3));
        adapterMonAn=new AdapterMonAn(this,R.layout.item_listview_mon_an,dsMonAn);
        lvMonAn.setAdapter(adapterMonAn);

    }

    private void addControllTab1() {
        gvBan = (GridView) findViewById(R.id.mh2_gvBan);
        dsBan = new ArrayList<>();
        dsBan.add(new Ban(1, 3));
        dsBan.add(new Ban(2, 1));
        dsBan.add(new Ban(3, 5));
        dsBan.add(new Ban(4, 7));
        dsBan.add(new Ban(5, 4));
        dsBan.add(new Ban(6, 2));
        adapter = new AdapterBan(this, R.layout.item_gridview_ban, dsBan);
        gvBan.setAdapter(adapter);
    }
    public byte[] convertDrawableToByte(Drawable drawable){
        BitmapDrawable bitmapDrawable= (BitmapDrawable) drawable;
        Bitmap bitmap=bitmapDrawable.getBitmap();
        ByteArrayOutputStream byteArray=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArray);
        byte[] hinhAnh=byteArray.toByteArray();
        return hinhAnh;
    }
}
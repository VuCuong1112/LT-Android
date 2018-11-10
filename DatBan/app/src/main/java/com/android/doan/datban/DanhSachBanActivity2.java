package com.android.doan.datban;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.android.doan.datban.adapter.AdapterBan;
import com.android.doan.datban.entity.Ban;

import java.util.ArrayList;

public class DanhSachBanActivity2 extends Activity {
GridView gvBan;
ArrayList<Ban> dsBan;
AdapterBan adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_ban2);
        gvBan = (GridView) findViewById(R.id.mh2_gvBan);
        dsBan = new ArrayList<>();
        dsBan.add(new Ban(1, 3));
        dsBan.add(new Ban(2, 1));
        dsBan.add(new Ban(3, 5));
        dsBan.add(new Ban(4, 7));
        dsBan.add(new Ban(5, 4));
        dsBan.add(new Ban(6, 2));
        adapter = new AdapterBan(DanhSachBanActivity2.this, R.layout.item_gridview_ban, dsBan);
        gvBan.setAdapter(adapter);
    }

}

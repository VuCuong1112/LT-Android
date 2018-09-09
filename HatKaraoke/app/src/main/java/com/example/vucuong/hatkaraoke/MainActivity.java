package com.example.vucuong.hatkaraoke;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

import com.example.vucuong.adapter.MusicAdapter;
import com.example.vucuong.modules.Music;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabHost tabHost;
    ArrayList<Music> arrMusic,arrFavorite;
    MusicAdapter musicAdapter,favoriteAdapter;
    ListView lvMusic,lvFavorite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControll();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControll() {
        tabHost= (TabHost) findViewById(R.id.tabhost);
        lvMusic= (ListView) findViewById(R.id.lvMusic);
        lvFavorite= (ListView) findViewById(R.id.lvFavorite);
        arrMusic=new ArrayList<>();
        arrFavorite=new ArrayList<>();
        khoiTaoMusic();
        musicAdapter=new MusicAdapter(MainActivity.this,R.layout.item,arrMusic);
        lvMusic.setAdapter(musicAdapter);


        favoriteAdapter=new MusicAdapter(MainActivity.this,R.layout.item,arrFavorite);
        lvFavorite.setAdapter(favoriteAdapter);


        tabHost.setup();
        TabHost.TabSpec tab1=tabHost.newTabSpec("tab1");
        tab1.setIndicator("", getResources().getDrawable(R.drawable.music));
        tab1.setContent(R.id.tab1);
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2=tabHost.newTabSpec("tab2");
        tab2.setIndicator("", getResources().getDrawable(R.drawable.favorite));
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if(tabId.equalsIgnoreCase("tab1"))
                    xuLyHienThiMusic();
                else
                    xulyHienThiFavorite();
            }
        });



    }

    private void xulyHienThiFavorite() {
        arrFavorite.clear();// xoá dữ liệu
        for (Music i:arrMusic){
            if(i.isSoThich())
                arrFavorite.add(i);
        }
        favoriteAdapter.notifyDataSetChanged();
        musicAdapter.notifyDataSetChanged();
    }

    private void xuLyHienThiMusic() {
        for (Music i:arrMusic){
            if(!i.isSoThich())
                arrFavorite.remove(i);
        }
        favoriteAdapter.notifyDataSetChanged();
        musicAdapter.notifyDataSetChanged();
    }

    private void khoiTaoMusic() {
        arrMusic.add(new Music(111,"Anh yêu em","Khắc Việt",false));
        arrMusic.add(new Music(22384,"Em luôn ở trong trái tim anh","The men",false));
        arrMusic.add(new Music(5454,"Người tôi yêu","Chi Dân",true));
        arrMusic.add(new Music(23432,"Buồn không em","Đạt G",false));
        arrMusic.add(new Music(75676,"Duyên mình lỡ","Hương Tràm",false));
        arrMusic.add(new Music(5345,"Đừng quên tên anh","Hoa Vinh",false));
        arrMusic.add(new Music(6464,"Yêu rồi","Tino",false));
        arrMusic.add(new Music(12133,"Tận cùng nỗi nhớ","Will",false));
        arrMusic.add(new Music(980978,"Luỵ tình","Lâm Chấn Huy",false));
        arrMusic.add(new Music(534546,"Tôi là tôi","Quoách Thành Danh",false));
    }
}

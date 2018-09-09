package com.example.vucuong.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.vucuong.hatkaraoke.R;
import com.example.vucuong.modules.Music;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VuCuong on 9/5/2018.
 */

public class MusicAdapter extends ArrayAdapter<Music> {
    Activity context;
    int resource;
    List<Music> objects;
    public MusicAdapter(Activity context,int resource,ArrayList<Music> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(this.resource,null);
        final Music music=this.objects.get(position);
        TextView txtMa,txtTen,txtCaSi;
        ImageButton btnLike,btnDisLike;
        txtCaSi= (TextView) row.findViewById(R.id.txtCaSi);
        txtMa= (TextView) row.findViewById(R.id.txtMa);
        txtTen= (TextView) row.findViewById(R.id.txtTen);
        btnDisLike= (ImageButton) row.findViewById(R.id.btnDisLike);
        btnLike= (ImageButton) row.findViewById(R.id.btnLike);

        txtMa.setText(music.getMaBH()+"");
        txtTen.setText(music.getTenBH());
        txtCaSi.setText(music.getCaSi());
        if(music.isSoThich()){
            btnDisLike.setVisibility(View.VISIBLE);
            btnLike.setVisibility(View.INVISIBLE);
        }
        else{
            btnDisLike.setVisibility(View.INVISIBLE);
            btnLike.setVisibility(View.VISIBLE);
        }
        btnDisLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyDisLike(music);
            }
        });
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyLike(music);
            }
        });

        return row;
    }

    private void xuLyDisLike(Music music) {
        music.setSoThich(false);
    }

    private void xuLyLike(Music music) {
        music.setSoThich(true);
    }


}

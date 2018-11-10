package com.android.doan.datban.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.doan.datban.R;
import com.android.doan.datban.entity.MonAn;

import java.util.List;

public class AdapterMonAn extends ArrayAdapter<MonAn> {
    Activity context;
    int resource;
    List<MonAn> objects;
    public AdapterMonAn(Activity context, int resource, List<MonAn> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(this.resource,null);
        ImageView imgHinh=(ImageView)row.findViewById(R.id.mh3_ImgMonAn);
        TextView txtTen=(TextView) row.findViewById(R.id.mh3_txtTenMon);
        TextView txtGia=(TextView) row.findViewById(R.id.mh3_txtDonGia);
        MonAn m=objects.get(position);
        txtTen.setText(m.getTenMon().toString());
        txtGia.setText(m.getDonGia()+"");
        imgHinh.setImageResource(m.getHinhAnh());
        return row;
    }
}

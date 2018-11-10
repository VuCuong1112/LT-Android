package com.android.doan.datban.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.doan.datban.R;
import com.android.doan.datban.entity.Ban;

import java.util.List;

public class AdapterBan extends ArrayAdapter<Ban> {
    Activity context;
    int resource;
    List<Ban> objects;
    public AdapterBan(Activity context, int resource, List<Ban> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(this.resource,null);
        TextView txtBan=(TextView)row.findViewById(R.id.mh2_txtSoBan);
        ImageView imgBan=(ImageView)row.findViewById(R.id.mh2_ImgBan);
        Ban b=objects.get(position);
       txtBan.setText(b.getMaBan()+"");
        imgBan.setImageResource(R.drawable.icon_ban);
        return row;
    }

}

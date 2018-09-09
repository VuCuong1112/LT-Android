package com.vucuong1112.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.vucuong1112.module.Contact;
import com.vucuong1112.projectcontact.R;
import com.vucuong1112.projectcontact.smsActivity;

import java.util.List;


public class ContactAdapter extends ArrayAdapter<Contact> {
    Activity context;
    int resource;
    List<Contact> objects;

    public ContactAdapter(Activity context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView txtContactName, txtcontactPhone;
        ImageButton btnCall, btnSMS, btnUpdate, btnDelete;
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);
        txtContactName = (TextView) row.findViewById(R.id.txtContactName);
        txtcontactPhone = (TextView) row.findViewById(R.id.txtContactPhone);
        final Contact c = this.objects.get(position);
        txtContactName.setText(c.getName()+"");
        txtcontactPhone.setText(c.getPhoneNumber()+"");
        btnCall = (ImageButton) row.findViewById(R.id.btnCall);
        btnDelete = (ImageButton) row.findViewById(R.id.btnDelete);
        btnSMS = (ImageButton) row.findViewById(R.id.btnSMS);
        btnUpdate = (ImageButton) row.findViewById(R.id.btnUpdate);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyCall(c);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyDelete(c);
            }
        });
        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLySMS(c);
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyUpdate(c);
            }
        });
        return row;
    }

    private void xuLyUpdate(Contact c) {
    }

    private void xuLySMS(Contact c) {
        Intent intent=new Intent(this.context,smsActivity.class);
        intent.putExtra("contact",c);
        this.context.startActivity(intent);
    }

    private void xuLyDelete(Contact c) {
        objects.remove(c);
    }

    private void xuLyCall(Contact c) {
        Uri uri = Uri.parse("tel:" + c.getPhoneNumber());
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(uri);
        if (ActivityCompat.checkSelfPermission(this.context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        this.context.startActivity(intent);
    }

}

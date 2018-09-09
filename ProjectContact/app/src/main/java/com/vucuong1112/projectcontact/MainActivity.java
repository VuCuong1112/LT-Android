package com.vucuong1112.projectcontact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.vucuong1112.adapter.ContactAdapter;
import com.vucuong1112.module.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TabHost tabHost;
    ListView lvContact;
    ArrayList<Contact> dsContact;
    ContactAdapter contactAdapter;

    EditText txtName,txtPhone;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyLuu();
            }
        });
    }

    private void xuLyLuu() {
        Contact c=new Contact(txtName.getText().toString(),txtPhone.getText().toString());
        dsContact.add(c);
        contactAdapter.notifyDataSetChanged();
    }

    private void addControls() {
        tabHost=(TabHost) findViewById(R.id.tabhost);
        tabHost.setup();
        TabHost.TabSpec tab1=tabHost.newTabSpec("tab1");
        tab1.setIndicator("Thêm liên lạc");
        tab1.setContent(R.id.tab1);
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2=tabHost.newTabSpec("tab2");
        tab2.setIndicator("Danh bạ");
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);


        txtName=(EditText)findViewById(R.id.txtName);
        txtPhone=(EditText)findViewById(R.id.txtPhone);
        btnSave=(Button) findViewById(R.id.btnSave);
        lvContact=(ListView) findViewById(R.id.lvContact);
        dsContact=new ArrayList<>();
        contactAdapter=new ContactAdapter(MainActivity.this,R.layout.item,dsContact);
        lvContact.setAdapter(contactAdapter);


    }
}

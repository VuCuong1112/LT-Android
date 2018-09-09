package com.example.vucuong.hoctabselector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtA,txtB;
    Button btncong,btnTru,btnNhan,btnChia;

    ArrayList<String> arrKetQua;
    ArrayAdapter<String> adapterKetQua;
    ListView lvHistory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControll();
        addEvents();
    }

    private void addEvents() {
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyCong();
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyTru();
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyNhan();
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyChia();
            }
        });
    }

    private void xuLyChia() {
        int a=Integer.parseInt(txtA.getText().toString());
        int b=Integer.parseInt(txtB.getText().toString());
        if(b==0){
            Toast.makeText(this, "Không thể chia cho số 0", Toast.LENGTH_SHORT).show();
            changeData(a+" / "+b+" = "+"null");
            return ;
        }
        String kq=a+" / "+b+" = " +(a/b);
        changeData(kq);
    }

    private void xuLyNhan() {
        int a=Integer.parseInt(txtA.getText().toString());
        int b=Integer.parseInt(txtB.getText().toString());
        String kq=a+" * "+b+" = " +(a*b);
        changeData(kq);
    }

    private void xuLyTru() {
        int a=Integer.parseInt(txtA.getText().toString());
        int b=Integer.parseInt(txtB.getText().toString());
        String kq=a+" - "+b+" = " +(a-b);
        changeData(kq);
    }

    private void xuLyCong() {
        int a=Integer.parseInt(txtA.getText().toString());
        int b=Integer.parseInt(txtB.getText().toString());
        String kq=a+" + "+b+" = " +(a+b);
        changeData(kq);
    }

    private void changeData(String kq) {
        arrKetQua.add(kq);
        adapterKetQua.notifyDataSetChanged();
        txtA.setText("");
        txtB.setText("");
        txtA.requestFocus();
    }

    private void addControll() {
        txtA= (TextView) findViewById(R.id.txtA);
        txtB= (TextView) findViewById(R.id.txtB);
        btncong= (Button) findViewById(R.id.btnCong);
        btnTru= (Button) findViewById(R.id.btnTru);
        btnNhan= (Button) findViewById(R.id.btnNhan);
        btnChia= (Button) findViewById(R.id.btnChia);
        lvHistory= (ListView) findViewById(R.id.lvHistory);

        arrKetQua=new ArrayList<String>();
        adapterKetQua=new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrKetQua
        );
        lvHistory.setAdapter(adapterKetQua);

        TabHost tabHost= (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();
        TabHost.TabSpec tab1;
        tab1 =tabHost.newTabSpec("tab1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("Cộng");
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2=tabHost.newTabSpec("tab2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("Kết quả");
        tabHost.addTab(tab2);
    }
}

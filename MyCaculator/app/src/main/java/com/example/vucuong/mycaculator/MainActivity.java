package com.example.vucuong.mycaculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnDelte, btnKhong, btnMot, btnHai, btnBa, btnBon, btnNam, btnSau, btnBay, btnTam, btnChin, btnDauCham,
            btnCong, btnTru, btnNhan, btnChia, btnBang;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }
    private void addEvent() {
        // TODO Auto-generated method stub
        btnDelte.setOnClickListener(this);
        btnMot.setOnClickListener(this);
        btnHai.setOnClickListener(this);
        btnBa.setOnClickListener(this);
        btnBon.setOnClickListener(this);
        btnNam.setOnClickListener(this);
        btnSau.setOnClickListener(this);
        btnBay.setOnClickListener(this);
        btnTam.setOnClickListener(this);
        btnChin.setOnClickListener(this);
        btnDauCham.setOnClickListener(this);
        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
        btnBang.setOnClickListener(this);
        btnKhong.setOnClickListener(this);
    }
    private void addControl() {
        // TODO Auto-generated method stub
        btnDelte = (Button) findViewById(R.id.btnDelete);
        btnKhong = (Button) findViewById(R.id.btnKhong);
        btnMot = (Button) findViewById(R.id.btnMot);
        btnHai = (Button) findViewById(R.id.btnHai);
        btnBa = (Button) findViewById(R.id.btnBa);
        btnBon = (Button) findViewById(R.id.btnBon);
        btnNam = (Button) findViewById(R.id.btnNam);
        btnSau = (Button) findViewById(R.id.btnSau);
        btnBay = (Button) findViewById(R.id.btnBay);
        btnTam = (Button) findViewById(R.id.btnTam);
        btnChin = (Button) findViewById(R.id.btnChin);
        btnDauCham = (Button) findViewById(R.id.btnDauCham);
        btnCong = (Button) findViewById(R.id.btnCong);
        btnTru = (Button) findViewById(R.id.btnTru);
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnChia = (Button) findViewById(R.id.btnChia);
        btnBang = (Button) findViewById(R.id.btnBang);
        txtKetQua = (TextView) findViewById(R.id.txtKetQua);
    }

    @Override
    public void onClick(View v) {
        txtKetQua.setText("");
        double ketQua = Double.parseDouble((String) txtKetQua.getText());
        if (v.getId() == R.id.btnDelete) {
            txtKetQua.setText("");
            txtKetQua.requestFocus();
        }
        if (v.getId() == R.id.btnKhong) {

            txtKetQua.setText(ketQua + btnKhong.getText().toString());
        }
        if (v.getId() == R.id.btnMot) {

            txtKetQua.setText(ketQua + btnMot.getText().toString());
        }
        if (v.getId() == R.id.btnHai) {

            txtKetQua.setText(ketQua + btnHai.getText().toString());
        }
        if (v.getId() == R.id.btnBa) {

            txtKetQua.setText(ketQua + btnBa.getText().toString());
        }
        if (v.getId() == R.id.btnBon) {

            txtKetQua.setText(ketQua + btnBon.getText().toString());
        }
        if (v.getId() == R.id.btnNam) {

            txtKetQua.setText(ketQua + btnNam.getText().toString());
        }
        if (v.getId() == R.id.btnSau) {

            txtKetQua.setText(ketQua + btnSau.getText().toString());
        }
        if (v.getId() == R.id.btnBay) {

            txtKetQua.setText(ketQua + btnBay.getText().toString());
        }
        if (v.getId() == R.id.btnTam) {

            txtKetQua.setText(ketQua + btnTam.getText().toString());
        }
        if (v.getId() == R.id.btnChin) {

            txtKetQua.setText(ketQua + btnChin.getText().toString());
        }
        if (v.getId() == R.id.btnDauCham) {

            txtKetQua.setText(ketQua + btnDauCham.getText().toString());
        }
        if (v.getId() == R.id.btnCong) {

            txtKetQua.setText(ketQua + btnCong.getText().toString());
        }
        if (v.getId() == R.id.btnTru) {

            txtKetQua.setText(ketQua + btnTru.getText().toString());
        }
        if (v.getId() == R.id.btnNhan) {

            txtKetQua.setText(ketQua + btnNhan.getText().toString());
        }
        if (v.getId() == R.id.btnChia) {

            txtKetQua.setText(ketQua + btnChia.getText().toString());
        }

    }
}


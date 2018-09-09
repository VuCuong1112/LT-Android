package com.example.vucuong.module21_baitap1;

import android.content.Context;
import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtResult;
    EditText txtA,txtB;
    Button btnTong,btnHieu,btnTich,btnThuong,btnUocCLN,btnThoat;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControll();
        addEvent();
    }

    private void addEvent() {
        btnThoat.setOnClickListener(this);
        btnTong.setOnClickListener(this);
        btnUocCLN.setOnClickListener(this);
        btnHieu.setOnClickListener(this);
        btnTich.setOnClickListener(this);
        btnThuong.setOnClickListener(this);
    }
    private void addControll(){
        txtResult=(TextView)findViewById(R.id.txtResult);
        txtA=(EditText)findViewById(R.id.txtA);
        txtB=(EditText)findViewById(R.id.txtB);
        btnTong=(Button) findViewById(R.id.btnTong);
        btnHieu=(Button) findViewById(R.id.btnHieu);
        btnTich=(Button) findViewById(R.id.btnTich);
        btnThuong=(Button) findViewById(R.id.btnThuong);
        btnUocCLN=(Button) findViewById(R.id.btnUocCLN);
        btnThoat=(Button)findViewById(R.id.btnThoat);
    }

    @Override
    public void onClick(View v) {
        float a=Float.parseFloat(txtA.getText().toString());
        float b= Float.parseFloat(txtB.getText().toString());
        float kq=0;
        if(v.getId()==R.id.btnThoat)
            finish();
        if(v.getId()==R.id.btnCong)
            kq=a+b;
        if(v.getId()==R.id.btnHieu)
            kq=a-b;
        if(v.getId()==R.id.btnTich)
            kq=a*b;
        if(v.getId()==R.id.btnThuong)
        {
            if(b==0)
            {
                Toast.makeText(context,"Không thể chia cho số 0",Toast.LENGTH_SHORT).show();
                return;
            }
            kq=a/b;
        }
        txtResult.setText(kq+"");
    }
}

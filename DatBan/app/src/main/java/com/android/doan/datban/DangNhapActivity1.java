package com.android.doan.datban;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DangNhapActivity1 extends Activity {
Button btnSign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap1);
        btnSign=(Button)findViewById(R.id.mh1_btnSignIn);
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DangNhapActivity1.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}

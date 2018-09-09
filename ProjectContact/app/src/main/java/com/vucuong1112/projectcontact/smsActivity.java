package com.vucuong1112.projectcontact;


import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vucuong1112.module.Contact;

public class smsActivity extends AppCompatActivity {
    EditText txtCallName,txtContext;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        addControll();
        addEvent();

    }

    private void addEvent() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=getIntent();
                Contact c= (Contact) i.getSerializableExtra("contact");
                xuLyGuiSMS(c);
            }
        });
    }

    private void xuLyGuiSMS(Contact c) {

    }


    private void addControll() {
        txtContext=(EditText)findViewById(R.id.txtContext);
        txtCallName=(EditText)findViewById(R.id.txtCallName);
        btnSend=(Button)findViewById(R.id.btnSend);
    }

//    public void xuLyGuiSMS(View view) {
//        // lấy mặc định sms default
//        final SmsManager sms=SmsManager.getDefault();
//        Intent mssent=new Intent(Intent.ACTION_SEND);
//        // kiểm soát gửi thành công hay thất bại
//        final PendingIntent pendingIntent=PendingIntent.getBroadcast(this,0,mssent,0);
//        registerReceiver(new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                int result=getResultCode();
//                String msg="Gửi thành công";
//                if(result!= Activity.RESULT_OK)
//                     msg="Gửi thất bại";
//                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
//            }
//        }, new IntentFilter(Intent.ACTION_SEND));
//    }
}

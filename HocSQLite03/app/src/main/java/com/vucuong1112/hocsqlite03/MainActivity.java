package com.vucuong1112.hocsqlite03;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vucuong1112.hocsqlite03.dao.DatabaseHelper;
import com.vucuong1112.hocsqlite03.model.Note;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ListView lvNote;
    ArrayAdapter<Note> adapterNote;
    ArrayList<Note> dsNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControll();
        addEvent();
    }

    private void addEvent() {
    }

    private void addControll() {
        lvNote=findViewById(R.id.lvNote);
        DatabaseHelper db=new DatabaseHelper(this);
        db.createDeaultRecord();
        dsNote=new ArrayList<>();
        dsNote=db.getALLNote();
        adapterNote=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,dsNote);
        lvNote.setAdapter(adapterNote);
    }
}

package com.vucuong1112.hocsqlite03.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.vucuong1112.hocsqlite03.model.Note;


import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME ="Note_Manager";
    private static final String TAG = "SQLite";
    private static final String TABLE_NAME ="Note";
    private static final String COLM_ID = "ID";
    private static final String COLM_TITLE = "TITLE";
    private static final String COLM_CONTENT ="CONTENT" ;

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    // tạo bảng
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG,"DatabaseHelper.onCreate...");
        String s="Create table " +TABLE_NAME+"("
                + COLM_ID+" integer primary key,"
                +COLM_TITLE+" text,"
                +COLM_CONTENT+" text)";
        // chạy lệnh tạo bảng
        db.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG,"DatabaseHelper.onUpgrade...");
        // xoá bảng cũ, nếu tồn tại
        db.execSQL("drop table if exists "+TABLE_NAME);
        // và tạo lại bảng
        onCreate(db);
    }
    // nếu trong bảng chưa có dữ liệu thêm vào 2 bảng ghi mặc định
    public void createDeaultRecord(){
        int count=getNoteCount();// lấy số dòng trong bảng
        if(count==0){
            Note n1=new Note(1,"Todo 1","Lean English");
            Note n2=new Note(2,"Todo 2","Lean toan");
            addNote(n1);
            addNote(n2);
        }
    }
// thêm 1 dòng vào bảng
    public void addNote(Note note) {
        Log.i(TAG,"DatabaseHelper.addNote...");
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        int row=getNoteCount();
        values.put(COLM_ID,row+1);
        values.put(COLM_TITLE,note.getTitle());
        values.put(COLM_CONTENT,note.getContent());
        db.insert(TABLE_NAME,null,values);
        // đóng kết nối db
        db.close();
    }


    public int getNoteCount() {
        Log.i(TAG,"DatabaseHelper.getNoteCount...");
        String query="select *  from " +TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        int count=cursor.getCount();
        cursor.close();
        return count;
    }
    public void updateNote(Note note){
        Log.i(TAG,"DatabaseHelper.updateNote...");
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLM_TITLE,note.getTitle());
        values.put(COLM_CONTENT,note.getContent());
        // update
        db.update(TABLE_NAME,values,COLM_ID+"=?",new String[]{String.valueOf(note.getId())});
        db.close();

    }
    public void deleteNote(Note note){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME,COLM_ID+"=?",new String[]{String.valueOf(note.getId())});
        db.close();

    }
    // đọc toàn bộ bảng
    public ArrayList<Note> getALLNote(){
        ArrayList<Note> dsNote=new ArrayList<>();
        // select all query
        String query="select * from " +TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        // duyệt cursor và thêm vào ds
        if (cursor.moveToFirst()){
            do {
                Note n=new Note();
                n.setId(Integer.parseInt(cursor.getString(0)));
                n.setContent(cursor.getString(2));
                n.setTitle(cursor.getString(1));

                // thêm vào ds
                dsNote.add(n);

            }while (cursor.moveToNext());
        }
        return dsNote;
    }
    // lấy 1 node dựa vào id
    public Note getNote(int id){
        Note note=new Note();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME,new String[]{COLM_ID,COLM_TITLE,COLM_CONTENT},
                COLM_ID+"=?",new String[]{String.valueOf(id)},
                null,null,null);
        if(cursor!=null)
            cursor.moveToFirst();
        note.setId(Integer.parseInt(cursor.getString(0)));
        note.setTitle(cursor.getString(1));
        note.setContent(cursor.getString(2));
        return note;
    }
}

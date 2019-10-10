package com.example.a5_contact_v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.a5_contact_v2.model.Contact;

import java.util.ArrayList;

public class MyDataBase extends SQLiteOpenHelper {
    private static int VERSION = 1;
    private static String DATABASE_NAME = "Contact_Manager";

    public MyDataBase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String script = "Create table contact (id INTEGER Primary Key, name TEXT,phone TEXT)";
        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void updateContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        contentValues.put("name", contact.getmName());
        contentValues.put("phone", contact.getmPhone());
        db.update("contact",contentValues,"id = ?", new String[]{String.valueOf(contact.getmId())});
        Log.d("debug","da update"+contact.getmId());
        db.close();
    }
    public void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", contact.getmName());
        values.put("phone", contact.getmPhone());
        db.insert("Contact", null, values);
    }

    public ArrayList<Contact> getAllContact() {
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        String script = "Select * from Contact";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(script, null);
        while (cursor.moveToNext()) {
            Contact contact = new Contact();
            contact.setmId(cursor.getInt(0));
            contact.setmName(cursor.getString(1));
            contact.setmPhone((cursor.getString(2)));
            contacts.add(contact);
        }
        return contacts;
    }

    public void deleteContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Contact", "id=0", new String[]{String.valueOf(contact.getmId())});
        db.close();
    }

}

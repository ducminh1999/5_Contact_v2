
package com.example.a5_contact_v2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;


import com.example.a5_contact_v2.Adapter.CustomAdapter;
import com.example.a5_contact_v2.model.Contact;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private EditText edtSearch;
    private FloatingActionButton fabAdd;
    //    private ImageButton imgbtnAvt;
//    private ImageButton imgbtnCall;
    private ImageButton imgbtnSearch;
    private ArrayList<Contact> contacts;
    private ArrayList<Contact> arrayList;
    MyDataBase db;
    private ListView lvContact;
    private CustomAdapter<Contact> customAdapter;
    private Contact infor1, infor2;
    int vitri;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtSearch = (EditText) findViewById(R.id.edt_search);
        imgbtnSearch = findViewById(R.id.imgbtn_search);
        lvContact = (ListView) findViewById(R.id.lv_contact);
        contacts=new ArrayList<Contact>();
        db=new MyDataBase(this);
        contacts=db.getAllContact();

        customAdapter = new CustomAdapter<Contact>(this, android.R.layout.simple_list_item_1, contacts);
        lvContact.setAdapter(customAdapter);
        lvContact.deferNotifyDataSetChanged();
        Widget();
    }

    public void EditContact() {
        Intent intent = new Intent(MainActivity.this, MainEditContactActivity.class);
        Bundle bundle= new Bundle();
        bundle.putSerializable("contact", contacts.get(vitri));
        intent.putExtra("package", bundle);
        startActivityForResult(intent, 100);
    }

    public void Widget() {
        fabAdd = (FloatingActionButton) findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainAddContactActivity.class);
                startActivityForResult(intent, 10);
            }
        });
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("debug1", "LV");
                vitri=position;
                EditContact();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        Log.d("debug1", "comming back");
        if (requestCode == 10 && resultCode == RESULT_OK) {
            Bundle bundle = data.getBundleExtra("package");
            Contact contact = (Contact) bundle.getSerializable("contact");
            if (data != null) {
                contacts.add(contact);
                db.addContact(contact);
                db.getAllContact();
                customAdapter.notifyDataSetChanged();
            }
        }
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Bundle bundle = data.getBundleExtra("package");
            Contact contact = (Contact) bundle.getSerializable("contact");
            contact.setmId(vitri+1);
            db.updateContact(contact);
            db.getAllContact();
            contacts.set(vitri,contact);
            customAdapter.notifyDataSetChanged();
        }
    }
}
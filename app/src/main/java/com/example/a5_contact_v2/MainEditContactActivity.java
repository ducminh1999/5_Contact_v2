package com.example.a5_contact_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.a5_contact_v2.model.Contact;

public class MainEditContactActivity extends AppCompatActivity {

    private TextView tvEditContact;
    private EditText edtName;
    private EditText edtPhone;
    private ImageButton imgbtnCancel;
    private ImageButton imgbtnDone;
    private ImageButton imgbtnAvt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_edit_contact);
        init();
        nhan();

        imgbtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("debug1", "editdone");
                Intent intent = new Intent();
                String name = (String) edtName.getText().toString();
                String phone = (String) edtPhone.getText().toString();
                Contact contact = new Contact(name, phone);
                Bundle bundle = new Bundle();
                bundle.putSerializable("contact", contact);
                intent.putExtra("package", bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        imgbtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("debug1", "editcancel");
                Intent intent = new Intent();
                finish();
            }
        });
    }

    public  void nhan(){
        Intent intent = this.getIntent();
        Bundle bundle = intent.getBundleExtra("package");
        Contact contact = (Contact) bundle.getSerializable("contact");
        edtName.setText(contact.getmName());
        edtPhone.setText(contact.getmPhone());
    }
    public void init() {
        tvEditContact = (TextView) findViewById(R.id.tv_edit_contact);
        edtName = (EditText) findViewById(R.id.edt_name);
        edtPhone = (EditText) findViewById(R.id.edt_phone);
        imgbtnCancel = findViewById(R.id.imgbtn_cancel);
        imgbtnDone = findViewById(R.id.imgbtn_done);
        imgbtnAvt = findViewById(R.id.imgbtn_avt);
    }
}
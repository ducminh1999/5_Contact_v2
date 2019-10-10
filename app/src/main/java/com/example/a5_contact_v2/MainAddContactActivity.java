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

public class MainAddContactActivity extends AppCompatActivity {

    private TextView tvEditContact;
    private EditText edtName1;
    private EditText edtPhone1;

    private ImageButton imgbtnCancel;
    private ImageButton imgbtnDone;
    private ImageButton imgbtnAvt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_add_contact);
        init();

        imgbtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("debug1", "ADDdone");
                Intent intent = new Intent();
                String name = (String) edtName1.getText().toString();
                String phone = (String) edtPhone1.getText().toString();
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
                Log.d("debug1", "ADdcancel");
                Intent intent = new Intent();
                finish();
            }
        });
    }
    public void init() {
        tvEditContact = (TextView) findViewById(R.id.tv_edit_contact);
        edtName1 = (EditText) findViewById(R.id.edt_name1);
        edtPhone1 = (EditText) findViewById(R.id.edt_phone1);
        imgbtnCancel = (ImageButton)findViewById(R.id.imgbtn_cancel);
        imgbtnDone = (ImageButton) findViewById(R.id.imgbtn_done);
        imgbtnAvt = (ImageButton)findViewById(R.id.imgbtn_avt);
    }
}
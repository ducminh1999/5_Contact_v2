package com.example.a5_contact_v2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.a5_contact_v2.R;
import com.example.a5_contact_v2.model.Contact;
import java.util.List;

public class CustomAdapter<C> extends ArrayAdapter<Contact> {

    private static final String TAG = null ;
    private Context context;
    private int resource;
    private List<Contact> arrayContact;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Contact> arrContact) {
        super(context, resource, arrContact);
        this.context = context;
        this.resource = resource;
        this.arrayContact = arrContact;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.row_list_view, parent, false);
            viewHolder.imgviewAvt = (ImageView) convertView.findViewById(R.id.imgview_avt);
            viewHolder.imgviewCall = (ImageView) convertView.findViewById(R.id.imgview_call);
            viewHolder.tvInfor = (TextView) convertView.findViewById(R.id.tv_infor);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Contact contact = arrayContact.get(position);
        viewHolder.tvInfor.setText(contact.getmName());
//        viewHolder.imgAvt.setBackgroundResource(contact.getmAvt());
//        viewHolder.imgAvt.setText(String.valueOf(position+1));

//        viewHolder.imgviewAvt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("debug1", "Viewholder");
//                Intent intent = new Intent(context, MainEditContactActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("contact", (Serializable) arrayContact.get(position));
//                intent.putExtra("package", bundle);
//                context.startActivity(intent);
//            }
//        });

//        Intent intent = this.getIntent();
//        Bundle bundle = intent.getBundleExtra("package");
//        Contact contact = (Contact) bundle.getSerializable("contact");
//        edtName.setText(contact.getmName());
//        viewHolder.tvInfor.setText(contact.getmName());

       // Log.d(TAG, "getView"+ position);
        return convertView;
    }
    public class ViewHolder {
        ImageView imgviewAvt;
        TextView tvInfor;
        ImageView imgviewCall;

    }
}


package com.example.ltandroid_lab7_sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterContact extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Contact> listContact;

    public AdapterContact(Context context, int layout, List<Contact> listStudent) {
        this.context = context;
        this.layout = layout;
        this.listContact = listStudent;
    }

    @Override
    public int getCount() {
        return listContact.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        TextView txtHeader = view.findViewById(R.id.txt_Name);

        Contact contact = listContact.get(i);
        txtHeader.setText(contact.getName());
        return view;
    }

}

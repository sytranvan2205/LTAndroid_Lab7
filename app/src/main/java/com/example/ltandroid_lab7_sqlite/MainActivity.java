package com.example.ltandroid_lab7_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvStudent;
    List<Contact> listStudent;
    AdapterContact adapter;
    int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Database_Handler db = new Database_Handler(this);
        lvStudent = findViewById(R.id.lvContact);

//         Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Đỗ Anh Bôn"));
        db.addContact(new Contact("Hoàng Quốc Cường"));
        db.addContact(new Contact("Phạm Minh Dũng"));
        db.addContact(new Contact("Châu Hoàng Duy"));
        db.addContact(new Contact("Nguyễn Đình Hảo"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        listStudent = db.getAllContacts();

        adapter = new AdapterContact(this, R.layout.icon_item, listStudent);
        lvStudent.setAdapter(adapter);

        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
            }
        });

        // Add Item When click button
        Button btnAdd = findViewById(R.id.btnAdd);
        EditText edtName = findViewById(R.id.editText);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edtName.getText().toString().trim().length() < 1) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên bạn muốn thêm", Toast.LENGTH_SHORT).show();
                    return;
                }
                Contact contact = new Contact(edtName.getText().toString().trim());
                db.addContact(contact);
                listStudent.add(contact);
                Log.d("Add", "Add Complicated ");
                adapter.notifyDataSetChanged();
            }
        });

        Button btnRemove = findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == -1) {
                    Toast.makeText(MainActivity.this, "Chọn Student muốn xoá", Toast.LENGTH_SHORT).show();
                }
                else {
                    Contact contact = listStudent.get(position);
                    db.deleteContact(contact);
                    listStudent.remove(position);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        Button btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }

}
package com.example.ltandroid_lab7_sqlite;

import java.io.Serializable;

public class Contact implements Serializable {
    private int _id;
    private String name;

    public Contact() {
    }

    public Contact(String name) {
        this.name = name;
    }

    public Contact(int _id, String name) {
        this._id = _id;
        this.name = name;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

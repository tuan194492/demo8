package com.example.demo8.model;

import java.util.Date;

public class SinhVien {
    private int id;
    private String name;
    private Date birth;

    public SinhVien() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}


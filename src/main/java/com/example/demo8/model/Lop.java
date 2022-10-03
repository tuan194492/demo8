package com.example.demo8.model;

import java.util.List;

public class Lop {
    private int id;
    private String name;
    private int lopTruongId;

    private List<SinhVien> sinhVienList;

    public List<SinhVien> getSinhVienList() {
        return sinhVienList;
    }

    public void setSinhVienList(List<SinhVien> sinhVienList) {
        this.sinhVienList = sinhVienList;
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

    public int getLopTruongId() {
        return lopTruongId;
    }

    public void setLopTruongId(int lopTruongId) {
        this.lopTruongId = lopTruongId;
    }
}

package com.example.demo8.dto;

import com.example.demo8.model.SinhVien;

import java.sql.Connection;
import java.util.List;

public interface SinhVienDTO {
    Connection connect();
    void add(SinhVien sinhVien);
    List<SinhVien> selectAll();
    void update(SinhVien sinhVien);

    void deleteSinhVien(SinhVien sinhVien);
}
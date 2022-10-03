package com.example.demo8.dto;

import com.example.demo8.model.Lop;
import com.example.demo8.model.SinhVien;

import java.sql.Connection;
import java.util.List;

public interface ClassDTO {
    Connection connect();
    List<Lop> getLopList();
    void update(Lop lop);
    void deleteLop(Lop lop);
    void addLop(Lop lop);
    void setLopTruong(SinhVien sinhVien);
    void themSinhVien(SinhVien sinhVien);
    List<SinhVien> getSinhVienList(int classID);

}

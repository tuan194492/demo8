package com.example.demo8.controller;

import com.example.demo8.dto.PostgresqlSinhVienDTO;
import com.example.demo8.dto.SinhVienDTO;
import com.example.demo8.model.SinhVien;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named(value = "sinhVienController")
@SessionScoped
public class SinhVienController implements Serializable {
    public SinhVienController() {

    }
    SinhVienDTO sinhVienDTO = new PostgresqlSinhVienDTO();
    private List<SinhVien> sinhVienList;
    private SinhVien selectedSinhVien;

    public void setSinhVienList(List<SinhVien> sinhVienList) {
        this.sinhVienList = sinhVienList;
    }

    public void selectSinhVien(int id) {
        System.out.println("Hello world");
        for (SinhVien sinhVien : sinhVienList) {
            if (sinhVien.getId() == id) {
                selectedSinhVien = sinhVien;
                return;
            }
        }
        selectedSinhVien = null;
    }

    public void setSelectedSinhVien(SinhVien selectedSinhVien) {
        this.selectedSinhVien = selectedSinhVien;
    }

    public List<SinhVien> getSinhVienList() {
        System.out.println("Hello world from Tuan");
        sinhVienList = sinhVienDTO.selectAll();
        return sinhVienList;
    }

    public SinhVien getSelectedSinhVien() {
        return selectedSinhVien;
    }

    public String goToEditPage(SinhVien sinhVien) {
//        System.out.println(sinhVien.getId());
        if (sinhVien == null) {
            selectedSinhVien = null;
        } else {
            selectSinhVien(sinhVien.getId());
        }
        return "edit";
    }

    public String saveSinhVien(SinhVien sinhVien) {
        if (sinhVien.getId() <= 0) {
            sinhVienDTO.add(sinhVien);
        } else {
            sinhVienDTO.update(sinhVien);
        }
        return "index";
    }

    public String createSinhVien() {
        selectedSinhVien = new SinhVien();
        selectedSinhVien.setId(-1);
        return "edit";
    }

    public void deleteSinhVien(SinhVien sinhVien) {
        System.out.println("Delete sinh vien");
        sinhVienDTO.deleteSinhVien(sinhVien);
    }

}

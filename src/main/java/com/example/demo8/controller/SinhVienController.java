package com.example.demo8.controller;

import com.example.demo8.dto.PostgresqlSinhVienDTO;
import com.example.demo8.dto.SinhVienDTO;
import com.example.demo8.model.Lop;
import com.example.demo8.model.SinhVien;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named(value = "sinhVienController")
@ConversationScoped
public class SinhVienController  implements Serializable {
    public SinhVienController() {

    }
    private final SinhVienDTO sinhVienDTO = new PostgresqlSinhVienDTO();
    private List<SinhVien> sinhVienList;
    private SinhVien selectedSinhVien;

    public void setSinhVienList(List<SinhVien> sinhVienList) {
        this.sinhVienList = sinhVienList;
    }

    public void selectSinhVien(int id) {
//        System.out.println("Hello world");
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
//        System.out.println("Hello world from Tuan");
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
    public String createSinhVien(Lop lop) {
        selectedSinhVien = new SinhVien();
        selectedSinhVien.setId(-1);
        selectedSinhVien.setClassId(lop.getId());
        return "edit";
    }

    public void deleteSinhVien(SinhVien sinhVien) {
        System.out.println("Delete sinh vien");
        sinhVienDTO.deleteSinhVien(sinhVien);
    }

    @PostConstruct
    public void init() {
        System.out.println("Sinh Vien controller is created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Sinh Vien controller destroyed");
    }

}


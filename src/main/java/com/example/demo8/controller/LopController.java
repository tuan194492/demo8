package com.example.demo8.controller;

import com.example.demo8.dto.ClassDTO;
import com.example.demo8.dto.PosgresqlLopDTO;
import com.example.demo8.model.Lop;
import com.example.demo8.model.SinhVien;
import sun.applet.Main;

import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "lopController")
@SessionScoped
public class LopController implements Serializable {

    @ManagedProperty(value = "#{mainController}")
    private MainController mainController;
    private ClassDTO classDTO;
    private List<Lop> lopList;

    private Lop selectedLop;

    public Lop getSelectedLop() {
        return selectedLop;
    }

    public void selectLop(Lop lop) {
        if (lop != null)
            selectedLop = lop;
        else
           selectedLop = null;
    }

    public LopController() {
        classDTO = new PosgresqlLopDTO();
        selectedLop = null;
    }
    public List<Lop> getLopList() {
        lopList = classDTO.getLopList();
        return lopList;
    }

    public void deleteLop(Lop lop) {
        classDTO.deleteLop(lop);
    }

    public void addLop(Lop lop) {
        classDTO.addLop(lop);
    }

    public Lop getLopDetail() {
        if (selectedLop == null) return null;
        else {
            selectedLop.setSinhVienList(classDTO.getSinhVienList(selectedLop.getId()));
            return selectedLop;
        }
    }

    public void updateLop() {
        if (selectedLop != null)
            classDTO.update(selectedLop);
    }
}

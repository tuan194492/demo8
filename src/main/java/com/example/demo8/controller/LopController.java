package com.example.demo8.controller;

import com.example.demo8.dto.ClassDTO;
import com.example.demo8.dto.PosgresqlLopDTO;
import com.example.demo8.model.Lop;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "lopController")
@ConversationScoped
public class LopController implements Serializable {

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

    public void updateLop(Lop lop) {
        if (lop != null)
            classDTO.update(lop);
    }

    public void createNewClass() {
        Lop lop = new Lop();
        lop.setName("Default name");
        classDTO.addLop(lop);
    }

    public void unSelectLop() {
        selectedLop = null;
    }
    @PostConstruct
    public void init() {
        System.out.println("Lop controller is created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Lop controller destroyed");
    }
}

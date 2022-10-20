package com.example.demo8.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "class")
public class Lop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private int id;

    @Column(name = "name")
    private String name;

//    @Column(name = "loptruong_id")
//    private Integer lopTruongId;

    @OneToOne
    @JoinColumn(name = "loptruong_id", referencedColumnName = "student_id", nullable = true)
    private SinhVien lopTruong;

    @OneToMany(mappedBy = "lop")
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

//    public Integer getLopTruongId() {
//        return lopTruongId;
//    }
//
//    public void setLopTruongId(Integer lopTruongId) {
//        this.lopTruongId = lopTruongId;
//    }

    public void setLopTruong(SinhVien lopTruong) {
        this.lopTruong = lopTruong;
    }

    public SinhVien getLopTruong() {
        return lopTruong;
    }
}

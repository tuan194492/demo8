package com.example.demo8.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lop", schema = "public", catalog = "quanlysinhvien")
public class LopEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "class_id")
    private int classId;
    @Basic
    @Column(name = "loptruong_id")
    private Integer loptruongId;
    @Basic
    @Column(name = "name")
    private Object name;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Integer getLoptruongId() {
        return loptruongId;
    }

    public void setLoptruongId(Integer loptruongId) {
        this.loptruongId = loptruongId;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LopEntity lopEntity = (LopEntity) o;
        return classId == lopEntity.classId && Objects.equals(loptruongId, lopEntity.loptruongId) && Objects.equals(name, lopEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, loptruongId, name);
    }
}

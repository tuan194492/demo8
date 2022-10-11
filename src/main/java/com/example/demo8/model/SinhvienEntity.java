package com.example.demo8.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "sinhvien", schema = "public", catalog = "quanlysinhvien")
public class SinhvienEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "name")
    private Object name;
    @Basic
    @Column(name = "birth")
    private Date birth;
    @Basic
    @Column(name = "lop_id")
    private Integer lopId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getLopId() {
        return lopId;
    }

    public void setLopId(Integer lopId) {
        this.lopId = lopId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinhvienEntity that = (SinhvienEntity) o;
        return userId == that.userId && Objects.equals(name, that.name) && Objects.equals(birth, that.birth) && Objects.equals(lopId, that.lopId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, birth, lopId);
    }
}

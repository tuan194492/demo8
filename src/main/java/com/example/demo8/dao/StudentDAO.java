package com.example.demo8.dao;

import com.example.demo8.model.SinhVien;
import com.example.demo8.util.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class StudentDAO {
    public List<SinhVien> getAllSinhVien() {
        Session session = HibernateUtils.getSession();
        return session.createCriteria(SinhVien.class).list();
    }
}

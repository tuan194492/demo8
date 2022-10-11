package com.example.demo8.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    public static SessionFactory getSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            SessionFactoryBuilder sessionFactoryBuilder = new Standar

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

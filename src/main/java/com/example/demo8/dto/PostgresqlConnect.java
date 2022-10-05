package com.example.demo8.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlConnect {
    private static final String url = "jdbc:postgresql://localhost:5432/quanlysinhvien";
    private static final String username = "postgres";
    private static final String password = "#Tuan267";

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
//            System.out.println("Connect to DB success!");
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        return connection;
    }
}

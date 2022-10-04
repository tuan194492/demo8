package com.example.demo8.dto;

import com.example.demo8.model.SinhVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgresqlSinhVienDTO implements SinhVienDTO {
    private static final String url = "jdbc:postgresql://localhost:5432/quanlysinhvien";
    private static final String username = "postgres";
    private static final String password = "#Tuan267";

    @Override
    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connect to DB success!");
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        return connection;
    }

    @Override
    public void add(SinhVien sinhVien) {
        try {
            Connection connection = connect();
            String query = "INSERT INTO sinhvien (\"name\", birth, lop_id) VALUES(?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, sinhVien.getName());

            Date sqlDate = new Date(sinhVien.getBirth().getTime());
            statement.setDate(2, sqlDate);

            statement.setInt(3, sinhVien.getClassId());

            System.out.println("Current query is " + statement + " " + sinhVien.getBirth().toString());
            statement.execute();

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    @Override
    public List<SinhVien> selectAll() {
        List<SinhVien> sinhVienList = new ArrayList<>();

        try {
            Connection connection = connect();

            String query = "SELECT * FROM sinhvien";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                SinhVien sinhVien = new SinhVien();
                sinhVien.setId(resultSet.getInt("user_id"));
                sinhVien.setName(resultSet.getString("name"));
                sinhVien.setBirth(resultSet.getDate("birth"));
                sinhVien.setClassId(resultSet.getInt("lop_id"));
                sinhVienList.add(sinhVien);
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        }

        return sinhVienList;
    }

    @Override
    public void update(SinhVien sinhVien) {
        try {
            Connection connection = connect();

            String query =
                    "UPDATE sinhvien as sv " +
                            "SET " +
                            "\"name\" = ?, " +
                            "birth = ? ," +
                            "lop_id = ?" +
                            "WHERE sv.user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(4, sinhVien.getId());
            statement.setString(1, sinhVien.getName());

            Date sqlDate = new Date(sinhVien.getBirth().getTime());
            statement.setDate(2, sqlDate);

            statement.setInt(3, sinhVien.getClassId());

            System.out.println("Current query is " + statement);
            statement.execute();
            connection.close();
        } catch (Exception e ) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteSinhVien(SinhVien sinhVien) {
        try {
            Connection connection = connect();

            String query =
                    "DELETE FROM sinhvien WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, sinhVien.getId());

            statement.execute();
            connection.close();
        } catch (Exception e ) {
            System.out.println(e.getMessage());
        }
    }
}


package com.example.demo8.dto;

import com.example.demo8.model.Lop;
import com.example.demo8.model.SinhVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PosgresqlLopDTO implements ClassDTO{
    @Override
    public Connection connect() {
        return new PostgresqlSinhVienDTO().connect();
    }

    @Override
    public List<Lop> getLopList() {
        try {
            ArrayList<Lop> lopList = new ArrayList<>();
            Connection connection = connect();
            String query = "SELECT * FROM lop";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Lop lop = new Lop();
                lop.setId(resultSet.getInt("class_id"));
                lop.setLopTruongId(resultSet.getInt("loptruong_id"));
                lop.setName(resultSet.getString("name"));
                lopList.add(lop);
            }
            connection.close();

            return lopList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Lop lop) {
        try {
            Connection connection = connect();

            String query = "UPDATE lop SET \"name\" = ?, loptruong_id = ? " +
                    "WHERE lop.class_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, lop.getName());
            preparedStatement.setInt(2, lop.getLopTruongId());
            preparedStatement.setInt(3, lop.getId());
            preparedStatement.execute();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLop(Lop lop) {
        try {
            Connection connection = connect();
            String query = "DELETE FROM lop WHERE class_id = ? ";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, lop.getId());
            statement.execute();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addLop(Lop lop) {
        try {
            Connection connection = connect();
            String query = "INSERT INTO lop (\"name\") " +
                    "VALUES(?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, lop.getName());
            statement.execute();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SinhVien> getSinhVienList(int classID) {
        try {
            ArrayList<SinhVien> sinhVienList = new ArrayList<>();
            Connection connection = connect();
            String query = "SELECT sinhvien.* FROM lop, sinhvien WHERE sinhvien.lop_id = lop.class_id AND lop.class_id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, classID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SinhVien sinhVien = new SinhVien();
                sinhVien.setId(resultSet.getInt("user_id"));
                sinhVien.setName(resultSet.getString("name"));
                sinhVien.setBirth(resultSet.getDate("birth"));
                sinhVien.setClassId(classID);
                sinhVienList.add(sinhVien);
            }
            connection.close();

            return sinhVienList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

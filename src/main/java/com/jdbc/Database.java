package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private Connection con;

    public void connect() {
        try {
            this.con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/jdbc", "frank",
                    "password");
            System.out.println("Connection established.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Database() {
        this.connect();
        this.migrate();

    }

    private void migrate() {
        if (con != null) {
            String sql = "CREATE TABLE IF NOT EXISTS student (id serial PRIMARY KEY, full_names varchar(255), age int, school varchar(100))";
            PreparedStatement statement;
            try {
                statement = con.prepareStatement(sql);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insert(Student data) {
        try {
            String sql = "INSERT INTO student (full_names, age, school) VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, data.full_names);
            statement.setInt(2, data.age);
            statement.setString(3, data.school);
            statement.executeUpdate();
            System.out.println("Record created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student readOne(int id) {
        Student student = null;
        try {
            String sql = "SELECT full_names, age, school FROM student WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                String full_names = result.getString("full_names");
                String school = result.getString("school");
                int age = result.getInt("age");
                student = new Student(full_names, age, school);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public List<Student> read() {
        List<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT full_names, age, school FROM student";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String full_names = result.getString("full_names");
                String school = result.getString("school");
                int age = result.getInt("age");
                Student student = new Student(full_names, age, school);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void update(Student data, int id) {
        try {
            String sql = "UPDATE student SET full_names = ?, age = ?, school = ? WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, data.full_names);
            statement.setInt(2, data.age);
            statement.setString(3, data.school);
            statement.setInt(4, id);
            statement.executeUpdate();
            System.out.println("Record updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM student WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Record deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


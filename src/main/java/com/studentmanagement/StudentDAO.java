package com.studentmanagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public boolean addStudent(Student student) {
        String sql = "INSERT INTO students(name, email, course, phone) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setString(4, student.getPhone());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("Could not add student: " + e.getMessage());
            return false;
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT id, name, email, course, phone FROM students ORDER BY id";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("course"),
                        rs.getString("phone")));
            }
        } catch (SQLException e) {
            System.out.println("Could not fetch students: " + e.getMessage());
        }
        return students;
    }

    public Student getStudentById(int id) {
        String sql = "SELECT id, name, email, course, phone FROM students WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(rs.getInt("id"), rs.getString("name"),
                            rs.getString("email"), rs.getString("course"),
                            rs.getString("phone"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Could not search student: " + e.getMessage());
        }
        return null;
    }

    public boolean updateStudent(Student student) {
        String sql = "UPDATE students SET name=?, email=?, course=?, phone=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setString(4, student.getPhone());
            ps.setInt(5, student.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("Could not update student: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("Could not delete student: " + e.getMessage());
            return false;
        }
    }
}

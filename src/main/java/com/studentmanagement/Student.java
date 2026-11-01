package com.studentmanagement;

public class Student {
    private int id;
    private String name;
    private String email;
    private String course;
    private String phone;

    public Student(int id, String name, String email, String course, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.phone = phone;
    }

    public Student(String name, String email, String course, String phone) {
        this(0, name, email, course, phone);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }
    public String getPhone() { return phone; }

    @Override
    public String toString() {
        return String.format("%-5d %-22s %-30s %-18s %-15s",
                id, name, email, course, phone);
    }
}

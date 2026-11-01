package com.studentmanagement;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentDAO dao = new StudentDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add student");
            System.out.println("2. View all students");
            System.out.println("3. Search student by ID");
            System.out.println("4. Update student");
            System.out.println("5. Delete student");
            System.out.println("0. Exit");
            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 0 -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addStudent() {
        Student student = new Student(
                readText("Name: "),
                readText("Email: "),
                readText("Course: "),
                readText("Phone: "));
        System.out.println(dao.addStudent(student)
                ? "Student added successfully." : "Student was not added.");
    }

    private static void viewStudents() {
        List<Student> students = dao.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.printf("%-5s %-22s %-30s %-18s %-15s%n",
                "ID", "NAME", "EMAIL", "COURSE", "PHONE");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void searchStudent() {
        int id = readInt("Enter student ID: ");
        Student student = dao.getStudentById(id);
        System.out.println(student == null ? "Student not found." : student);
    }

    private static void updateStudent() {
        int id = readInt("Enter student ID to update: ");
        if (dao.getStudentById(id) == null) {
            System.out.println("Student not found.");
            return;
        }
        Student updated = new Student(id,
                readText("New name: "),
                readText("New email: "),
                readText("New course: "),
                readText("New phone: "));
        System.out.println(dao.updateStudent(updated)
                ? "Student updated successfully." : "Student was not updated.");
    }

    private static void deleteStudent() {
        int id = readInt("Enter student ID to delete: ");
        System.out.println(dao.deleteStudent(id)
                ? "Student deleted successfully." : "Student not found or could not be deleted.");
    }

    private static String readText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}

package edubridge_project;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String studentId;
    private List<String> courses;
    private double balance;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.courses = new ArrayList<>();
        this.balance = 0.0;
    }

    public void enroll(String course) {
        courses.add(course);
        balance += 600.0; 
    }

    public void payFees(double amount) {
        balance -= amount;
    }

    public void showStatus() {
        System.out.println("\n--- Student Status ---");
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentId);
        System.out.println("Courses Enrolled: " + courses);
        System.out.println("Balance: " + balance);
        System.out.println("----------------------");
    }

    public String getStudentId() {
        return studentId;
    }
}

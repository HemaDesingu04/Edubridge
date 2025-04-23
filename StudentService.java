package edubridge_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StudentService {
	
	    private List<String> availableCourses = Arrays.asList("Java", "Python", "Web Development", "Data Structures");

	    public List<String> getAvailableCourses() {
	        return availableCourses;
	    }
    private List<Student> students = new ArrayList<>();

    public String generateStudentId() {
    	
        Random random = new Random();
        return String.format("%05d", random.nextInt(100000));
    }

    public void addStudent(String name) {
    	
        String studentId = generateStudentId();
        Student student = new Student(name, studentId);
        students.add(student);
        System.out.println("Student added with ID: " + studentId);
    }

    public Student findStudent(String studentId) {
    	
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}

package edubridge_project;

import java.util.List;
import java.util.Scanner;

public class MainApp {
	
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
        	System.out.println("\n--------------Student Management System---------------");
            System.out.println("\n1. Add Student");
            System.out.println("2. Enroll in Course");
            System.out.println("3. Pay Fees");
            System.out.println("4. Show Status");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    service.addStudent(name);
                    break;
                    
                case 2:
                    System.out.print("Enter student ID: ");
                    String studentIdEnroll = scanner.nextLine();
                    Student studentEnroll = service.findStudent(studentIdEnroll);
                    
                    if (studentEnroll != null) {
                    	
                        List<String> courses = service.getAvailableCourses();
                        System.out.println("Available Courses:");
                        
                        for (int i = 0; i < courses.size(); i++) 
                        {
                            System.out.println((i + 1) + ". " + courses.get(i));
                        }

                        System.out.print("Enter course number to enroll: ");
                        int courseChoice = scanner.nextInt();
                        scanner.nextLine(); 

                        if (courseChoice >= 1 && courseChoice <= courses.size()) 
                        {
                            String course = courses.get(courseChoice - 1);
                            studentEnroll.enroll(course);
                            System.out.println("Enrolled successfully in " + course + "!");
                        } 
                        
                        else {
                            System.out.println("Invalid course selection.");
                        }
                    } 
                    
                    else 
                    {
                        System.out.println("Student not found!");
                    }
                    break;
               
                case 3:
                    System.out.print("Enter student ID: ");
                    String studentIdPay = scanner.nextLine();
                    Student studentPay = service.findStudent(studentIdPay);
                   
                    if (studentPay != null) {
                        System.out.print("Enter amount to pay: ");
                        double amount = scanner.nextDouble();
                        studentPay.payFees(amount);
                        System.out.println("Payment successful!");
                    } 
                    
                    else {
                        System.out.println("Student not found!");
                    }
                    break;
                
                case 4:
                    System.out.print("Enter student ID: ");
                    String studentIdStatus = scanner.nextLine();
                    Student studentStatus = service.findStudent(studentIdStatus);
                    
                    if (studentStatus != null) {
                        studentStatus.showStatus();
                    } 
                    
                    else {
                        System.out.println("Student not found!");
                    }
                    break;
                
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}


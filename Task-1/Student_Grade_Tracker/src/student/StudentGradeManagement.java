package student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

       
        System.out.println("     STUDENT GRADE MANAGEMENT");
        

        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numberOfStudents; i++) {

            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            Student student = new Student(name);

            System.out.print("Enter number of subjects: ");
            int numberOfSubjects = sc.nextInt();

            for (int j = 0; j < numberOfSubjects; j++) {

                double grade;

                while (true) {
                    System.out.print("Enter grade for Subject "
                            + (j + 1) + " (0-100): ");

                    grade = sc.nextDouble();

                    if (grade >= 0 && grade <= 100) {
                        break;
                    }

                    System.out.println("Invalid grade! Enter a value between 0 and 100.");
                }

                student.addGrade(grade);
            }

            sc.nextLine();
            students.add(student);
        }

        // Display summary report
       
        System.out.println("          SUMMARY REPORT");
       

        for (Student student : students) {
            student.displayReport();
            System.out.println("------------------------------------");
        }

        sc.close();
    }
}
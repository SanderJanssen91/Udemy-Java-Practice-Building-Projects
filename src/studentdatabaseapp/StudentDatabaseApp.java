package studentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {
    public static void main(String[] args) {
        System.out.println("How many students do you want to add to the database: ");
        Scanner in = new Scanner(System.in);
        int numberStudentsToAdd = in.nextInt();
        Student[] students = new Student[numberStudentsToAdd];
        for (int i = 0; i < numberStudentsToAdd; i++) {
            students[i] = new Student();
            students[i].enroll();
            students[i].payTuition();
        }
        for (Student student: students){
            student.showInfo();
        }
    }
}

package studentdatabaseapp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private GradeYear gradeYear;
    private int studentId;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int courseCost = 600;
    private static int[] id = {0, 0, 0, 0};  //[0] = freshman, [1] = sophomore, [2] = junior, [3] = senior


    //Constructor: prompt used to enter student's name and year
    public Student() {
        Scanner in = new Scanner(System.in);

        System.out.print("First Name:");
        this.firstName = in.next();

        System.out.print("Last Name:");
        this.lastName = in.next();

        System.out.println("Grade Year: \n1 for Freshman\n2 for Sophomore\n3 for Junior\n4 for Senior");
        int gradeYearCode = 0;
        while (gradeYearCode == 0) {
            gradeYearCode = in.nextInt();
            if (gradeYearCode > 0 && gradeYearCode < 5) {
                this.gradeYear = GradeYear.getGradeYearFromCode(gradeYearCode);
            } else {
                System.out.println("Please enter a valid grade year code");
                gradeYearCode = 0;
            }
        }

        this.studentId = generateStudentId();
    }

    //Generate an ID
    private int generateStudentId() {
        int studentId = (this.gradeYear.getGradeYearCode() * 10000 + id[this.gradeYear.getGradeYearCode() - 1]);
        this.id[this.gradeYear.getGradeYearCode() - 1] = this.id[this.gradeYear.getGradeYearCode() - 1]++;

        return studentId;
    }

    //Enroll in courses
    public void enroll() {
        // get inside loop, user hits Q when they are done enrolling
        boolean enrolling = true;
        while (enrolling) {
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (course.equalsIgnoreCase("Q")) {
                enrolling = false;
            } else {
                this.courses = this.courses + "\n" + course;
                this.tuitionBalance = this.tuitionBalance + this.getCourseCost();
            }
        }
    }

    //View balance

    public void viewBalance() {
        System.out.println("Your tuition balance is: $"+this.tuitionBalance);
    }

    //Pay tuition
    public void payTuition() {
        viewBalance();
        System.out.print("How much do you want to pay: $");
        Scanner in = new Scanner(System.in);
        setTuitionBalance(this.tuitionBalance-in.nextInt());
        viewBalance();
    }

    //print status
    public void showInfo(){
        System.out.println("\nName: "+getFirstName()+" "+getLastName() +
                "\nStudent ID: "+getStudentId() +
                "\nCourses Enrolled: "+getCourses() +
                "\nTuition Balance: $"+getTuitionBalance());
    }

    //getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GradeYear getGradeYear() {
        return gradeYear;
    }

    public void setGradeYear(GradeYear gradeYear) {
        this.gradeYear = gradeYear;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public int getTuitionBalance() {
        return tuitionBalance;
    }

    public void setTuitionBalance(int tuitionBalance) {
        this.tuitionBalance = tuitionBalance;
    }

    public int getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(int courseCost) {
        this.courseCost = courseCost;
    }
}



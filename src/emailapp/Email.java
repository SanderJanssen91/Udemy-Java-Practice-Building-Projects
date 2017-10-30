package emailapp;

import java.util.Scanner;

import static java.lang.Character.toLowerCase;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail ="Has not been set";
    private int defaultPasswordLength = 10;
    private String companySuffix = "google.com";

    //constructor receives first and last name and creates an Email object.
    public Email(String firstName, String lastName) {
        //set first and last name received from constructor
        this.firstName = firstName;
        this.lastName = lastName;

        //ask for- and set department
        this.department = setDepartment();

        //generate- and set random first password
        this.password = setRandomPassword(this.defaultPasswordLength);

        //combine elements to generate email
        email = generateEmail();
    }

    //method to show all the information
    public String showInfo(){
        return "DISPLAY NAME: "+this.firstName+" "+this.lastName+
                "\nDISPLAY DEPARTMENT "+this.department+
                "\nEMAIL ADDRESS: "+this.email+
                "\nPASSWORD: "+this.password+
                "\nMAILBOX CAPACITY: "+this.mailboxCapacity+
                "\nALTERNATE EMAIL: "+this.alternateEmail;
    }

    //method asking for the department - return department
    private String setDepartment() {
        System.out.println("Enter te department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if (departmentChoice == 1) {
            return "Sales";
        } else if (departmentChoice == 2) {
            return "Development";
        } else if (departmentChoice == 3) {
            return "Accounting";
        } else {
            return "";
        }
    }

    //generate a random first password
    private String setRandomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVW1234567890!@#$%^&*";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int randomLetter = (int) (Math.random() * passwordSet.length());
            double randomCase = Math.random();
            if (randomCase > 0.499 && randomLetter < 27) {
                password[i] = toLowerCase(passwordSet.charAt(randomLetter));
            } else {
                password[i] = passwordSet.charAt(randomLetter);
            }
        }
        return new String(password);
    }

    //generate email address
    private String generateEmail() {
        if (this.department.equalsIgnoreCase("")) {
            return this.standardizeString(this.firstName) + "." + standardizeString(this.lastName) + "@" + standardizeString(this.companySuffix);
        } else {
            return this.standardizeString(this.firstName) + "." + standardizeString(this.lastName) + "@" + standardizeString(this.department) + "." + standardizeString(this.companySuffix);
        }
    }

    //method to standardize email constructor input
    private String standardizeString(String string) {
        return string.toLowerCase().trim();
    }

    //set alternate email
    public void setAlternateEmail(String alternateEmail) {
//        System.out.println("Please provide your password to set an alternate Email address: ");
//        Scanner in = new Scanner(System.in);
//        String password = in.next();
//        if (password.equals(this.password)) {
            this.alternateEmail = alternateEmail;
            System.out.println("The alternate email address has been set to: " + this.alternateEmail);
//        } else {
//            System.out.println("Password incorrect, do you want to try again? Y/N");
//            String answerTryAgain = in.next();
//            if (answerTryAgain.equalsIgnoreCase("Y")) {
//                setAlternateEmail(alternateEmail);
//            } else if (answerTryAgain.equalsIgnoreCase("N")) {
//                System.out.println("Alternate email address has not been set");
//            } else {
//            }
//        }
    }

    //change password method
    public void changePassword(String oldPassword, String newPassword) {
        if (this.getPassword().equals(oldPassword)) {
            this.setPassword(newPassword);
        } else {
            System.out.println("Please provide the correct current password to change the password");
        }
    }

    //getter and setter methods
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }
}

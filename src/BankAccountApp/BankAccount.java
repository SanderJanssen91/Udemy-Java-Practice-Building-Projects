package BankAccountApp;

import java.util.List;
import java.util.Scanner;

public abstract class BankAccount implements IRate {
    protected String accountNumber;
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private int accountBalance = 0;
    private static int uniqueNumber = 10000;
    protected double rate;

    //constructor
    public BankAccount(String firstName, String lastName, String ssn, int initDeposit) {
        setFirstName(firstName);
        setLastName(lastName);
        setSocialSecurityNumber(ssn);
        setAccountBalance(initDeposit);
        accountNumber = generateAccountNumber();
        setAccountSpecificAdditions();
        setRate();
    }

    protected abstract void setRate();
    protected abstract void setAccountSpecificAdditions();
    protected abstract void showSpecificInfo();
    public abstract BankAccountType getBankAccountType();
    public abstract void setBankAccountType(BankAccountType bankAccountType);

    //Generate an account number
    public String generateAccountNumber() {
        String lastDigitsSsn = socialSecurityNumber.substring(socialSecurityNumber.length()-2);
        String uniqueNumber = "" + this.uniqueNumber;
        this.uniqueNumber++;
        String randomNumber = GenerateRandomSequence.generateNumberSequence(3);

            return lastDigitsSsn + uniqueNumber + randomNumber;
    }

    //Deposit methods
    public void depositByInput() {
        System.out.print("How much do you want to deposit: $");
        Scanner in = new Scanner(System.in);
        int amount = in.nextInt();
        if (amount > 0) {
            deposit(amount);
        } else {
            System.out.println("Please provide an amount larger than $0");
            showBalance();
            depositByInput();
        }
    }

    public void deposit(int amount) {
        if (amount > 0) {
            setAccountBalance(this.accountBalance + amount);
            showBalance();
        } else {
            System.out.println("Please provide an amount larger than $0");
            showBalance();
        }
    }

    //Withdraw method
    public void withdrawByInput() {
        System.out.print("How much do you want to withdraw: $");
        Scanner in = new Scanner(System.in);
        int amount = in.nextInt();
        if (amount > 0) {
            withdraw(amount);
        } else {
            System.out.println("Please provide an amount larger than $0");
            showBalance();
            depositByInput();
        }
    }

    public void withdraw(int amount) {
        if (amount > 0) {
            setAccountBalance(this.accountBalance - amount);
            System.out.println("You have successfully withdrawn $" + amount + ".");
            showBalance();
        } else {
            System.out.println("Please provide an amount larger than $0");
            showBalance();
        }
    }

    //transfer method
    public void transferInput() {
        System.out.print("Please provide the bank account number of the account you want to transfer the money to: ");
        Scanner in = new Scanner(System.in);
        String accountNumber = in.next();
        System.out.print("How much do you want to transfer: $");
        int amount = in.nextInt();
        boolean successful = transfer(amount, accountNumber);
        if (!successful) {
            transferInput();
        }
    }

    public boolean transfer(int amount, String bankAccountNumber) {
        List<BankAccount> bankAccounts = BankAccountApp.getBankAccounts();
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getAccountNumber().equalsIgnoreCase(bankAccountNumber)) {
                if (amount < 0) {
                    System.out.println("Please provide a valid amount to transfer.\nTRANSFER TERMINATED.");
                } else {
                    setAccountBalance(getAccountBalance() - amount);
                    bankAccount.setAccountBalance(bankAccount.getAccountBalance() + amount);
                    System.out.println("TRANSFER SUCCESSFUL\n");
                    return true;
                }
            } else {
            }
        }
        System.out.println("Please provide a valid account number to transfer the money to.\nTRANSFER TERMINATED.");
        return false;
    }

    //showinfo methods
    public void showBalance() {
        System.out.println("Your current account balance is: $" + getAccountBalance() + ".");
    }

    public void showInfo() {
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Bank account type: " + getBankAccountType());
        System.out.println("Bank account number: " + getAccountNumber());
        showBalance();
        showSpecificInfo();
    }

    public void compound() {
        double accruedInterest = accountBalance * rate/100;
        System.out.println("Accrued Interest "+accruedInterest);
        setAccountBalance(getAccountBalance()+(int)accruedInterest);
    }

    //getters and setters
    public String getAccountNumber() {
        return accountNumber;
    }

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

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }
}

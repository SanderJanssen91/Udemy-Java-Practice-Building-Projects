package BankAccountApp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BankAccountApp {

    private static List<BankAccount> bankAccounts;

    private static List<BankAccount> readNewBankAccountsFile(String path) {
        List<BankAccount> bankAccountsRead = new ArrayList<BankAccount>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader in = new InputStreamReader(fis);
            BufferedReader binr = new BufferedReader(in);
            String inputLine;
            while (binr.ready() && (inputLine = binr.readLine()) != null) {
                String[] info = inputLine.trim().split(",");
                String[] name = info[0].trim().split(" ");
                String firstName = name[0];
                String lastName = name[1];
                String ssn = info[1];
                String accountType = info[2];
                int initDeposit = Integer.parseInt(info[3]);
                if (accountType.equalsIgnoreCase("savings")) {
                    BankAccount savingsAccount = new SavingsAccount(firstName, lastName, ssn, initDeposit);
                    bankAccountsRead.add(savingsAccount);
                } else {
                    BankAccount checkingAccount = new CheckingAccount(firstName, lastName, ssn, initDeposit);
                    bankAccountsRead.add(checkingAccount);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.print("Exception in reading file: ");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bankAccountsRead;
    }

    public static List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public static void main(String[] args) {
        bankAccounts = readNewBankAccountsFile("NewBankAccounts.csv");
//        System.out.println("----------TRANSFER TEST-------------");
//        System.out.println("BANK ACCOUNT 1 BEFORE TRANSFER: ");
//        bankAccounts.get(1).showInfo();
//        System.out.println("BANK ACCOUNT 2 BEFORE TRANSFER: ");
//        bankAccounts.get(2).showInfo();
//
//        bankAccounts.get(2).transfer(200,bankAccounts.get(1).getAccountNumber());
//
//        System.out.println("BANK ACCOUNT 1 AFTER TRANSFER: ");
//        bankAccounts.get(1).showInfo();
//        System.out.println("BANK ACCOUNT 2 AFTER TRANSFER: ");
//        bankAccounts.get(2).showInfo();
//        System.out.println("----------TRANSFER TEST-------------");
//        System.out.println();
//
//        System.out.println("----------WITHDRAW TEST-------------");
//        System.out.println("BANK ACCOUNT 4 BEFORE WITHDRAW: ");
//        bankAccounts.get(4).showInfo();
//
//        bankAccounts.get(4).withdraw(600);
//
//        System.out.println("BANK ACCOUNT 4 AFTER WITHDRAW: ");
//        bankAccounts.get(4).showInfo();
//        System.out.println("----------WITHDRAW TEST-------------");
//        System.out.println();

//        System.out.println("----------WITHDRAW INPUT TEST-------------");
//        System.out.println("BANK ACCOUNT 6 BEFORE WITHDRAW: ");
//        bankAccounts.get(5).showInfo();
//
//        bankAccounts.get(5).withdrawByInput();
//
//        System.out.println("BANK ACCOUNT 6 AFTER WITHDRAW: ");
//        bankAccounts.get(5).showInfo();
//        System.out.println("----------WITHDRAW INPUT TEST-------------");

        System.out.println("----------COMPOUND TEST-------------");
        System.out.println("BANK ACCOUNT 6 BEFORE WITHDRAW: ");
        bankAccounts.get(5).showInfo();

        bankAccounts.get(5).compound();

        System.out.println("BANK ACCOUNT 6 AFTER WITHDRAW: ");
        bankAccounts.get(5).showInfo();
        System.out.println("----------COMPOUND TEST-------------");
    }
}

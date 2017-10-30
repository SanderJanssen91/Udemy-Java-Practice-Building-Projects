package BankAccountApp;

public class SavingsAccount extends BankAccount {
    private static final BankAccountType bankAccountType = BankAccountType.SAVINGS;
    private SafetyDepositBox safetyDepositBox;

    public SavingsAccount(String firstName, String lastName, String ssn, int initDeposit) {
        super(firstName, lastName, ssn, initDeposit);
       }

    protected void setAccountSpecificAdditions(){
        generateSDB();
    }

    public String generateAccountNumber() {
        int startingNumber = 1;
        return ""+startingNumber + super.generateAccountNumber();
    }

    public BankAccountType getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(BankAccountType bankAccountType) {
        bankAccountType = bankAccountType;
    }

    private void generateSDB(){
        this.safetyDepositBox = new SafetyDepositBox();
    }

    protected void showSpecificInfo(){
        System.out.println(safetyDepositBox);
        System.out.println("Your interest rate is: "+this.rate);
    }

    public void setRate(){
        this.rate = getBaseRate()-0.25;
    }
}

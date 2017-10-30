package BankAccountApp;

public class CheckingAccount extends BankAccount {
    private static final BankAccountType bankAccountType = BankAccountType.CHECKING;
    private DebitCard debitCard;

    public CheckingAccount(String firstName, String lastName, String ssn, int initDeposit) {
        super(firstName, lastName, ssn, initDeposit);
    }

    public void setRate(){
        this.rate = getBaseRate()*0.15;
    }

    protected void setAccountSpecificAdditions(){
        generateDC();
    }

    public String generateAccountNumber() {
        int startingNumber = 2;
        return ""+ startingNumber + super.generateAccountNumber();
    }

    public BankAccountType getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(BankAccountType bankAccountType) {
        bankAccountType = bankAccountType;
    }

    private void generateDC(){
        this.debitCard = new DebitCard();
    }

    protected void showSpecificInfo(){
        System.out.println(debitCard);
        System.out.println("Your interest rate is: "+this.rate);
    }
}

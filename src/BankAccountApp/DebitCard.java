package BankAccountApp;

public class DebitCard {
    private String debitCardId;
    private String debitCardPin;

    public DebitCard() {
        generateDebitCardId();
        generateDebitCardPin();
    }

    private void generateDebitCardId() {
        this.debitCardId = GenerateRandomSequence.generateNumberSequence(12);
    }

    private void generateDebitCardPin() {
        this.debitCardPin = GenerateRandomSequence.generateNumberSequence(4);
    }

    public String toString(){
        return "Debit Card ID: "+ this.debitCardId+", Debit Card Pin: "+this.debitCardPin;
    }
}

package BankAccountApp;

public class SafetyDepositBox {
    private String safetyDepositBoxId;
    private String safetyDepositBoxPin;

    public SafetyDepositBox() {
        generateSafetyDepositBoxId();
        generateSafetyDepositBoxPin();
    }

    private void generateSafetyDepositBoxId() {
        this.safetyDepositBoxId = GenerateRandomSequence.generateNumberSequence(3);
    }

    private void generateSafetyDepositBoxPin() {
        this.safetyDepositBoxPin = GenerateRandomSequence.generateNumberSequence(4);
    }
     public String toString(){
         return "Safety Deposit Box ID: "+ this.safetyDepositBoxId+", Safety Deposit Box Pin: "+this.safetyDepositBoxPin;
     }
}

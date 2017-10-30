package BankAccountApp;

public enum BankAccountType {
    SAVINGS(1, "Savings"), CHECKING(2, "Checking");


    private String title;
    private int typeCode;

    BankAccountType(int n, String title) {
        this.title = title;
        this.typeCode = n;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString(){
        return getTitle();
    }

    public BankAccountType getTypeFromTypeCode(int n){
        switch (n) {
            case 2:
                return BankAccountType.SAVINGS;
            default:
                return BankAccountType.CHECKING;
        }
    }
}

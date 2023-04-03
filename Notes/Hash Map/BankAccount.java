public class BankAccount {
    private int accountNumber;
    private String accountType;

    public BankAccount(String accountType, int accountNumber) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void displayAccountInfo() {
        System.out.println(
            "Type of Account: " + accountType
            + "\nAccount Number: " + accountNumber
        );
    }


}
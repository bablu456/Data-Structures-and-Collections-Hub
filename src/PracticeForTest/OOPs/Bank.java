package PracticeForTest.OOPs;

public class Bank {
    private String accountNumber;
    private Double balance;

    Bank(String accountNumber, Double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {

    }
}

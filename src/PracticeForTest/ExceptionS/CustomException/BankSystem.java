package PracticeForTest.ExceptionS.CustomException;

public class BankSystem {
    double balance ;
    String accountNo;

    BankSystem(String accountNo, double balance){
        this.accountNo = accountNo;
        this.balance = balance;
    }

    void addBalance(double balance){
        if(balance>0){
            this.balance += balance;
            System.out.println("Balance added successfully. New balance: "+this.balance);
        }
    }

    void withdraw(double amount) throws InsufficientFundsException{
        if(amount>0 && amount<=this.balance){
            this.balance -= amount;
            System.out.println("Withdrawal successful. New balance: "+this.balance);
        } else {
            throw new InsufficientFundsException("Insufficient funds for withdrawal of amount: "+amount);
        }
    }
    public static void main(String[] args){
        BankSystem bankSystem = new BankSystem("123Bablu",100);
        bankSystem.addBalance(50);
        try {
            bankSystem.withdraw(200);
        }catch (InsufficientFundsException e){
            System.out.println("Exception caught: "+e.getMessage());
        }
    }
}

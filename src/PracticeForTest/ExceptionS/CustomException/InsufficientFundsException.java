package PracticeForTest.ExceptionS.CustomException;

public class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String message){
        super(message);
    }
}

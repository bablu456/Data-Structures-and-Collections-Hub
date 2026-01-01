package PracticeForTest.simpleApp;

public class DataAccessException extends Exception {
    public DataAccessException(String message, Throwable cause) {
        super(message, cause);   // cause preserved
    }
}


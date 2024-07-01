package Exceptions;

public class InsufficientAmountException extends Exception{
    private static final long serialVersion= 1L;

    public InsufficientAmountException(double amount){
        super("amount is negative");
    }
}

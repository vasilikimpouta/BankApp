package Exceptions;

public class InsufficientBalanceException extends Exception{
    private static final long serialVersionUniqueId =1l;

    public InsufficientBalanceException(){

    }; // protimame na exei pliroforia

    public InsufficientBalanceException(double balance, double amount){
        super("Insufficient balance"+ balance + " for amount:"+ amount);
    }
}

package Exceptions;

public class SsnIsNotValid extends Exception{
    private static final long serialVersionUID = 1l;

    public SsnIsNotValid(String ssn){
        super("Ssn" + ssn + " is not valid");
    }
}

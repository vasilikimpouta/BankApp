package Model;

import Exceptions.InsufficientAmountException;
import Exceptions.InsufficientBalanceException;
import Exceptions.SsnIsNotValid;
import Model.IdentifiableEntity;

public class Account extends IdentifiableEntity {
    private User holder;
    private String Iban;
    private double balance;

    public Account() {
        //super();
    }

    ;

    public Account(User holder, String iban, double balance) {
        this.holder = holder;
        Iban = iban;
        this.balance = balance;
    }

    public User getHolder() {
        return holder;
    }

    public void setHolder(User holder) {
        this.holder = holder;
    }

    public String getIban() {
        return Iban;
    }

    public void setIban(String iban) {
        Iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //public API

    /**
     *
     * @param amount
     * @throws InsufficientAmountException
     */
    public void deposit(double amount) throws InsufficientAmountException {
        try {
            if (amount < 0) {
                throw new InsufficientAmountException(amount);
            }
            balance += amount;

        } catch (InsufficientAmountException e) {
            System.err.println("error : negative amount");
            throw e;
        }
    }

    /**
     *
     * @param amount
     * @param ssn
     * @throws InsufficientBalanceException
     * @throws InsufficientAmountException
     * @throws SsnIsNotValid
     */
    public void withdraw(double amount, String ssn) throws InsufficientBalanceException, InsufficientAmountException, SsnIsNotValid {
        try {
            if (amount < 0) {
                throw new InsufficientAmountException(amount);
            }
            if (amount > balance) {
                throw new InsufficientBalanceException(balance, amount);
            }
            if (!ssnIsValid(ssn)) {
                throw new SsnIsNotValid(ssn);
            }
            balance -= amount;
        } catch (InsufficientBalanceException | InsufficientAmountException | SsnIsNotValid e) {
            System.out.println("error");
            throw e;
        }
    }

    protected boolean ssnIsValid(String ssn) {
        if (ssn == null || holder.getSsn() == null) {
            return false;
        }
        return holder.getSsn().equals(ssn);
    }

    @Override
    public String toString() {
        return "Account{" +
                "holder=" + holder +
                ", Iban='" + Iban + '\'' +
                ", balance=" + balance +
                '}';
    }
}

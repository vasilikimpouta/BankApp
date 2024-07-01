package Model;

import Exceptions.InsufficientAmountException;
import Exceptions.InsufficientBalanceException;
import Exceptions.SsnIsNotValid;

public class OverDraftAccount extends Account {
    public OverDraftAccount() throws SsnIsNotValid {

    }

    public OverDraftAccount(User holder, String iban, double balance) {
        super(holder, iban, balance);
    }

    @Override
    public void withdraw(double amount, String ssn) throws InsufficientAmountException, SsnIsNotValid {
        try {
            if (amount < 0) {
                throw new InsufficientAmountException(amount);
            }

            if (!ssnIsValid(ssn)) {
                throw new SsnIsNotValid(ssn);
            }
            setBalance(getBalance() - amount);

        } catch (InsufficientAmountException | SsnIsNotValid e) {
            System.out.println("error");
            throw e;
        }
    }
}

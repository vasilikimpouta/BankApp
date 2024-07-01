package Model;

import Exceptions.InsufficientAmountException;
import Exceptions.SsnIsNotValid;

public class OverDraftJointAccount extends JointAccount{
    public OverDraftJointAccount(){}

    public OverDraftJointAccount(User user) {
        super(user);
    }
    public OverDraftJointAccount(User holder, String iban, double balance, User user) {
        super(holder, iban, balance, user);
    }

    public  void withdraw(double amount, String ssn) throws InsufficientAmountException ,SsnIsNotValid{
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

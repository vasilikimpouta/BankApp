package Model;

public class JointAccount extends Account {
    private User secondHandlerUser = new User();

    public JointAccount(User user) {
        this.secondHandlerUser = user;
    }

    public JointAccount() {
    }

    ;

    public JointAccount(User holder, String iban, double balance, User user) {
        super(holder, iban, balance);
        this.secondHandlerUser = user;
    }

    public User getSecondHandlerUser() {
        return secondHandlerUser;
    }

    public void setSecondHandlerUser(User secondHandlerUser) {
        this.secondHandlerUser = secondHandlerUser;
    }

    @Override
    protected boolean ssnIsValid(String ssn) {
        return super.ssnIsValid(ssn) || secondHandlerUser.getSsn().equals(ssn);
    }

    @Override
    public String toString() {
        return "JointAccount{ First Holder" + getHolder() +
                "secondHandlerUser=" + secondHandlerUser + "Balance:" + getBalance() + "iban: " + getIban() +
                '}';
    }
}

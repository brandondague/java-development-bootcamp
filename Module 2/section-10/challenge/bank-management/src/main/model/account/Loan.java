package src.main.model.account;

public class Loan extends Account{

    public static final double WITHDRAWAL_INTEREST = .02;
    public static final int WITHDRAWAL_LIMIT = 10000;

    public Loan(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Loan(Loan source) {
        super(source);
    }

    @Override
    public void deposit(double amount) {
        super.setBalance(super.round(super.getBalance() - amount));
    }

    @Override
    public boolean withdraw(double amount) {
        if (super.round(super.getBalance() + (amount + (amount * WITHDRAWAL_INTEREST))) < WITHDRAWAL_LIMIT) {
            super.setBalance(super.round(super.getBalance() + (amount + (amount * WITHDRAWAL_INTEREST))));
            return true;
        }
        return false;
    }

    @Override
    public Account clone() {
        return new Loan(this);
    }

}

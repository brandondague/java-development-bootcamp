package src.main.model.account;

import src.main.model.account.impl.Taxable;

public class Chequing extends Account implements Taxable{

    public static final double OVERDRAFT_FEE = 5.50;
    public static final int OVERDRAFT_LIMIT = -200;
    public static final int UNTAXED_INCOME = 3000;
    public static final double INCOME_TAX = 0.15;
    
    public Chequing(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Chequing(Chequing source) {
        super(source);
    }

    @Override
    public void deposit(double amount) {
        super.setBalance(super.round(super.getBalance() + amount));
    }

    @Override
    public boolean withdraw(double amount) {
        if (super.round(super.getBalance() - amount) >= OVERDRAFT_LIMIT) {
            super.setBalance(super.round(super.getBalance() - amount));
            if (super.getBalance() < 0) {
                super.setBalance(super.round(super.getBalance() - OVERDRAFT_FEE));
                return true;
            }
            return true;
        }
        return false;
    }

    @Override
    public Account clone() {
        return new Chequing(this);
    }

    @Override
    public void tax(double income) {
        income -= UNTAXED_INCOME;
        super.setBalance(super.round(super.getBalance() - (income * INCOME_TAX)));
    }

}

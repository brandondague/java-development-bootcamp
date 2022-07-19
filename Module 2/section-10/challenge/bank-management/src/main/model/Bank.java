package src.main.model;

import java.util.ArrayList;

import src.main.model.account.Account;

public class Bank {

    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;


    public Bank() {
        this.accounts = new ArrayList<Account>(accounts);
        this.transactions = new ArrayList<Transaction>(transactions);
    }

    /**
     * Name: addAccount
     * @param account (Account)
     * 
     * Inside the function:
     *   1. adds an account to the accounts ArrayList
     */

     public void addAccount(Account account) {
        this.accounts.add(account.clone());
     }

}

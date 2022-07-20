package src.main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import src.main.model.account.Account;

public class Bank {

    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;


    public Bank() {
        this.accounts = new ArrayList<Account>(accounts);
        this.transactions = new ArrayList<Transaction>(transactions);
    }

    public void addAccount(Account account) {
        this.accounts.add(account.clone());
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(new Transaction(transaction));
    }

    public Transaction[] getTransactions(String accountId) {
        List<Transaction> list = this.transactions.stream()
                                                  .filter((transaction) -> transaction.getId().equals(accountId))
                                                  .collect(Collectors.toList());

        return list.toArray(new Transaction[list.size()]);
    }

}

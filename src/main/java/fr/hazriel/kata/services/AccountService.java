package fr.hazriel.kata.services;

import java.util.List;

import fr.hazriel.kata.models.Account;
import fr.hazriel.kata.models.AccountOwner;
import fr.hazriel.kata.models.Transaction;

public interface AccountService {
    public List<Transaction> getUserTransactions(AccountOwner owner);

    public void deposit(Account account, double amount);
    public void withdraw(Account account, double amount);
}

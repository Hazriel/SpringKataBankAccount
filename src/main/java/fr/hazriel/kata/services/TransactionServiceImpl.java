package fr.hazriel.kata.services;

import java.util.List;

import fr.hazriel.kata.models.Account;
import fr.hazriel.kata.models.Transaction;
import fr.hazriel.kata.repositories.AccountRepository;
import fr.hazriel.kata.repositories.TransactionRepository;

public class TransactionServiceImpl implements TransactionService {
    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    public List<Transaction> getTransactionsForAccount(Long accountId) {
        if (accountId == null) {
            throw new NullPointerException("Must have an account id");
        }

        accountRepository.findById(accountId).orElseThrow();

        return transactionRepository.findByAccountId(accountId);
    }

    public Transaction createTransaction(Long accountId, Double amount) {
        if (accountId == null || amount == null) {
            throw new NullPointerException("Must have an account id and a correct amount");
        }

        Account account = accountRepository.findById(accountId).orElseThrow();

        Transaction transaction = new Transaction(null, account, amount);

        transaction = transactionRepository.save(transaction);

        return transaction;
    }
}

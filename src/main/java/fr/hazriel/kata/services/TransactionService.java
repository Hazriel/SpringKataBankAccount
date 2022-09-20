package fr.hazriel.kata.services;

import java.util.List;

import fr.hazriel.kata.models.Transaction;

public interface TransactionService {
    public List<Transaction> getTransactionsForAccount(Long accountId);
    public Transaction createTransaction(Long accountId, Double amount);
}

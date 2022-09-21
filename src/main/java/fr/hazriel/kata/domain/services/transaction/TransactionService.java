package fr.hazriel.kata.domain.services.transaction;

import java.util.List;

import fr.hazriel.kata.domain.models.Transaction;

public interface TransactionService {
    public List<Transaction> getTransactionsForAccount(Long accountId);
    public Transaction createTransaction(Long accountId, Double amount);
}

package fr.hazriel.kata.dto;

import fr.hazriel.kata.models.Transaction;

public class PresentationMapper {
    public static TransactionDto TransactionToPresentation(Transaction transaction) {
        return new TransactionDto(transaction.getAccount().getId(), transaction.getAmount());
    }
}

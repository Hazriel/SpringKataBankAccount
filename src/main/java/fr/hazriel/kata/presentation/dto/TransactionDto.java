package fr.hazriel.kata.presentation.dto;

import java.time.LocalDateTime;

public class TransactionDto {
    private Long transactionId;
    private Long accountId;
    private Double amount;
    private LocalDateTime time;

    public TransactionDto(Long transactionId, Long accountId, Double amount, LocalDateTime time) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
        this.time = time;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Long getTransactionId() {
        return transactionId;
    }
}

package fr.hazriel.kata.dto;

public class TransactionDto {
    private Long accountId;
    private Double amount;

    public TransactionDto(Long accountId, Double amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Double getAmount() {
        return amount;
    }
}

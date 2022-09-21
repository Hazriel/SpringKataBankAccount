package fr.hazriel.kata.presentation.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AccountDto {
    private Long accountId;
    private Double money;
    private AccountOwnerDto owner;
    private List<TransactionDto> transactions;
    private LocalDateTime createdAt;

    public AccountDto(Long accountId, Double money, AccountOwnerDto owner, List<TransactionDto> transactions, LocalDateTime createdAt) {
        this.accountId = accountId;
        this.money = money;
        this.owner = owner;
        this.transactions = transactions;
        this.createdAt = createdAt;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Double getMoney() {
        return money;
    }

    public List<TransactionDto> getTransactions() {
        return transactions;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public AccountOwnerDto getOwner() {
        return owner;
    }
}

package fr.hazriel.kata.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account {
    @Id
    private Long id;
    private Double money;
    @ManyToOne
    private AccountOwner owner;
    @OneToMany
    private List<Transaction> transactions;

    private LocalDate createdAt;

    public Account(Long id, Double money, AccountOwner owner, List<Transaction> transactions, LocalDate createdAt) {
        this.id = id;
        this.money = money;
        this.owner = owner;
        this.transactions = transactions;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public AccountOwner getOwner() {
        return owner;
    }

    public void setOwner(AccountOwner owner) {
        this.owner = owner;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    
}

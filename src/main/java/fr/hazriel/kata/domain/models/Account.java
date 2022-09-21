package fr.hazriel.kata.domain.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private Double money;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private AccountOwner owner;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

    private LocalDateTime createdAt;

    public Account() {}

    public Account(Long id, Double money, AccountOwner owner, List<Transaction> transactions, LocalDateTime createdAt) {
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
}

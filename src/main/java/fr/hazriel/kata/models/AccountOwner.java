package fr.hazriel.kata.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AccountOwner {
    @Id
    private Long id;
    private String firstname;
    private String lastname;

    @OneToMany
    private List<Account> accounts;

    public AccountOwner(Long id, String firstname, String lastname, List<Account> accounts) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.accounts = accounts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

}

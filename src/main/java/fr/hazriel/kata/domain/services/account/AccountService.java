package fr.hazriel.kata.domain.services.account;

import fr.hazriel.kata.domain.models.Account;

public interface AccountService {
    public Account getAccountById(Long accountId);
}

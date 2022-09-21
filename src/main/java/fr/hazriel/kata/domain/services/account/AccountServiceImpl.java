package fr.hazriel.kata.domain.services.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.hazriel.kata.domain.models.Account;
import fr.hazriel.kata.persistence.repositories.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getAccountById(Long accountId) {
        return accountRepository.findById(accountId).orElseThrow();
    }
}

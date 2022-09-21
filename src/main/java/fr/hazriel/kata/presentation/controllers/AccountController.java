package fr.hazriel.kata.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.hazriel.kata.domain.services.account.AccountService;
import fr.hazriel.kata.presentation.dto.AccountDto;
import fr.hazriel.kata.presentation.dto.PresentationMapper;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/{accountId}")
    public AccountDto getAccountDetails(@PathVariable Long accountId) {
        return PresentationMapper.accountToPresentation(accountService.getAccountById(accountId));
    }
}

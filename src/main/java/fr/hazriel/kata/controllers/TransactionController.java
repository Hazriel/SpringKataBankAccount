package fr.hazriel.kata.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.hazriel.kata.dto.CreateTransactionRequestBody;
import fr.hazriel.kata.dto.PresentationMapper;
import fr.hazriel.kata.dto.TransactionDto;
import fr.hazriel.kata.exceptions.NotImplementedException;
import fr.hazriel.kata.services.TransactionService;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<TransactionDto> getTransactions(@RequestParam("accountId") Optional<Long> accountId)
            throws NotImplementedException {
        if (accountId.isEmpty()) {
            throw new NotImplementedException("Retrieving all transactions is currently not supported");
        }

        return transactionService.getTransactionsForAccount(accountId.get())
                .stream()
                .map(PresentationMapper::TransactionToPresentation)
                .collect(Collectors.toList());
    }

    @PostMapping("/")
    public void createTransaction(@RequestBody CreateTransactionRequestBody body) {
        transactionService.createTransaction(body.getAccountId(), body.getAmount());
    }
}

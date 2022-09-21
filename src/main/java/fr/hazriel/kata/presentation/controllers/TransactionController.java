package fr.hazriel.kata.presentation.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.hazriel.kata.domain.exceptions.NotImplementedException;
import fr.hazriel.kata.domain.services.transaction.TransactionService;
import fr.hazriel.kata.presentation.dto.CreateTransactionRequestBody;
import fr.hazriel.kata.presentation.dto.PresentationMapper;
import fr.hazriel.kata.presentation.dto.TransactionDto;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
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

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createTransaction(@RequestBody CreateTransactionRequestBody body) {
        transactionService.createTransaction(body.getAccountId(), body.getAmount());
    }
}

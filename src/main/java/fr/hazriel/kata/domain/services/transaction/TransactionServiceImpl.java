package fr.hazriel.kata.domain.services.transaction;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.hazriel.kata.domain.models.Account;
import fr.hazriel.kata.domain.models.Transaction;
import fr.hazriel.kata.persistence.repositories.AccountRepository;
import fr.hazriel.kata.persistence.repositories.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getTransactionsForAccount(Long accountId) {
        if (accountId == null) {
            throw new NullPointerException("Must have an account id");
        }

        accountRepository.findById(accountId).orElseThrow();

        return transactionRepository.findByAccountId(accountId);
    }

    public Transaction createTransaction(Long accountId, Double amount) {
        if (accountId == null || amount == null) {
            throw new NullPointerException("Must have an account id and a correct amount");
        }

        Account account = accountRepository.findById(accountId).orElseThrow();

        Transaction transaction = new Transaction(null, account, amount, LocalDateTime.now());

        transaction = transactionRepository.save(transaction);

        return transaction;
    }
}

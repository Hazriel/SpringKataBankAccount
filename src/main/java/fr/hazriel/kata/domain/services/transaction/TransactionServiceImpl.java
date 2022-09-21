package fr.hazriel.kata.domain.services.transaction;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.hazriel.kata.domain.exceptions.TransactionNotAllowedException;
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

    private static final Double ACCOUNT_AMOUNT_LOWER_BOUND = 0d;

    public List<Transaction> getTransactionsForAccount(Long accountId) {
        if (accountId == null) {
            throw new NullPointerException("Must have an account id");
        }

        accountRepository.findById(accountId).orElseThrow();

        return transactionRepository.findByAccountId(accountId);
    }

    @Transactional
    public Transaction createTransaction(Long accountId, Double amount) throws TransactionNotAllowedException {
        if (accountId == null || amount == null) {
            throw new NullPointerException("Must have an account id and a correct amount");
        }

        Account account = accountRepository.findById(accountId).orElseThrow();
        Transaction transaction = new Transaction(null, account, amount, LocalDateTime.now());

        if (hasNotEnoughMoney(account, transaction)) {
            throw new TransactionNotAllowedException("The incoming transaction is not allowed: not enough money on the account");
        }

        account = applyTransactionToAccount(account, transaction);

        accountRepository.save(account);
        transaction = transactionRepository.save(transaction);

        return transaction;
    }

    private boolean hasNotEnoughMoney(Account account, Transaction transaction) {
        return (account.getMoney() + transaction.getAmount()) < ACCOUNT_AMOUNT_LOWER_BOUND;
    }

    private Account applyTransactionToAccount(Account account, Transaction transaction) {
        account.setMoney(account.getMoney() + transaction.getAmount());
        return account;
    }
}

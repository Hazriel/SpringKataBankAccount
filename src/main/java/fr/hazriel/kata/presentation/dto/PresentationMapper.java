package fr.hazriel.kata.presentation.dto;

import java.util.List;
import java.util.stream.Collectors;

import fr.hazriel.kata.domain.models.Account;
import fr.hazriel.kata.domain.models.AccountOwner;
import fr.hazriel.kata.domain.models.Transaction;

public class PresentationMapper {
    public static TransactionDto TransactionToPresentation(Transaction transaction) {
        return new TransactionDto(transaction.getId(), transaction.getAccount().getId(), transaction.getAmount(), transaction.getTime());
    }

    public static AccountOwnerDto ownerToPresentation(AccountOwner accountOwner) {
        return new AccountOwnerDto(accountOwner.getId(), accountOwner.getFirstname(), accountOwner.getLastname());
    }

    public static AccountDto accountToPresentation(Account account) {
        List<TransactionDto> transactionsDto = account.getTransactions() == null
                ? List.of() 
                : account.getTransactions().stream()
                        .map(PresentationMapper::TransactionToPresentation)
                        .collect(Collectors.toList());

        AccountOwnerDto accountOwnerDto = account.getOwner() == null
                ? null
                : ownerToPresentation(account.getOwner());

        return new AccountDto(account.getId(),
                account.getMoney(),
                accountOwnerDto,
                transactionsDto,
                account.getCreatedAt());
    }
}

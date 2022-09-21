package fr.hazriel.kata.domain.exceptions;

public class TransactionNotAllowedException extends Exception {

    public TransactionNotAllowedException() {
    }

    public TransactionNotAllowedException(String message) {
        super(message);
    }
    
}

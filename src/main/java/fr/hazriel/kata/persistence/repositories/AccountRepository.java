package fr.hazriel.kata.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.hazriel.kata.domain.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    
}

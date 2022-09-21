package fr.hazriel.kata.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.hazriel.kata.domain.models.AccountOwner;

@Repository
public interface AccountOwnerRepository extends JpaRepository<AccountOwner, Long> {
    
}

package fr.hazriel.kata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.hazriel.kata.models.AccountOwner;

@Repository
public interface AccountOwnerRepository extends JpaRepository<AccountOwner, Long> {
    
}

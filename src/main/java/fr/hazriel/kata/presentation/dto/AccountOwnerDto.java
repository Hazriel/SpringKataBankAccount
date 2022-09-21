package fr.hazriel.kata.presentation.dto;

public class AccountOwnerDto {
    private Long id;
    private String firstname;
    private String lastname;

    public AccountOwnerDto(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}

package edu.msoft.clientmtls;

import java.time.LocalDate;

public class Customer {

    private Long id;
    private String name;
    private String lastname;
    private LocalDate birthDate;

    public Customer () {
    }

    public Customer (String name, String lastname, LocalDate birthDate) {
        this.name = name;
        this.lastname = lastname;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}

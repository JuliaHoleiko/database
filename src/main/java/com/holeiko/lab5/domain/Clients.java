package com.holeiko.lab5.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Clients {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "client_id")
    private Integer clientId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "clientsByOwnerClient")
    private Collection<Areas> areasByClientId;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients = (Clients) o;
        return Objects.equals(clientId, clients.clientId) && Objects.equals(name, clients.name) && Objects.equals(surname, clients.surname) && Objects.equals(phoneNumber, clients.phoneNumber) && Objects.equals(email, clients.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, name, surname, phoneNumber, email);
    }

    public Collection<Areas> getAreasByClientId() {
        return areasByClientId;
    }

    public void setAreasByClientId(Collection<Areas> areasByClientId) {
        this.areasByClientId = areasByClientId;
    }
}

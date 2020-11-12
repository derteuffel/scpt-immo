package com.derteuffel.scpt.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String type;
    private String email;
    private String contact;
    private String activite;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "contrats",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "locale_id"))
    private List<Locale> locales;

    public Client() {
    }

    public Client(String name, String type, String email, String contact, String activite) {
        this.name = name;
        this.type = type;
        this.email = email;
        this.contact = contact;
        this.activite = activite;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public List<Locale> getLocales() {
        return locales;
    }

    public void setLocales(List<Locale> locales) {
        this.locales = locales;
    }
}
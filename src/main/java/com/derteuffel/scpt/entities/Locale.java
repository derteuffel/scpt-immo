package com.derteuffel.scpt.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "locales")
public class Locale implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private int numLocale;
    private Double montant;
    private Boolean status;

    @ManyToOne
    private Representation representation;

    @ManyToMany
    private List<Client> clients;

    public Locale() {
    }

    public Locale(int numLocale, Double montant, Boolean status) {
        this.numLocale = numLocale;
        this.montant = montant;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumLocale() {
        return numLocale;
    }

    public void setNumLocale(int numLocale) {
        this.numLocale = numLocale;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Representation getRepresentation() {
        return representation;
    }

    public void setRepresentation(Representation representation) {
        this.representation = representation;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}

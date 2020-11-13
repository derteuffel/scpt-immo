package com.derteuffel.scpt.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "contrats")
public class Contrat implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private int dureeGaranti;
    private Boolean status;
    private Double montantGaranti;
    private String dateSignature;
    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;
    @ManyToOne
    @JoinColumn(name = "locale_id")
    @JsonIgnore
    private Locale locale;

    public Contrat() {
    }

    public Contrat(int dureeGaranti, Boolean status, Double montantGaranti, String dateSignature) {
        this.dureeGaranti = dureeGaranti;
        this.status = status;
        this.montantGaranti = montantGaranti;
        this.dateSignature = dateSignature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDureeGaranti() {
        return dureeGaranti;
    }

    public void setDureeGaranti(int dureeGaranti) {
        this.dureeGaranti = dureeGaranti;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getMontantGaranti() {
        return montantGaranti;
    }

    public void setMontantGaranti(Double montantGaranti) {
        this.montantGaranti = montantGaranti;
    }

    public String getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(String dateSignature) {
        this.dateSignature = dateSignature;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}

package com.derteuffel.scpt.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
}

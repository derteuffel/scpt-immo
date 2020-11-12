package com.derteuffel.scpt.helpers;

import com.derteuffel.scpt.entities.Client;
import com.derteuffel.scpt.entities.Locale;

public class ClientHelper {

    private String name;
    private String type;
    private String email;
    private String contact;
    private String activite;
    private int dureeGaranti;
    private Double montantGaranti;
    private String dateSignature;

    private Locale locale;

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

    public int getDureeGaranti() {
        return dureeGaranti;
    }

    public void setDureeGaranti(int dureeGaranti) {
        this.dureeGaranti = dureeGaranti;
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

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}

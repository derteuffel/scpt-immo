package com.derteuffel.scpt.helpers;

import com.derteuffel.scpt.entities.Representation;

public class LocaleHelper {

    private int numLocale;
    private Double montant;

    private Representation representation;

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

    public Representation getRepresentation() {
        return representation;
    }

    public void setRepresentation(Representation representation) {
        this.representation = representation;
    }
}

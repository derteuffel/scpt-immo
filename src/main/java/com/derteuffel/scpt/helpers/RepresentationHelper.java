package com.derteuffel.scpt.helpers;

import com.derteuffel.scpt.entities.Account;
import lombok.Data;

@Data
public class RepresentationHelper {

    private String province;
    private String ville;
    private String commune;
    private String avenue;
    private int numParcelle;

    private Account account;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getAvenue() {
        return avenue;
    }

    public void setAvenue(String avenue) {
        this.avenue = avenue;
    }

    public int getNumParcelle() {
        return numParcelle;
    }

    public void setNumParcelle(int numParcelle) {
        this.numParcelle = numParcelle;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

package com.derteuffel.scpt.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "representations")
public class Representation implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String province;
    private String ville;
    private String commune;
    private String avenue;
    private int numParcelle;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "representation_accounts",
            joinColumns = @JoinColumn(name = "representation_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id"))
    private List<Account> accounts;

    @OneToMany(mappedBy = "representation")
    private List<Locale> locales;

    public Representation() {
    }

    public Representation(String province, String ville, String commune, String avenue, int numParcelle) {
        this.province = province;
        this.ville = ville;
        this.commune = commune;
        this.avenue = avenue;
        this.numParcelle = numParcelle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Locale> getLocales() {
        return locales;
    }

    public void setLocales(List<Locale> locales) {
        this.locales = locales;
    }
}

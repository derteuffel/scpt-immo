package com.derteuffel.scpt.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "representations")
@OnDelete(action = OnDeleteAction.CASCADE)
public class Representation implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String province;
    private String ville;
    private String commune;
    private String avenue;
    private int numParcelle;


    @OneToMany(mappedBy = "representation")
    @JsonIgnore
    private Collection<AccountRepresentation> accountRepresentations;

    @OneToMany(mappedBy = "representation")
    @JsonIgnore
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

    public Collection<AccountRepresentation> getAccountRepresentations() {
        return accountRepresentations;
    }

    public void setAccountRepresentations(Collection<AccountRepresentation> accountRepresentations) {
        this.accountRepresentations = accountRepresentations;
    }

    public List<Locale> getLocales() {
        return locales;
    }

    public void setLocales(List<Locale> locales) {
        this.locales = locales;
    }
}

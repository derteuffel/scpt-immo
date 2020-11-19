package com.derteuffel.scpt.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "accounts_representations")
@OnDelete(action = OnDeleteAction.CASCADE)
public class AccountRepresentation  implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnoreProperties("accountRepresentations")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "representation_id")
    @JsonIgnoreProperties("accountRepresentations")
    private Representation representation;

    public AccountRepresentation() {
    }

    public AccountRepresentation(Account account, Representation representation) {
        this.account = account;
        this.representation = representation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Representation getRepresentation() {
        return representation;
    }

    public void setRepresentation(Representation representation) {
        this.representation = representation;
    }
}

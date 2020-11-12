package com.derteuffel.scpt.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(	name = "accounts",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "account_roles",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "account")
    private Collection<AccountRepresentation> accountRepresentations;

    @OneToOne(mappedBy = "account")
    private Profile profile;

    public Account() {
    }

    public Account(@NotBlank @Size(max = 20) String username,
                   @NotBlank @Size(max = 50) String email, @NotBlank @Size(max = 120) String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Collection<AccountRepresentation> getAccountRepresentations() {
        return accountRepresentations;
    }

    public void setAccountRepresentations(Collection<AccountRepresentation> accountRepresentations) {
        this.accountRepresentations = accountRepresentations;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

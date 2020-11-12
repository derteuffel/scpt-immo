package com.derteuffel.scpt.repositories;

import com.derteuffel.scpt.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    Collection<Client> findAllByType(String type);
    Collection<Client> findAllByActivite(String activite);
}

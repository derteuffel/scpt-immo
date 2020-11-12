package com.derteuffel.scpt.repositories;

import com.derteuffel.scpt.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ContratRepository extends JpaRepository<Contrat,Long> {

    Collection<Contrat> findAllByStatus(Boolean status);
    Collection<Contrat> findAllByClient_Id(Long id);
    Collection<Contrat> findAllByLocale_Id(Long id);
}

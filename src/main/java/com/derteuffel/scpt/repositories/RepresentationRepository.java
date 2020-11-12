package com.derteuffel.scpt.repositories;

import com.derteuffel.scpt.entities.Representation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface RepresentationRepository extends JpaRepository<Representation,Long> {

    Collection<Representation> findAllByAccounts_Id(Long id);
    Collection<Representation> findAllByProvince(String province);
    Collection<Representation> findAllByVille(String ville);
    Collection<Representation> findAllByCommune(String commune);
}

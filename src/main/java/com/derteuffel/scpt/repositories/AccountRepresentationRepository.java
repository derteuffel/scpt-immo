package com.derteuffel.scpt.repositories;

import com.derteuffel.scpt.entities.AccountRepresentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AccountRepresentationRepository extends JpaRepository<AccountRepresentation,Long>{

    Collection<AccountRepresentation> findAllByRepresentation_Id(Long id);
    Collection<AccountRepresentation> findAllByAccount_Id(Long id);
}

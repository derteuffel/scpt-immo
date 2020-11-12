package com.derteuffel.scpt.repositories;

import com.derteuffel.scpt.entities.Locale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface LocaleRepository extends JpaRepository<Locale,Long> {

    Collection<Locale> findAllByStatus(Boolean status);
    Collection<Locale> findAllByRepresentation_Id(Long id);

}

package com.derteuffel.scpt.services;

import com.derteuffel.scpt.entities.Contrat;
import com.derteuffel.scpt.helpers.ContratHelper;

import java.util.Collection;

public interface ContratService {

    Contrat getOne(Long id);
    Contrat saveContrat(ContratHelper contratHelper);
    void deleteContrat(Long id);
    Collection<Contrat> getContratByStatus(Boolean status);
    Collection<Contrat> getContratByClients(Long id);
    Collection<Contrat> getContratByLocale(Long id);
}

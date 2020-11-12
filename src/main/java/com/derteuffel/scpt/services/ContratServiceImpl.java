package com.derteuffel.scpt.services;

import com.derteuffel.scpt.entities.Contrat;
import com.derteuffel.scpt.helpers.ContratHelper;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ContratServiceImpl implements ContratService {
    @Override
    public Contrat getOne(Long id) {
        return null;
    }

    @Override
    public Contrat saveContrat(ContratHelper contratHelper) {
        return null;
    }

    @Override
    public void deleteContrat(Long id) {

    }

    @Override
    public Collection<Contrat> getContratByStatus(Boolean status) {
        return null;
    }
}

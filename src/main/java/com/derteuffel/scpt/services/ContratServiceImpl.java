package com.derteuffel.scpt.services;

import com.derteuffel.scpt.entities.Contrat;
import com.derteuffel.scpt.helpers.ContratHelper;
import com.derteuffel.scpt.repositories.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ContratServiceImpl implements ContratService {

    @Autowired
    private ContratRepository contratRepository;
    @Override
    public Contrat getOne(Long id) {
        return contratRepository.getOne(id);
    }

    @Override
    public Contrat save(Contrat contrat, Long id) {
        Contrat contrat1 = contratRepository.getOne(id);
        contrat1.setDateSignature(contrat.getDateSignature());
        contrat1.setDureeGaranti(contrat.getDureeGaranti());
        contrat1.setMontantGaranti(contrat.getDureeGaranti()*contrat1.getLocale().getMontant());
        return contratRepository.save(contrat1);
    }

    @Override
    public Contrat saveContrat(ContratHelper contratHelper) {
        return null;
    }

    @Override
    public Collection<Contrat> findAll() {
        return contratRepository.findAll();
    }

    @Override
    public void deleteContrat(Long id) {

        contratRepository.deleteById(id);
    }

    @Override
    public Collection<Contrat> getContratByStatus(Boolean status) {
        return contratRepository.findAllByStatus(status);
    }

    @Override
    public Collection<Contrat> getContratByClients(Long id) {
        return contratRepository.findAllByClient_Id(id);
    }

    @Override
    public Collection<Contrat> getContratByLocale(Long id) {
        return contratRepository.findAllByLocale_Id(id);
    }
}

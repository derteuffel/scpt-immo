package com.derteuffel.scpt.services;

import com.derteuffel.scpt.entities.Client;
import com.derteuffel.scpt.entities.Contrat;
import com.derteuffel.scpt.helpers.ClientHelper;
import com.derteuffel.scpt.repositories.ClientRepository;
import com.derteuffel.scpt.repositories.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ContratRepository contratRepository;

    @Override
    public Client getOne(Long id) {
        return null;
    }

    @Override
    public Client saveClient(ClientHelper clientHelper) {

        Client client = new Client();
        client.setActivite(clientHelper.getActivite());
        client.setContact(clientHelper.getContact());
        client.setEmail(clientHelper.getEmail());
        client.setName(clientHelper.getName());
        client.setType(clientHelper.getType());
        clientRepository.save(client);
        Contrat contrat = new Contrat();
        contrat.setClient(client);
        contrat.setLocale(clientHelper.getLocale());
        contrat.setDateSignature(clientHelper.getDateSignature());
        contrat.setDureeGaranti(clientHelper.getDureeGaranti());
        contrat.setMontantGaranti(clientHelper.getLocale().getMontant()*clientHelper.getDureeGaranti());
        contrat.setStatus(true);
        contratRepository.save(contrat);
        return client;
    }

    @Override
    public void deleteClient(Long id) {

    }

    @Override
    public Collection<Client> getClientsByType(String type) {
        return null;
    }

    @Override
    public Collection<Client> getClientByActivite(String activite) {
        return null;
    }

    @Override
    public Collection<Client> getClientByLocales(Long id) {
        return null;
    }
}

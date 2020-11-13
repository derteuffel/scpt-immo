package com.derteuffel.scpt.services;

import com.derteuffel.scpt.entities.Client;
import com.derteuffel.scpt.entities.Contrat;
import com.derteuffel.scpt.helpers.ClientHelper;
import com.derteuffel.scpt.repositories.ClientRepository;
import com.derteuffel.scpt.repositories.ContratRepository;
import com.derteuffel.scpt.repositories.LocaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ContratRepository contratRepository;

    @Autowired
    private LocaleRepository localeRepository;

    @Override
    public Client getOne(Long id) {
        return clientRepository.getOne(id);
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
        contrat.setLocale(localeRepository.getOne(clientHelper.getLocaleId()));
        contrat.setDateSignature(clientHelper.getDateSignature());
        contrat.setDureeGaranti(clientHelper.getDureeGaranti());
        contrat.setMontantGaranti(localeRepository.getOne(clientHelper.getLocaleId()).getMontant()*clientHelper.getDureeGaranti());
        contrat.setStatus(true);
        contratRepository.save(contrat);
        return client;
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Collection<Client> getClientsByType(String type) {

        Collection<Client> clients = clientRepository.findAllByType(type);
        return clients;
    }

    @Override
    public Collection<Client> getClientByActivite(String activite) {
        Collection<Client> clients = clientRepository.findAllByActivite(activite);
        return clients;
    }

    @Override
    public Collection<Client> getClientByLocales(Long id) {
        Collection<Contrat> contrats = contratRepository.findAllByLocale_Id(id);
        Collection<Client> clients = new ArrayList<>();
        for (Contrat contrat : contrats){
            if (contrat.getClient()!= null){
                clients.add(contrat.getClient());
            }
        }
        return clients;
    }
}

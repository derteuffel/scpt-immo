package com.derteuffel.scpt.services;

import com.derteuffel.scpt.entities.Client;
import com.derteuffel.scpt.helpers.ClientHelper;

import java.util.Collection;

public interface ClientService {

    Client getOne(Long id);
    Client saveClient(ClientHelper clientHelper);
    void deleteClient(Long id);

    Collection<Client> getClientsByType(String type);
    Collection<Client> getClients();
    Collection<Client> getClientByActivite(String activite);
    Collection<Client> getClientByLocales(Long id);
}

package com.derteuffel.scpt.services;

import com.derteuffel.scpt.entities.Client;
import com.derteuffel.scpt.helpers.ClientHelper;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClientServiceImpl implements ClientService {
    @Override
    public Client getOne(Long id) {
        return null;
    }

    @Override
    public Client saveClient(ClientHelper clientHelper) {
        return null;
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

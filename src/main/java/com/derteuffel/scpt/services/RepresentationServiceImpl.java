package com.derteuffel.scpt.services;

import com.derteuffel.scpt.entities.Account;
import com.derteuffel.scpt.entities.AccountRepresentation;
import com.derteuffel.scpt.entities.Representation;
import com.derteuffel.scpt.helpers.RepresentationHelper;
import com.derteuffel.scpt.repositories.AccountRepository;
import com.derteuffel.scpt.repositories.AccountRepresentationRepository;
import com.derteuffel.scpt.repositories.RepresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@Service
public class RepresentationServiceImpl implements RepresentationService {

    @Autowired
    private RepresentationRepository representationRepository;

    @Autowired
    private AccountRepresentationRepository accountRepresentationRepository;
    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Representation getOne(Long id) {

        Representation representation = representationRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Error: No representation found with provided id: "+id)
        );
        return representation;
    }

    @Override
    public Representation saveRepresentation(RepresentationHelper representationHelper) {
        Representation representation = new Representation();
        representation.setAvenue(representationHelper.getAvenue());
        representation.setCommune(representationHelper.getCommune());
        representation.setNumParcelle(representationHelper.getNumParcelle());
        representation.setProvince(representationHelper.getProvince());
        representation.setVille(representationHelper.getVille());
        representationRepository.save(representation);
        AccountRepresentation accountRepresentation = new AccountRepresentation(
                representationHelper.getAccount(),representation
        );
        accountRepresentationRepository.save(accountRepresentation);
        return representation;
    }

    @Override
    public void deleteRepresentation(Long id) {
        representationRepository.deleteById(id);
    }

    @Override
    public Collection<Representation> getRepresentationsByAccount(Long id) {
        Account account = accountRepository.getOne(id);
        Collection<AccountRepresentation> accountRepresentations = accountRepresentationRepository.findAllByAccount_Id(account.getId());
        Collection<Representation> representations = new ArrayList<>();
        for (AccountRepresentation accountRepresentation : accountRepresentations){
            if (accountRepresentation.getRepresentation()!=null) {
                representations.add(accountRepresentation.getRepresentation());
            }
        }
        return representations;
    }

    @Override
    public Collection<Representation> getRepresentationsByProvince(String province) {
        return representationRepository.findAllByProvince(province);
    }

    @Override
    public Collection<Representation> getRepresentationsbyVille(String ville) {
        return representationRepository.findAllByVille(ville);
    }

    @Override
    public Collection<Representation> getRepresentationsByCommune(String commune) {
        return representationRepository.findAllByCommune(commune);
    }

    @Override
    public Collection<Representation> getRepresentationsAll() {
        return representationRepository.findAll();
    }
}

package com.derteuffel.scpt.services;

import com.derteuffel.scpt.entities.Representation;
import com.derteuffel.scpt.helpers.RepresentationHelper;
import com.derteuffel.scpt.repositories.RepresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@Service
public class RepresentationServiceImpl implements RepresentationService {

    @Autowired
    private RepresentationRepository representationRepository;


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
        representation.setAccounts(Arrays.asList(representationHelper.getAccount()));
        representationRepository.save(representation);
        return representation;
    }

    @Override
    public void deleteRepresentation(Long id) {

    }

    @Override
    public Collection<Representation> getRepresentationsByAccount(Long id) {
        return representationRepository.findAllByAccounts_Id(id);
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

package com.derteuffel.scpt.services;

import com.derteuffel.scpt.entities.Contrat;
import com.derteuffel.scpt.entities.Locale;
import com.derteuffel.scpt.entities.Representation;
import com.derteuffel.scpt.helpers.LocaleHelper;
import com.derteuffel.scpt.repositories.ContratRepository;
import com.derteuffel.scpt.repositories.LocaleRepository;
import com.derteuffel.scpt.repositories.RepresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class LocaleServiceImpl implements LocaleService {

    @Autowired
    private LocaleRepository localeRepository;

    @Autowired
    private RepresentationRepository representationRepository;

    @Autowired
    private ContratRepository contratRepository;

    @Override
    public Locale getOne(Long id) {
        return localeRepository.getOne(id);
    }

    @Override
    public Locale saveLocale(LocaleHelper localeHelper) {

        Representation representation = representationRepository.getOne(localeHelper.getRepresentationId());

        Locale locale = new Locale(localeHelper.getNumLocale(),localeHelper.getMontant(),false,localeHelper.getSuperficie());
        locale.setRepresentation(representation);
        localeRepository.save(locale);
        return locale;
    }

    @Override
    public Locale save(Locale locale) {
        return localeRepository.save(locale);
    }

    @Override
    public Collection<Locale> findAll() {
        return localeRepository.findAll();
    }

    @Override
    public void deleteLocale(Long id) {
        localeRepository.deleteById(id);
    }



    @Override
    public Collection<Locale> getLocalesByStatus(Boolean status) {
        return localeRepository.findAllByStatus(status);
    }

    @Override
    public Collection<Locale> getLocalesByClients(Long id) {

        Collection<Contrat> contrats = contratRepository.findAllByClient_Id(id);
        Collection<Locale> locales = new ArrayList<>();
        for (Contrat contrat : contrats){
            if (contrat.getLocale()!= null){
                locales.add(contrat.getLocale());
            }
        }
        return locales;
    }

    @Override
    public Collection<Locale> getLocalesByRepresentation(Long id) {
        return localeRepository.findAllByRepresentation_Id(id);
    }
}

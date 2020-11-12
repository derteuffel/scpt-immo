package com.derteuffel.scpt.services;

import com.derteuffel.scpt.entities.Locale;
import com.derteuffel.scpt.helpers.LocaleHelper;
import com.derteuffel.scpt.repositories.LocaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LocaleServiceImpl implements LocaleService {

    @Autowired
    private LocaleRepository localeRepository;
    @Override
    public Locale getOne(Long id) {
        return null;
    }

    @Override
    public Locale saveLocale(LocaleHelper localeHelper) {

        Locale locale = new Locale(localeHelper.getNumLocale(),localeHelper.getMontant(),false);
        locale.setRepresentation(localeHelper.getRepresentation());
        localeRepository.save(locale);
        return locale;
    }

    @Override
    public void deleteLocale(Long id) {

    }

    @Override
    public Collection<Locale> getLocalesByStatus(Boolean status) {
        return null;
    }

    @Override
    public Collection<Locale> getLocalesByClients(Long id) {
        return null;
    }

    @Override
    public Collection<Locale> getLocalesByRepresentation(Long id) {
        return null;
    }
}

package com.derteuffel.scpt.services;

import com.derteuffel.scpt.entities.Locale;
import com.derteuffel.scpt.helpers.LocaleHelper;

import java.util.Collection;

public interface LocaleService {

    Locale getOne(Long id);
    Locale saveLocale(LocaleHelper localeHelper);
    void deleteLocale(Long id);
    Collection<Locale> getLocalesByStatus(Boolean status);
    Collection<Locale> getLocalesByClients(Long id);
    Collection<Locale> getLocalesByRepresentation(Long id);
}

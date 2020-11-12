package com.derteuffel.scpt.services;

import com.derteuffel.scpt.entities.Representation;
import com.derteuffel.scpt.helpers.RepresentationHelper;

import java.util.Collection;

public interface RepresentationService {

    Representation getOne(Long id);
    Representation saveRepresentation(RepresentationHelper representationHelper);
    void deleteRepresentation(Long id);
    Collection<Representation> getRepresentationsByAccount(Long id);
    Collection<Representation> getRepresentationsByProvince(String province);
    Collection<Representation> getRepresentationsbyVille(String ville);
    Collection<Representation> getRepresentationsByCommune(String commune);
    Collection<Representation> getRepresentationsAll();
}

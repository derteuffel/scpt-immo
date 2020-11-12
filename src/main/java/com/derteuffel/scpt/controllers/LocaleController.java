package com.derteuffel.scpt.controllers;

import com.derteuffel.scpt.entities.Locale;
import com.derteuffel.scpt.entities.Representation;
import com.derteuffel.scpt.helpers.LocaleHelper;
import com.derteuffel.scpt.helpers.responses.MessageResponse;
import com.derteuffel.scpt.repositories.RepresentationRepository;
import com.derteuffel.scpt.services.LocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/locale")
public class LocaleController {

    @Autowired
    private LocaleService localeService;

    @Autowired
    private RepresentationRepository representationRepository;

    @PostMapping("/save")
    @PreAuthorize("hasRole('ROOT') or hasRole('ADMIN')")
    public ResponseEntity<?> saveLocale(@RequestBody LocaleHelper localeHelper, @PathVariable Long id){
        Representation representation = representationRepository.getOne(id);
        localeHelper.setRepresentation(representation);
        localeService.saveLocale(localeHelper);
        return ResponseEntity.ok(new MessageResponse("Locale added successfuly"));
    }

    @GetMapping("/representation/{id}")
    public ResponseEntity<Collection<Locale>> getLocalesBRepresentation(@PathVariable Long id){
        Collection<Locale> locales = localeService.getLocalesByRepresentation(id);
        return new ResponseEntity<>(locales, HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Collection<Locale>> getLocalesByClients(@PathVariable Long id){
        Collection<Locale> locales = localeService.getLocalesByClients(id);
        return new ResponseEntity<>(locales,HttpStatus.OK);
    }


}

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

    @PostMapping("/save/{id}")
    //@PreAuthorize("hasRole('ROOT') or hasRole('ADMIN')")
    public ResponseEntity<?> saveLocale(@RequestBody LocaleHelper localeHelper, @PathVariable Long id){
        Representation representation = representationRepository.getOne(id);
        localeHelper.setRepresentationId(representation.getId());
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

    @GetMapping("/status/{status}")
    public ResponseEntity<Collection<Locale>> getLocalesByStatus(@PathVariable Boolean status){
        Collection<Locale> locales = localeService.getLocalesByStatus(status);
        return new ResponseEntity<>(locales,HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Collection<Locale>> getLocales(){
        Collection<Locale> locales = localeService.findAll();
        return new ResponseEntity<>(locales,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locale> getLocale(@PathVariable Long id){
        Locale locale = localeService.getOne(id);
        return new ResponseEntity<>(locale,HttpStatus.OK);
    }


    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteLocale(@PathVariable Long id){
        localeService.deleteLocale(id);
        return ResponseEntity.ok(new MessageResponse("You deleted a locale successfuly"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLocale(@PathVariable Long id, @RequestBody Locale locale){
        Locale locale1 = localeService.getOne(id);
        locale1.setMontant(locale.getMontant());
        locale1.setNumLocale(locale.getNumLocale());
        locale1.setSuperficie(locale.getSuperficie());
        localeService.save(locale1);

        return ResponseEntity.ok(new MessageResponse("You updated successfuly your Locale"));
    }




}

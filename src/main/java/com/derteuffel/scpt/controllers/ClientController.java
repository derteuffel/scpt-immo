package com.derteuffel.scpt.controllers;

import com.derteuffel.scpt.entities.Locale;
import com.derteuffel.scpt.helpers.ClientHelper;
import com.derteuffel.scpt.helpers.responses.MessageResponse;
import com.derteuffel.scpt.repositories.ContratRepository;
import com.derteuffel.scpt.services.ClientService;
import com.derteuffel.scpt.services.ContratService;
import com.derteuffel.scpt.services.LocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ContratRepository contratRepository;

    @Autowired
    private LocaleService localeService;

    @PostMapping("/save/{id}")
    public ResponseEntity<?> saveClient(@RequestBody ClientHelper clientHelper, @PathVariable Long id){
        Locale locale = localeService.getOne(id);
        clientHelper.setLocale(locale);
        clientService.saveClient(clientHelper);
        return ResponseEntity.ok(new MessageResponse("Your client are saved successfuly"));
    }
}

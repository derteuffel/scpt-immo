package com.derteuffel.scpt.controllers;

import com.derteuffel.scpt.entities.Client;
import com.derteuffel.scpt.entities.Locale;
import com.derteuffel.scpt.helpers.ClientHelper;
import com.derteuffel.scpt.helpers.responses.MessageResponse;
import com.derteuffel.scpt.repositories.ContratRepository;
import com.derteuffel.scpt.services.ClientService;
import com.derteuffel.scpt.services.ContratService;
import com.derteuffel.scpt.services.LocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Collection;

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
        clientHelper.setLocaleId(locale.getId());
        clientService.saveClient(clientHelper);
        return ResponseEntity.ok(new MessageResponse("Your client are saved successfuly"));
    }


    @GetMapping("/type/{type}")
    public ResponseEntity<Collection<Client>> getClientByType(@PathVariable String type){
        Collection<Client> clients = clientService.getClientsByType(type);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/locale/{id}")
    public ResponseEntity<Collection<Client>> getClientByLocale(@PathVariable Long id){
        Collection<Client> clients = clientService.getClientByLocales(id);
        return new ResponseEntity<>(clients,HttpStatus.OK);
    }

    @GetMapping("/activite/{activite}")
    public ResponseEntity<Collection<Client>> getClientByActivite(@PathVariable String activite){
        Collection<Client> clients = clientService.getClientByActivite(activite);
        return new ResponseEntity<>(clients,HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id){
        Client client = clientService.getOne(id);
        return new ResponseEntity<>(client,HttpStatus.OK);
    }


    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return ResponseEntity.ok(new MessageResponse("You've deleted the client successfuly"));
    }
}

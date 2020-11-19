package com.derteuffel.scpt.controllers;

import com.derteuffel.scpt.entities.Contrat;
import com.derteuffel.scpt.helpers.responses.MessageResponse;
import com.derteuffel.scpt.services.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/contrat")
public class ContratController {

    @Autowired
    private ContratService contratService;

    @PutMapping("/{id}")
    public ResponseEntity<?> updateContrat(@RequestBody Contrat contrat, @PathVariable Long id){
        contratService.save(contrat, id);
        return ResponseEntity.ok(new MessageResponse("Votre contrat a ete enregistrer avec succes"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrat> getContrat(@PathVariable Long id){
        Contrat contrat = contratService.getOne(id);
        return new ResponseEntity<>(contrat,HttpStatus.OK);
    }


    @GetMapping("/locale/{id}")
    public ResponseEntity<Collection<Contrat>> getAllByLocale(@PathVariable Long id){
        Collection<Contrat> contrats = contratService.getContratByLocale(id);
        return new ResponseEntity<>(contrats, HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Collection<Contrat>> getAllByClient(@PathVariable Long id){
        Collection<Contrat> contrats = contratService.getContratByClients(id);
        return new ResponseEntity<>(contrats, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Collection<Contrat>> getAll(){
        Collection<Contrat> contrats = contratService.findAll();
        return new ResponseEntity<>(contrats,HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<Collection<Contrat>> getAllByStatus(@PathVariable Boolean status){
        Collection<Contrat> contrats = contratService.getContratByStatus(status);
        return new ResponseEntity<>(contrats, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContrat(@PathVariable Long id){
        contratService.deleteContrat(id);
        return ResponseEntity.ok(new MessageResponse("vous avez supprimer avec succes ce contrat"));
    }
}

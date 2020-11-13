package com.derteuffel.scpt.controllers;

import com.derteuffel.scpt.entities.Account;
import com.derteuffel.scpt.entities.Representation;
import com.derteuffel.scpt.entities.Role;
import com.derteuffel.scpt.enums.ERole;
import com.derteuffel.scpt.helpers.RepresentationHelper;
import com.derteuffel.scpt.helpers.responses.MessageResponse;
import com.derteuffel.scpt.repositories.AccountRepository;
import com.derteuffel.scpt.repositories.RoleRepository;
import com.derteuffel.scpt.services.RepresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.Option;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/representation")
public class RepresentationController {

    @Autowired
    private RepresentationService representationService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;


    @PostMapping("")
    //@PreAuthorize("hasRole('ROOT') or hasRole('ADMIN')")
    public ResponseEntity<?> save(@RequestBody RepresentationHelper representationHelper, HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        System.out.println(representationHelper.getCommune());
        Optional<Account> account = accountRepository.findByUsername(principal.getName());
        representationHelper.setAccount(account.orElseThrow(()-> new RuntimeException("Error: Account is not found.")));
        representationService.saveRepresentation(representationHelper);
        return  ResponseEntity.ok(new MessageResponse("Representation saved successfuly"));
    }

    @PostMapping("/{id}")
    //@PreAuthorize("hasRole('ROOT') or hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestBody RepresentationHelper representationHelper, @PathVariable Long id){
        System.out.println(representationHelper.getCommune());
        representationService.updateRepresentation(representationHelper, id);
        return  ResponseEntity.ok(new MessageResponse("Representation updated successfuly"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Representation> getOne(@PathVariable Long id){
        Representation representation = representationService.getOne(id);
        return new ResponseEntity<>(representation, HttpStatus.OK);
    }


    @GetMapping("")
    public ResponseEntity<Collection<Representation>> getAllRepresentations(HttpServletRequest request){
        /*Principal principal = request.getUserPrincipal();
        Account account = accountRepository.findByUsername(principal.getName()).orElseThrow(
                ()-> new RuntimeException("Error: Account is not found")
        );
        Role role = roleRepository.findByName(ERole.ROLE_ROOT).orElseThrow(
                ()-> new RuntimeException("Error: Role is not found")
        );*/

        Collection<Representation> representations = representationService.getRepresentationsAll();

       /* if (account.getRoles().contains(role)){
            representations.addAll(representationService.getRepresentationsAll());
        }else {
            representations.addAll(representationService.getRepresentationsByAccount(account.getId()));
        }*/



        return new ResponseEntity<>(representations,HttpStatus.OK);
    }


    @GetMapping("/province/{province}")
    //@PreAuthorize("hasRole('ROOT') or hasRole('ADMIN')")
    public  ResponseEntity<Collection<Representation>> getRepresentationsByProvince(@PathVariable String province){
        Collection<Representation> representations = representationService.getRepresentationsByProvince(province);
        return new ResponseEntity<>(representations,HttpStatus.OK);
    }

    @GetMapping("/commune/{commune}")
    //@PreAuthorize("hasRole('ROOT')")
    public  ResponseEntity<Collection<Representation>> getRepresentationsByCommune(@PathVariable String commune){
        Collection<Representation> representations = representationService.getRepresentationsByCommune(commune);
        return new ResponseEntity<>(representations,HttpStatus.OK);
    }

    @GetMapping("/ville/{ville}")
    //@PreAuthorize("hasRole('ROOT')")
    public  ResponseEntity<Collection<Representation>> getRepresentationsByVille(@PathVariable String ville){
        Collection<Representation> representations = representationService.getRepresentationsbyVille(ville);
        return new ResponseEntity<>(representations,HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteRepresentation(@PathVariable Long id){
        Representation representation = representationService.getOne(id);
        representationService.deleteRepresentation(representation.getId());
        return ResponseEntity.ok(new MessageResponse("Representation deleted successfuly"));
    }
}

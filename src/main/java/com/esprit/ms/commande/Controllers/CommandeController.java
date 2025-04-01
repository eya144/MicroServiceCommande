package com.esprit.ms.commande.Controllers;

import com.esprit.ms.commande.Entities.Commande;
import com.esprit.ms.commande.Services.InterfaceCommande;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Commande")
@AllArgsConstructor
public class CommandeController {
    @Autowired
    InterfaceCommande icommande;

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Commande>addCommande(@RequestBody Commande commande) {

        return new ResponseEntity<>(icommande.addCommande(commande),HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity<List<Commande>> getAll(){

        return new ResponseEntity<>(icommande.getAllCommande(),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public void deleteCommande(@PathVariable Long id) {

        icommande.deleteCommande(id);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Commande> updateCommande(@PathVariable(value = "id") Long id, @RequestBody Commande commande)
    {

        return new ResponseEntity<>(icommande.updateCommande(id, commande),HttpStatus.OK);
    }




}

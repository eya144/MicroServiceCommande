package com.esprit.ms.commande.Services;

import com.esprit.ms.commande.Entities.Commande;

import java.util.List;

public interface InterfaceCommande {
    List<Commande> getAllCommande();
    Commande addCommande(Commande commande );
    void deleteCommande(Long id);
    Commande updateCommande(Long id , Commande commande );
    Commande getCommandeById(Long id);
}

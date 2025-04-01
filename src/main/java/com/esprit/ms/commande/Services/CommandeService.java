package com.esprit.ms.commande.Services;

import com.esprit.ms.commande.Entities.Commande;
import com.esprit.ms.commande.Repositories.CommandeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CommandeService implements InterfaceCommande {
 @Autowired
    CommandeRepository commandeRepository;
    @Override
    public List<Commande> getAllCommande() {

        return (List<Commande>) commandeRepository.findAll();
    }
    @Override
    public Commande addCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public void deleteCommande(Long id) {

        commandeRepository.deleteById(id);
    }
    @Override
    public Commande updateCommande(Long id,Commande commande) {
        if (commandeRepository.findById(id).isPresent()) {
           Commande  existingCommande =commandeRepository.findById(id).get();
            existingCommande.setStatut(commande.getStatut());
            existingCommande.setDateCommande(commande.getDateCommande());
            existingCommande.setDateLivraisonEstimee(commande.getDateLivraisonEstimee());
            existingCommande.setNotes(commande.getNotes());
            existingCommande.setRemise(commande.getRemise());
            existingCommande.setTotal(commande.getTotal());

            return commandeRepository.save(commande);

        }
        else return null;
    }
    @Override
    public Commande getCommandeById(Long id) {

        return commandeRepository.findById(id).orElse(null);
    }
}

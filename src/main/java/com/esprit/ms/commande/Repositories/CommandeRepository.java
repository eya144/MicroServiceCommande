package com.esprit.ms.commande.Repositories;

import com.esprit.ms.commande.Entities.Commande;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends CrudRepository<Commande, Long> {

}

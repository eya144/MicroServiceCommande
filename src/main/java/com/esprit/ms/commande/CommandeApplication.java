package com.esprit.ms.commande;

import com.esprit.ms.commande.Entities.Commande;
import com.esprit.ms.commande.Entities.StatutCommande;
import com.esprit.ms.commande.Repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableDiscoveryClient
public class CommandeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandeApplication.class, args);
    }
    @Autowired
    CommandeRepository commandeRepository;
    @Bean
    ApplicationRunner init() {
        return args -> {
            // Ajout de plusieurs commandes avec des valeurs de test
            commandeRepository.save(new Commande(StatutCommande.Preparation, LocalDateTime.now(), new BigDecimal("120.00"), new BigDecimal("10.00"), LocalDate.now().plusDays(5), "Commande test 1"));
            commandeRepository.save(new Commande(StatutCommande.EnCours, LocalDateTime.now(), new BigDecimal("250.50"), new BigDecimal("20.00"), LocalDate.now().plusDays(3), "Commande test 2"));
            commandeRepository.save(new Commande(StatutCommande.Livré, LocalDateTime.now(), new BigDecimal("75.25"), new BigDecimal("5.00"), LocalDate.now().plusDays(2), "Commande test 3"));

            // Affichage des commandes en base
            System.out.println("Commandes enregistrées :");
            commandeRepository.findAll().forEach(System.out::println);
        };
    }
}

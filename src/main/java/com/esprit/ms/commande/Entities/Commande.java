package com.esprit.ms.commande.Entities;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatutCommande statut;
    private LocalDateTime dateCommande;
    private BigDecimal total;
    private BigDecimal remise;
    private LocalDate dateLivraisonEstimee;
    private String notes;
    public Commande() {
        // Default constructor needed by Hibernate
    }
    public Commande( StatutCommande statut, LocalDateTime dateCommande, BigDecimal total, BigDecimal remise, LocalDate dateLivraisonEstimee, String notes) {

        this.statut = statut;
        this.dateCommande = dateCommande;
        this.total = total;
        this.remise = remise;
        this.dateLivraisonEstimee = dateLivraisonEstimee;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatutCommande getStatut() {
        return statut;
    }

    public void setStatut(StatutCommande statut) {
        this.statut = statut;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getRemise() {
        return remise;
    }

    public void setRemise(BigDecimal remise) {
        this.remise = remise;
    }

    public LocalDate getDateLivraisonEstimee() {
        return dateLivraisonEstimee;
    }

    public void setDateLivraisonEstimee(LocalDate dateLivraisonEstimee) {
        this.dateLivraisonEstimee = dateLivraisonEstimee;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}


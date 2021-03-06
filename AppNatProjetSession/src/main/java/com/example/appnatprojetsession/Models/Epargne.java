package com.example.appnatprojetsession.Models;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 16 decembre 2021
 * @author: A. Alperen, B. Shajaan et I. Gafran
 */
public class Epargne extends Compte {
    private double tauxInteret = 1.01;

    public Epargne(int numeroNIP, int codeClient) {
        super(numeroNIP, codeClient);
    }

    public Epargne() {
    }

    public Epargne(int numeroNIP, int codeClient, double soldeCompte, int retraitMaximum, int montantTransfertMaximum, double tauxInteret) {
        super(numeroNIP, codeClient, soldeCompte, retraitMaximum, montantTransfertMaximum);
        this.tauxInteret = tauxInteret;
    }
    
    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public double paiementInteret(double solde) {
        solde = solde * this.tauxInteret;
        this.setSoldeCompte(solde);
        return solde;
    }

    @Override
    public String toString() {
        return "Epargne{" +
                "tauxInteret=" + tauxInteret +
                '}';
    }
}

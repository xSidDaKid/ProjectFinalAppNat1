package com.example.appnatprojetsession.Models;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 28 septembre 2021
 * @author: Shajaan Balasingam
 * @DA: 1723144
 */
public class Cheque extends Compte {
    private double fraisPaiementFacture = 0;
    private double montantFactureMaximum = 0;

    public Cheque(int numeroNIP, int codeClient) {
        super(numeroNIP, codeClient);
    }

    public double getFraisPaiementFacture() {
        return fraisPaiementFacture;
    }

    public void setFraisPaiementFacture(double fraisPaiementFacture) {
        this.fraisPaiementFacture = fraisPaiementFacture;
    }

    public double getMontantFactureMaximum() {
        return montantFactureMaximum;
    }

    public void setMontantFactureMaximum(double montantFactureMaximum) {
        this.montantFactureMaximum = montantFactureMaximum;
    }

    public void paiementFacture(double montant) {

    }

    @Override
    public String toString() {
        return "Cheque{" +
                "fraisPaiementFacture=" + fraisPaiementFacture +
                ", montantFactureMaximum=" + montantFactureMaximum +
                '}';
    }
}

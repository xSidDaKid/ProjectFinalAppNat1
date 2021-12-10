package com.example.appnatprojetsession.Models;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 16 decembre 2021
 * @author: A. Alperen, B. Shajaan et I. Gafran
 */
public class Compte {
    private  int numeroCompte;
    private int numeroNIP;
    private double soldeCompte;
    private int retraitMaximum;
    private int montantTransfertMaximum;

    public Compte() {
    }

    public Compte(int numeroNIP, int numeroCompte) {
        this.numeroNIP = numeroNIP;
        this.numeroCompte = numeroCompte;
        this.soldeCompte=0;
        //A changer les valeurs selon les notes
        this.retraitMaximum = 1000;
        this.montantTransfertMaximum 500;
    }

    public Compte(int numeroNIP, int numeroCompte, double soldeCompte, int retraitMaximum, int montantTransfertMaximum) {
        this.numeroNIP = numeroNIP;
        this.numeroCompte = numeroCompte;
        this.soldeCompte = soldeCompte;
        this.retraitMaximum = retraitMaximum;
        this.montantTransfertMaximum = montantTransfertMaximum;
    }

    public int getNumeroNIP() {
        return numeroNIP;
    }

    public void setNumeroNIP(int numeroNIP) {
        this.numeroNIP = numeroNIP;
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getSoldeCompte() {
        return soldeCompte;
    }

    public void setSoldeCompte(double soldeCompte) {
        this.soldeCompte = soldeCompte;
    }

    public void retrait (double montant){

    }

    public void depot (double montant){

    }

    @Override
    public String toString() {
        return "Compte{" +
                "numeroNIP=" + numeroNIP +
                ", numeroCompte=" + numeroCompte +
                ", soldeCompte=" + soldeCompte +
                ", retraitMaximum=" + retraitMaximum +
                ", montantTransfertMaximum=" + montantTransfertMaximum +
                '}';
    }
}

package com.example.appnatprojetsession.Models;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 16 decembre 2021
 * @author: A. Alperen, B. Shajaan et I. Gafran
 */
public class Compte {
    private static int compteur = 0;
    private int numeroCompte;
    private int codeClient;
    private int numeroNIP;
    private double soldeCompte;
    private int retraitMaximum;
    private int montantTransfertMaximum;

    public Compte() {
    }

    public Compte(int numeroNIP, int codeClient) {
        this.incrementCompteur();
        this.numeroCompte = compteur;
        this.numeroNIP = numeroNIP;
        this.codeClient = codeClient;
        this.soldeCompte = soldeCompte;
        //A changer les valeurs selon les notes
        this.retraitMaximum = 1000;
        //this.montantTransfertMaximum 500;
    }

    public Compte(int numeroNIP, int codeClient, double soldeCompte, int retraitMaximum, int montantTransfertMaximum) {
        this.incrementCompteur();
        this.numeroCompte = compteur;
        this.numeroNIP = numeroNIP;
        this.codeClient = codeClient;
        this.soldeCompte = soldeCompte;
        this.retraitMaximum = retraitMaximum;
        this.montantTransfertMaximum = montantTransfertMaximum;
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public int getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(int codeClient) {
        this.codeClient = codeClient;
    }

    public int getNumeroNIP() {
        return numeroNIP;
    }

    public void setNumeroNIP(int numeroNIP) {
        this.numeroNIP = numeroNIP;
    }

    public double getSoldeCompte() {
        return soldeCompte;
    }

    public void setSoldeCompte(double soldeCompte) {
        this.soldeCompte = soldeCompte;
    }

    public int getRetraitMaximum() {
        return retraitMaximum;
    }

    public void setRetraitMaximum(int retraitMaximum) {
        this.retraitMaximum = retraitMaximum;
    }

    public int getMontantTransfertMaximum() {
        return montantTransfertMaximum;
    }

    public void setMontantTransfertMaximum(int montantTransfertMaximum) {
        this.montantTransfertMaximum = montantTransfertMaximum;
    }

    public void depot(double montant) {

    }

    public void incrementCompteur() {
        this.compteur += 1;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "numeroCompte=" + numeroCompte +
                ", codeClient=" + codeClient +
                ", numeroNIP=" + numeroNIP +
                ", soldeCompte=" + soldeCompte +
                ", retraitMaximum=" + retraitMaximum +
                ", montantTransfertMaximum=" + montantTransfertMaximum +
                '}';
    }
}

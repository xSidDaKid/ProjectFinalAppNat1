package com.example.appnatprojetsession.Models;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 16 decembre 2021
 * @author: A. Alperen, B. Shajaan et I. Gafran
 */
public class Transaction {
    private static int numeroTransactionCompteur = 0;
    public String type;
    private int numeroTransaction;
    private double montant;
    private Compte compte;
    private Compte compteTransfert;

    public Transaction(double montant, Compte compte, Compte compteTransfert, String type) {
        this.incrementCompteur();
        this.numeroTransaction = numeroTransactionCompteur;
        this.compte = compte;
        this.compteTransfert = compteTransfert;
        this.type = type;
        this.montant=montant;
    }

    public Transaction(double montant, Compte compte, String type) {
        this.incrementCompteur();
        this.numeroTransaction = numeroTransactionCompteur;
        this.compte = compte;
        this.type = type;
        this.montant=montant;
    }

    public static void incrementCompteur() {
        numeroTransactionCompteur += 1;
    }

    public int getNumeroTransaction() {
        return numeroTransaction;
    }

    public void setNumeroTransaction(int numeroTransaction) {
        this.numeroTransaction = numeroTransaction;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Compte getCompteTransfert() {
        return compteTransfert;
    }

    public void setCompteTransfert(Compte compteTransfert) {
        this.compteTransfert = compteTransfert;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "numeroTransaction=" + numeroTransaction +
                ", montant=" + montant +
                ", compte=" + compte +
                ", compteTransfert=" + compteTransfert +
                ", Type='" + type + '\'' +
                '}';
    }
}

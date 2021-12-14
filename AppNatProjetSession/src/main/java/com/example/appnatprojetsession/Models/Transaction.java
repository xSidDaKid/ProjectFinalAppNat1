package com.example.appnatprojetsession.Models;

import com.example.appnatprojetsession.Models.Compte;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 16 decembre 2021
 * @author: A. Alperen, B. Shajaan et I. Gafran
 */
public class Transaction {
    private int numeroTransaction;
    private double montant;
    private Compte compte;
    private Compte compteTransfert;
    public String type;
    private static int numeroTransactionCompteur=0;

    public Transaction(double montant, Compte compte, Compte compteTransfert, String type){
        this.incrementCompteur();
        this.numeroTransaction = numeroTransaction;
        this.compte = compte;
        this.compteTransfert = compteTransfert;
        this.type = type;
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

    public static void incrementCompteur(){
        numeroTransactionCompteur=+1;
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

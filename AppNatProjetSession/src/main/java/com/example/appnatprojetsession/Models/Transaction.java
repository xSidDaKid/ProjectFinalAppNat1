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
    private String Type;

    @Override
    public String toString() {
        return "Transaction{" +
                "numeroTransaction=" + numeroTransaction +
                ", montant=" + montant +
                ", compte=" + compte +
                ", compteTransfert=" + compteTransfert +
                ", Type='" + Type + '\'' +
                '}';
    }
}

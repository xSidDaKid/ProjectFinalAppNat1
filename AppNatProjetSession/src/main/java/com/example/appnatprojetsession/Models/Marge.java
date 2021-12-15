package com.example.appnatprojetsession.Models;

import com.example.appnatprojetsession.Models.Compte;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 16 decembre 2021
 * @author: A. Alperen, B. Shajaan et I. Gafran
 */
public class Marge extends Compte {

    private double tauxInteret = 1.05;



    public Marge(int numeroNIP, int codeClient){
        super( numeroNIP, codeClient);
    }

    public Marge( int numeroNIP, int codeClient, double tauxInteret){
        super(numeroNIP, codeClient);
        this.tauxInteret = tauxInteret;
    }
    public Marge() {
    }

    public void augmenterSoldeMarge(){
        double solde = this.getSoldeCompte() * this.tauxInteret;
        this.setSoldeCompte(solde);
    }

    @Override
    public String toString() {
        return "Marge{" +
                "tauxInteret=" + tauxInteret +
                '}';
    }
}

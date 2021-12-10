package com.example.appnatprojetsession.Models;

import com.example.appnatprojetsession.Models.Compte;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 16 decembre 2021
 * @author: A. Alperen, B. Shajaan et I. Gafran
 */
public class Marge extends Compte {

    private final double tauxInteret = 1.01;

    public Marge(int numeroNIP, int numeroCompte){
        super(numeroNIP, numeroCompte);
       // this.tauxInteret = 1.01;
    }

    public Marge(int numeroNIP, int numeroCompte, double tauxInteret){
        super(numeroNIP, numeroCompte);
       // this.tauxInteret = tauxInteret;
    }

    public void augmenterSoldeMarge(){

    }

    @Override
    public String toString() {
        return "Marge{" +
                "tauxInteret=" + tauxInteret +
                '}';
    }
}

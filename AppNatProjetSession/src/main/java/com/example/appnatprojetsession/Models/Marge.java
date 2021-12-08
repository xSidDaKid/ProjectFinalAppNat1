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

    public void augmenterSoldeMarge(){

    }

    @Override
    public String toString() {
        return "Marge{" +
                "tauxInteret=" + tauxInteret +
                '}';
    }
}

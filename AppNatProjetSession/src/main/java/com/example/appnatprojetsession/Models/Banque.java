package com.example.appnatprojetsession.Models;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 16 decembre 2021
 * @author: A. Alperen, B. Shajaan et I. Gafran
 */
public class Banque extends Compte{
    private final double montantMaximum = 0;
    private final double montantRemplissage = 0;

    public void RemplirGuichet(){

    }

    @Override
    public String toString() {
        return "Banque{" +
                "montantMaximum=" + montantMaximum +
                ", montantRemplissage=" + montantRemplissage +
                '}';
    }
}

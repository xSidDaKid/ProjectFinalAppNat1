package com.example.appnatprojetsession.Models;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 16 decembre 2021
 * @author: A. Alperen, B. Shajaan et I. Gafran
 */
public class Hypothécaire extends Compte {

    public Hypothécaire(int numeroNIP, int codeClient) {
        super(numeroNIP, codeClient);
    }

    public void preleverMontantHypotheque() {

    }

    @Override
    public String toString() {
        return "Hypothécaire{}";
    }
}

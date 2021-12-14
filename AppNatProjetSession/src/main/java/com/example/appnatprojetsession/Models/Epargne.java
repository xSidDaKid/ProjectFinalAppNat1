package com.example.appnatprojetsession.Models;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 16 decembre 2021
 * @author: A. Alperen, B. Shajaan et I. Gafran
 */
public class Epargne extends Compte{
    private double tauxInteret = 1.01;

    public Epargne (int numeroNIP, int codeClient){
        super(numeroNIP, codeClient);
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    /*    public void paiementInteret(int numeroNIP, int numeroCompte){
        super(numeroNIP, numeroCompte);
        this.tauxInteret = 1.01;
    }

    public void paiementInteret(int numeroNIP, int numeroCompte, double tauxInteret){
        super(numeroNIP, numeroCompte);
        this.tauxInteret = tauxInteret;
    }*/

    @Override
    public String toString() {
        return "Epargne{" +
                "tauxInteret=" + tauxInteret +
                '}';
    }
}

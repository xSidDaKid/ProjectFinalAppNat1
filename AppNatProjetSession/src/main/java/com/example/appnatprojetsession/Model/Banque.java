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

    public Banque(public Marge(int numeroNIP, int numeroCompte){
        super(numeroNIP, numeroCompte);
        this.montantMaximum = 0;
        this.montantRemplissage =0 ;
    })

    public Banque(public Marge(int numeroNIP, int numeroCompte, double montantMaximum, double montantRemplissage){
        super(numeroNIP, numeroCompte);
        this.montantMaximum = montantMaximum;
        this.montantRemplissage = montantRemplissage;
    })


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

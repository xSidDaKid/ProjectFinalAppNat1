package com.example.appnatprojetsession.Models;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 16 decembre 2021
 * @author: A. Alperen, B. Shajaan et I. Gafran
 */
public class Banque extends Compte{
    private double montantMaximum = 0;
    private double montantRemplissage = 0;

    public Banque(){}

    public Banque(int numeroNIP, int numeroCompte){
        super(numeroNIP, numeroCompte);
    }

    public Banque(int numeroNIP, int numeroCompte, double montantMaximum, double montantRemplissage){
        super(numeroNIP, numeroCompte);
        this.montantMaximum = montantMaximum;
        this.montantRemplissage = montantRemplissage;
    }

    public Banque(int numeroNIP, int numeroCompte, double montantMaximum){
        super(numeroNIP, numeroCompte);
        this.montantMaximum = montantMaximum;
        this.montantRemplissage = 0;
    }

    public Banque(int numeroNIP, int numeroCompte,double soldeCompte, int retraitMaximum, int montantTransfertMaximum, double montantMaximum, double montantRemplissage){
        super(numeroNIP, numeroCompte, soldeCompte, retraitMaximum, montantTransfertMaximum);
        this.montantMaximum = montantMaximum;
        this.montantRemplissage = montantRemplissage;
    }

    public void remplirGuichet(double montantAAjouter){
        super.setSoldeCompte(super.getSoldeCompte()+ montantAAjouter);
    }

    public void retraitGuichet(double montantRetrait){
        super.setSoldeCompte(super.getSoldeCompte()- montantRetrait);
    }

    @Override
    public String toString() {
        return "Banque{" +
                "montantMaximum=" + montantMaximum +
                ", montantRemplissage=" + montantRemplissage +
                '}';
    }
}

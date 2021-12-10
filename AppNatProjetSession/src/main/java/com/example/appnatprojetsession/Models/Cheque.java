package com.example.appnatprojetsession.Models;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 28 septembre 2021
 * @author: Shajaan Balasingam
 * @DA: 1723144
 */
public class Cheque extends Compte{
    private final double fraisPaiementFacture = 0;
    private final double montantFactureMaximum = 0;

/*    public Cheque(int numeroNIP, int numeroCompte,
                  double soldeCompte, int retraitMaximum,
                  int montantFactureMaximum, double fraisPaiementFacture,
                  double montantFactureMaximum) {
        super(numeroNIP, numeroCompte, soldeCompte, retraitMaximum, montantFactureMaximum);
        this.fraisPaiementFacture = fraisPaiementFacture;
        this.montantFactureMaximum = montantFactureMaximum;
    }

    public Cheque(int numeroNIP, int numeroCompte,
                  double soldeCompte, int retraitMaximum,
                  int montantFactureMaximum) {
        super(numeroNIP, numeroCompte, soldeCompte, retraitMaximum, montantFactureMaximum);
        this.fraisPaiementFacture = 0;
        this.montantFactureMaximum = 0;
    }

    public Cheque(int numeroNIP, int numeroCompte){
        super(numeroNIP, numeroCompte);
        this.fraisPaiementFacture = 0;
        this.montantFactureMaximum = 0;
    }

    public Cheque(int numeroCompte, int numeroNIP) {
        super(numeroCompte, numeroNIP);
    }

    public Cheque(int numeroCompte, int numeroNIP, double soldeCompte, int retraitMaximum, int montantTransfertMaximum) {
        super(numeroCompte, numeroNIP, soldeCompte, retraitMaximum, montantTransfertMaximum);
    }*/

    public void paiementFacture (double montant) {

    }

    @Override
    public String toString() {
        return "Cheque{" +
                "fraisPaiementFacture=" + fraisPaiementFacture +
                ", montantFactureMaximum=" + montantFactureMaximum +
                '}';
    }
}

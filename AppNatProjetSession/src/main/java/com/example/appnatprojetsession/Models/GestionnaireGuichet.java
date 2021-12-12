package com.example.appnatprojetsession.Models;

import java.util.ArrayList;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 16 decembre 2021
 * @author: A. Alperen, B. Shajaan et I. Gafran
 */
public class GestionnaireGuichet {
    private Compte banque;
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Cheque> comptesCheque;
    private ArrayList<Epargne> comptesEpargne;
    private ArrayList<Marge> comptesMarge;
    private ArrayList<Hypothécaire> comptesHypothecaire;
    private ArrayList<Transaction> transactions;
    private double soldeCompteCourant;

    private static int numeroClient = 1000;
    private static int numeroCompte = 0;

    public Compte ValiderUtilisateur(String nom, int nip) {
        Compte c1 = null;
        return c1;
    }

    public double RetraitCheque(int nip, double montant) {
        double solde = 0;
        return solde;
    }

    public double RetraitEpargne(int nip, double montant) {
        double solde = 0;
        return solde;
    }

    public double DepotCheque(int nip, double montant) {
        double solde = 0;
        return solde;
    }

    public double DepotEpargne(int nip, double montant) {
        double solde = 0;
        return solde;
    }

    public boolean PaiementFacture(int nip, double montant) {
        return true;
    }

    public void TransfertFonds(int nip, double montant, Compte typeCompte) {

        //le type de compte détermine le compte vers lequel le transfert est fait.
    }

    public double AfficheSoldeCompte() {
        return this.soldeCompteCourant;
    }

    public void creerClient(int codeClient, String nom, String prenom, String telephone, String courriel, String numeroNIP) {
        this.incrementNumeroClient();
        //int numeroNIP = this.numeroClient;
        Client client = new Client(codeClient, nom, prenom, telephone, courriel, numeroNIP);
        this.clients.add(client);
        for (Client c:clients) {
            System.out.println(c);
        }
        //creer une methode dans cheque ou l'on a pas besoin de specifier le soldeCompte =0, retraitMaximum=?, montantTransfertMaximum=?
        //this.creerCheque(numeroNIP);
    }

    public void creerCompte() {}

    public void creerCheque(int numeroNIP/*, double soldeCompte, int retraitMaximum, int montantTransfertMaximum*/){
        this.incrementNumeroCompte();
   /*     int numerCompte = this.numerCompte;
        Compte c1 = new Cheque(numeroNIP, numeroCompte*//*, soldeCompte, retraitMaximum, montantTransfertMaximum*//* );
        this.comptesCheque.add(c1);*/
    }

    public void incrementNumeroClient(){
        this.numeroClient+=1;
    }

    public void incrementNumeroCompte(){
        this.numeroCompte+=1;
    }
}

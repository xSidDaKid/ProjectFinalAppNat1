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
    private static ArrayList<Client> clients = new ArrayList<>();
    private static ArrayList<Cheque> comptesCheque;
    private static ArrayList<Epargne> comptesEpargne;
    private static ArrayList<Marge> comptesMarge;
    private static ArrayList<Hypothécaire> comptesHypothecaire;
    private static ArrayList<Transaction> transactions;
    private double soldeCompteCourant;

    private static int codeClient = 1000;
    private static int numeroCompte = 0;

    public GestionnaireGuichet(){
    }

    public Compte getBanque() {
        return banque;
    }

    public void setBanque(Compte banque) {
        this.banque = banque;
    }

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public static ArrayList<Cheque> getComptesCheque() {
        return comptesCheque;
    }

    public static ArrayList<Epargne> getComptesEpargne() {
        return comptesEpargne;
    }

    public static ArrayList<Marge> getComptesMarge() {
        return comptesMarge;
    }

    public static ArrayList<Hypothécaire> getComptesHypothecaire() {
        return comptesHypothecaire;
    }

    public static ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public double getSoldeCompteCourant() {
        return soldeCompteCourant;
    }

    public void setSoldeCompteCourant(double soldeCompteCourant) {
        this.soldeCompteCourant = soldeCompteCourant;
    }


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

    public void creerClient( String nom, String prenom, String telephone, String courriel, int numeroNIP) {
        this.incrementCodeClient();
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

    public void incrementCodeClient(){
        this.codeClient+=1;
    }

    public void incrementNumeroCompte(){
        this.numeroCompte+=1;
    }
}

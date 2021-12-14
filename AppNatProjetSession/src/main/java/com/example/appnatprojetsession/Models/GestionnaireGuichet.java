package com.example.appnatprojetsession.Models;

import javafx.fxml.FXML;

import java.io.IOException;
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
    private static ArrayList<Cheque> comptesCheque = new ArrayList<>();
    private static ArrayList<Epargne> comptesEpargne=new ArrayList<>();
    private static ArrayList<Marge> comptesMarge = new ArrayList<>();
    private static ArrayList<Hypothécaire> comptesHypothecaire = new ArrayList<>();
    private static ArrayList<Transaction> transactions = new ArrayList<>();
    private double soldeCompteCourant;

    @FXML
    private static int codeClient = 1000;
    private static int numeroCompte = 0;
    private static Client client = new Client (codeClient, 0);

    public GestionnaireGuichet(){
        if(!clients.contains(client)){
            clients.add(client);
        }
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

    public static void setClients(ArrayList<Client> clients) {
        GestionnaireGuichet.clients = clients;
    }

    public static ArrayList<Cheque> getComptesCheque() {
        return comptesCheque;
    }

    public static void setComptesCheque(ArrayList<Cheque> comptesCheque) {
        GestionnaireGuichet.comptesCheque = comptesCheque;
    }

    public static ArrayList<Epargne> getComptesEpargne() {
        return comptesEpargne;
    }

    public static void setComptesEpargne(ArrayList<Epargne> comptesEpargne) {
        GestionnaireGuichet.comptesEpargne = comptesEpargne;
    }

    public static ArrayList<Marge> getComptesMarge() {
        return comptesMarge;
    }

    public static void setComptesMarge(ArrayList<Marge> comptesMarge) {
        GestionnaireGuichet.comptesMarge = comptesMarge;
    }

    public static ArrayList<Hypothécaire> getComptesHypothecaire() {
        return comptesHypothecaire;
    }

    public static void setComptesHypothecaire(ArrayList<Hypothécaire> comptesHypothecaire) {
        GestionnaireGuichet.comptesHypothecaire = comptesHypothecaire;
    }

    public static ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public static void setTransactions(ArrayList<Transaction> transactions) {
        GestionnaireGuichet.transactions = transactions;
    }

    public double getSoldeCompteCourant() {
        return soldeCompteCourant;
    }

    public void setSoldeCompteCourant(double soldeCompteCourant) {
        this.soldeCompteCourant = soldeCompteCourant;
    }

    public static int getCodeClient() {
        return codeClient;
    }

    public static void setCodeClient(int codeClient) {
        GestionnaireGuichet.codeClient = codeClient;
    }

    public static int getNumeroCompte() {
        return numeroCompte;
    }

    public static void setNumeroCompte(int numeroCompte) {
        GestionnaireGuichet.numeroCompte = numeroCompte;
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

    public void creerCompte(String typeCompte, int numeroNIP, int codeClient) {
        switch(typeCompte){
            case "Épargne":
                Epargne epargne = new Epargne( numeroNIP, codeClient);
                break;
            case "Marge de crédit":
                Marge marge = new Marge(numeroNIP, codeClient);
                break;
            case "Hypothécaire":
                Hypothécaire hypothécaire = new Hypothécaire(numeroNIP, codeClient);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + typeCompte);
        }

    }

    public void creerCheque(){
        Cheque c1 = new Cheque(this.clients.get(this.numeroCompte).getCodeClient(), this.clients.get(this.numeroCompte).getNumeroNIP());
        comptesCheque.add(c1);
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

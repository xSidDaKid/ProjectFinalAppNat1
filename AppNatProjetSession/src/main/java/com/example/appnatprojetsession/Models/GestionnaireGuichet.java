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
<<<<<<< HEAD
    private static ArrayList<Epargne> comptesEpargne;
    private static ArrayList<Marge> comptesMarge;
    private static ArrayList<Hypothécaire> comptesHypothecaire;
    private static ArrayList<Transaction> transactions;
    private static ArrayList<Integer> clientBloque = new ArrayList<>();
=======
    private static ArrayList<Epargne> comptesEpargne=new ArrayList<>();
    private static ArrayList<Marge> comptesMarge = new ArrayList<>();
    private static ArrayList<Hypothécaire> comptesHypothecaire = new ArrayList<>();
    private static ArrayList<Transaction> transactions = new ArrayList<>();
    private static ArrayList<Client> clientBloque = new ArrayList<>();
>>>>>>> 115f5cf2f29d80888a5f9ee59b1218252a9ccfb0
    private double soldeCompteCourant;


    private static int codeClient = 1000;
    private static int numeroCompte = 0;
    private static Client client = new Client (codeClient, 0);

    public GestionnaireGuichet(){
        if(!clients.contains(client)){
            clients.add(client);
            if(comptesCheque.isEmpty()) {
                creerCheque(client.getNumeroNIP(), client.getCodeClient());
                //Crée 2 fois
            }
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

    public static ArrayList<Integer> getClientBloque() {
        return clientBloque;
    }

    public static void setClientBloque(ArrayList<Integer> clientBloque) {
        GestionnaireGuichet.clientBloque = clientBloque;
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

    public static Client getClient() {
        return client;
    }

    public static void setClient(Client client) {
        GestionnaireGuichet.client = client;
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
        creerCheque(client.getNumeroNIP(), client.getCodeClient());
    }

    public void creerCompte(String typeCompte, int numeroNIP, int codeClient) {
        switch(typeCompte){
            case "Épargne":
                Epargne epargne = new Epargne( numeroNIP, codeClient);
                comptesEpargne.add(epargne);
                break;
            case "Marge de crédit":
                Marge marge = new Marge(numeroNIP, codeClient);
                comptesMarge.add(marge);
                break;
            case "Hypothécaire":
                Hypothécaire hypothécaire = new Hypothécaire(numeroNIP, codeClient);
                comptesHypothecaire.add(hypothécaire);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + typeCompte);
        }
    }

    public void creerCheque(int numeroNIP, int codeClient){
        Cheque c1 = new Cheque(numeroNIP, codeClient);
        comptesCheque.add(c1);
        this.incrementNumeroCompte();

    }

    public void bloquerClient(int codeClient){
        this.clientBloque.add(codeClient);
    }

    public void debloquerClient(int codeClient){
        for(int i=0;i< this.clientBloque.size(); i++){
            int value = clientBloque.get(i);
            if(value == codeClient){
                clientBloque.remove(i);
                break;
            }
        }
    }

    public void incrementCodeClient(){
        this.codeClient+=1;
    }

    public void incrementNumeroCompte(){
        this.numeroCompte+=1;
    }

}

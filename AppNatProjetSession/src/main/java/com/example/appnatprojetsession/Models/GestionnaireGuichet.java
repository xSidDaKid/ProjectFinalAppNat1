package com.example.appnatprojetsession.Models;

import java.util.ArrayList;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 16 decembre 2021
 * @author: A. Alperen, B. Shajaan et I. Gafran
 */

/**
 * Classe qui sert a gerer les relations entre les controlleur et les models
 */
public class GestionnaireGuichet {
    private static Banque banque = new Banque();
    private static ArrayList<Client> clients = new ArrayList<>();
    private static ArrayList<Cheque> comptesCheque = new ArrayList<>();
    private static ArrayList<Epargne> comptesEpargne = new ArrayList<>();
    private static ArrayList<Marge> comptesMarge = new ArrayList<>();
    private static ArrayList<Hypothécaire> comptesHypothecaire = new ArrayList<>();
    private static ArrayList<Transaction> transactions = new ArrayList<>();
    private static ArrayList<Integer> clientBloque = new ArrayList<>();
    private static int codeClient = 1000;
    private static int numeroCompte = 0;
    private static Client client = new Client(codeClient, 0);
    private double soldeCompteCourant;

    public GestionnaireGuichet() {
        if (!clients.contains(client)) {
            clients.add(client);
            if (comptesCheque.isEmpty()) {
                creerCheque(client.getNumeroNIP(), client.getCodeClient());
                creerBanque(client.getNumeroNIP(), client.getCodeClient(), 10000);
                //Crée 2 fois
            }
        }

    }

    //GETTERS & SETTERS-------------------------------------------------------------------------------------------------
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

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public double getSoldeCompteCourant() {
        return soldeCompteCourant;
    }

    public void setSoldeCompteCourant(double soldeCompteCourant) {
        this.soldeCompteCourant = soldeCompteCourant;
    }
    //FIN GETTERS & SETTERS---------------------------------------------------------------------------------------------

    //METHODE SPECIFIQUE
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

    /**
     * Methode qui sert a creer un client
     * @param nom
     * @param prenom
     * @param telephone
     * @param courriel
     * @param numeroNIP
     */
    public void creerClient(String nom, String prenom, String telephone, String courriel, int numeroNIP) {
        this.incrementCodeClient();
        //int numeroNIP = this.numeroClient;
        Client client = new Client(codeClient, nom, prenom, telephone, courriel, numeroNIP);
        this.clients.add(client);
        creerCheque(client.getNumeroNIP(), client.getCodeClient());
    }

    /**
     * Methode qui sert a creer un compte
     * @param typeCompte
     * @param numeroNIP
     * @param codeClient
     */
    public void creerCompte(String typeCompte, int numeroNIP, int codeClient) {
        switch (typeCompte) {
            case "Épargne":
                Epargne epargne = new Epargne(numeroNIP, codeClient);
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

    /**
     * Methode qui permet de creer un compte cheque
     * @param numeroNIP
     * @param codeClient
     */
    public void creerCheque(int numeroNIP, int codeClient) {
        Cheque c1 = new Cheque(numeroNIP, codeClient);
        comptesCheque.add(c1);
        this.incrementNumeroCompte();
    }

    /**
     * Methode qui sert a initialiser la Banque
     * @param numeroNIP
     * @param codeClient
     */
    public void creerBanque(int numeroNIP, int codeClient, int soldeCompte) {
        this.banque.setNumeroCompte(this.numeroCompte);
        this.banque.setNumeroNIP(numeroNIP);
        this.banque.setCodeClient(codeClient);
        this.banque.setSoldeCompte(soldeCompte);
        this.incrementNumeroCompte();
    }

    /**
     * Methode qui sert a bloquer un client
     * @param codeClient
     */
    public void bloquerClient(int codeClient) {
        this.clientBloque.add(codeClient);
    }

    /**
     * Methode qui sert a debloquer un client
     * @param codeClient
     */
    public void debloquerClient(int codeClient) {
        for (int i = 0; i < this.clientBloque.size(); i++) {
            int value = clientBloque.get(i);
            if (value == codeClient) {
                clientBloque.remove(i);
                break;
            }
        }
    }

    /**
     * Methode qui sert a incrementer le code du client
     */
    public void incrementCodeClient() {
        this.codeClient += 1;
    }

    /**
     * Methode qui sert a incrementer le numero du compte du client
     */
    public void incrementNumeroCompte() {
        this.numeroCompte += 1;
    }

}

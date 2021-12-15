package com.example.appnatprojetsession.Controllers;


import com.example.appnatprojetsession.Models.Client;
import com.example.appnatprojetsession.Models.GestionnaireGuichet;
import com.example.appnatprojetsession.Models.Transaction;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 16 decembre 2021
 * @author: A. Alperen, B. Shajaan et I. Gafran
 */
public class AdminController extends GestionnaireGuichet {
    //creerClient variables
    private static String nomC = "";
    private static String prenomC = "";
    private static String telephoneC = "";
    private static String courrielC = "";
    private static String nipC = "";

    //creerCompte variables
    private static int codeClient;
    private static String codeCli="";
    private static String typeCompte = "";

    GestionnaireGuichet gg = new GestionnaireGuichet();
    //Menu Admin pour pouvoir changer de fenetre
    @FXML
    private Label menuAdmin;

    //Creation d'un client
    @FXML
    private TextField nomClient;
    @FXML
    private TextField prenomClient;
    @FXML
    private TextField telephoneClient;
    @FXML
    private TextField courrielClient;
    @FXML
    private TextField nipClient;

    //Back-Deconnexion
    @FXML
    private Label creation;
    @FXML
    private Label creationCompte;
    @FXML
    private Label statutCompteClient;
    @FXML
    private Label afficherTransaction;
    @FXML
    private Label ajouterArgentGuichet;
    @FXML
    private Label prelevementHypo;

    // Creer_Compte & Afficher_Transaction
    @FXML
    private TextField saissiCodeClient;
    @FXML
    private RadioButton radioEpargne, radioMargeDeCredit, radioHypothecaire;

    /**
     * MENU OPTION 1 - Redirection vers le menu Creer Client
     *
     * @throws IOException
     */
    public void creerClient() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/Admin/creerClient.fxml"));
        Scene first = menuAdmin.getScene();
        ((Stage) first.getWindow()).setTitle("Creation d'un client");
        first.setRoot(root);
    }

    /**
     * MENU OPTION 2 - Redirection vers le menu Creer Compte
     *
     * @throws IOException
     */
    public void creerCompteClient() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/Admin/creerCompte.fxml"));
        Scene first = menuAdmin.getScene();
        ((Stage) first.getWindow()).setTitle("Creation d'un compte pour le client");
        first.setRoot(root);
        gg.creerCheque();
    }
    /**
     * MENU OPTION 3 - Redirection vers le menu Transaction compte
     *
     * @throws IOException
     */
    public void listeTransaction() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/Admin/afficherTransactions.fxml"));
        Scene first = menuAdmin.getScene();
        ((Stage) first.getWindow()).setTitle("Listes des transaction d'un compte client");
        first.setRoot(root);
    }
    /**
     * MENU OPTION 4 - Redirection vers le menu Bloquer/Debloquer Client
     *
     * @throws IOException
     */
    public void bloquerDebloquer() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/Admin/bloquerCompte.fxml"));
        Scene first = menuAdmin.getScene();
        ((Stage) first.getWindow()).setTitle("Bloquer/Debloquer un compte client");
        first.setRoot(root);
    }

    /**
     * MENU OPTION 5 - Redirection vers le menu Ajouter Argent Guichet
     *
     * @throws IOException
     */
    public void ajoutArgent() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/Admin/ajoutArgentGuichet.fxml"));
        Scene first = menuAdmin.getScene();
        ((Stage) first.getWindow()).setTitle("Ajout d'argent");
        first.setRoot(root);
    }

    /**
     * MENU OPTION 6 - Payer de l'interet
     *
     * @throws IOException
     */
    public void payerInteret() throws IOException {
        //TODO
    }

    /**
     * MENU OPTION 7 - Redirection vers le menu Prélèvement d'un montant
     *
     * @throws IOException
     */
    public void prelevement() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/Admin/prelevementHypothecaire.fxml"));
        Scene first = menuAdmin.getScene();
        ((Stage) first.getWindow()).setTitle("Prelevement d'un montant");
        first.setRoot(root);
    }

    /**
     * MENU OPTION 8 - Augmenter le solde de 5%
     *
     * @throws IOException
     */
    public void augmenterSolde() throws IOException {
        //TODO
    }

    /**
     * MENU OPTION 9 - Fermer le guichet
     *
     * @throws IOException
     */
    public void fermerGuichet() throws IOException {
        Platform.exit();
    }

//----------------------------------------------------------------------------------------------------------------------


    /**
     * Methodes qui sert a prendre les informations sur le client
     */
    public void infoClient() {
        GestionnaireGuichet gg = new GestionnaireGuichet();
        nomC = nomClient.getText();
        prenomC = prenomClient.getText();
        telephoneC = telephoneClient.getText();
        courrielC = courrielClient.getText();
        nipC = nipClient.getText();
        if (nomC.trim().equalsIgnoreCase("") || prenomC.trim().equalsIgnoreCase("") || telephoneC.trim().equalsIgnoreCase("")
                || courrielC.trim().equalsIgnoreCase("") || nipC.trim().equalsIgnoreCase("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "S.V.P. remplir tous les champs");
            alert.showAndWait();
            return;
        }

        int nip;
        try {

            nip = Integer.parseInt(nipC);
        } catch (Exception e) {
            System.out.println(e);
            Alert alert = new Alert(Alert.AlertType.ERROR, "S.V.P. Entrez des numeros valides pour le NIP et le code");
            alert.showAndWait();
            return;
        }

        this.gg.creerClient(nomC, prenomC, telephoneC, courrielC, nip);
        System.out.println(this.gg.getClients());
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Le client " + nomClient.getText() +" "+ prenomClient.getText() + "a ete creer");
        alert.showAndWait();
    }

    public void creerCompte(ActionEvent actionEvent){
        this.setSelectedButtons();

        if(codeCli.equalsIgnoreCase("") || typeCompte.equalsIgnoreCase("")){
            Alert alert = new Alert(Alert.AlertType.ERROR, "S.V.P. Remplir tous les champs");
            alert.showAndWait();
            return;
        }else{
            try{
                codeClient = Integer.parseInt(codeCli);
                //System.out.println("codeClient:"+ codeClient+" type Compte:"+ typeCompte);
            }catch(Exception e){
                //System.out.println(e);
                Alert alert = new Alert(Alert.AlertType.ERROR, "Le code du client doit etre des numeros");
                alert.showAndWait();
                return;
            }
            ArrayList<Client> clients = gg.getClients();
            for (Client c : clients) {
                if(c.getCodeClient() == codeClient){
                    gg.creerCompte( typeCompte,c.getNumeroNIP(),c.getCodeClient());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Le compte " + typeCompte +" pour le client "+ codeClient + " a ete creer");
                    alert.showAndWait();
                    return;
                }
            }
            Alert alert = new Alert(Alert.AlertType.ERROR, "le client "+ codeClient + " n'existe pas");
            alert.showAndWait();
        }
    }

    public void afficherTransaction(ActionEvent actionEvent) {
        this.setSelectedButtons();

        if(codeCli.equalsIgnoreCase("") || typeCompte.equalsIgnoreCase("")){
            Alert alert = new Alert(Alert.AlertType.ERROR, "S.V.P. Remplir tous les champs");
            alert.showAndWait();
            return;
        }else{
            try{
                codeClient = Integer.parseInt(codeCli);
                //System.out.println("codeClient:"+ codeClient+" type Compte:"+ typeCompte);
            }catch(Exception e){
                //System.out.println(e);
                Alert alert = new Alert(Alert.AlertType.ERROR, "Le code du client doit etre des numeros");
                alert.showAndWait();
                return;
            }
            ArrayList<Client> clients = gg.getClients();
            ArrayList<Transaction> transactions = gg.getTransactions();
            ArrayList<Transaction> transactionsClient = new ArrayList<Transaction>();
            for (Client c : clients) {
                if(c.getCodeClient() == codeClient){
                    for(Transaction t: transactions){
                        if(t.getCompte().getCodeClient() == c.getCodeClient()){
                            transactionsClient.add(t);
                        }
                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Voici la liste des clients:\n" + transactions);
                    alert.showAndWait();
                    return;
                }
            }
            Alert alert = new Alert(Alert.AlertType.ERROR, "le client "+ codeClient + " n'existe pas");
            alert.showAndWait();
        }
    }

    /**
     * Methode qui sert a afficher la liste des clients
     */
    public void afficherClients () {
        GestionnaireGuichet gg = new GestionnaireGuichet();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Voici la liste des clients:\n" + this.gg.getClients());
        alert.showAndWait();
    }


    /**
     * Methode qui sert a retourner au menu admin
     *
     * @throws IOException
     */
    public void back() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/Admin/menuAdmin.fxml"));
        Scene first = null;

        if ((menuAdmin) != null) {
            first = menuAdmin.getScene();
        } else if (creation != null) {
            first = creation.getScene();
        } else if (creationCompte != null) {
            first = creationCompte.getScene();
        } else if (statutCompteClient != null) {
            first = statutCompteClient.getScene();
        } else if (afficherTransaction != null) {
            first = afficherTransaction.getScene();
        } else if (ajouterArgentGuichet != null) {
            first = ajouterArgentGuichet.getScene();
        } else if (prelevementHypo != null) {
            first = prelevementHypo.getScene();
        }

        ((Stage) first.getWindow()).setTitle("Login");
        first.setRoot(root);
    }

    public void setSelectedButtons(){
        codeCli = saissiCodeClient.getText();
        if(radioEpargne.isSelected()){
            typeCompte = radioEpargne.getText();
        }else if(radioMargeDeCredit.isSelected()){
            typeCompte = radioMargeDeCredit.getText();
        }else if(radioHypothecaire.isSelected()){
            typeCompte = radioHypothecaire.getText();
        }
    }

    /**
     * Methode qui permet la deconnexion
     *
     * @throws IOException
     */
    public void deconnexion() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/LoginMenu.fxml"));
        Scene first = null;

        if ((menuAdmin) != null) {
            first = menuAdmin.getScene();
        } else if (creation != null) {
            first = creation.getScene();
        } else if (creationCompte != null) {
            first = creationCompte.getScene();
        } else if (statutCompteClient != null) {
            first = statutCompteClient.getScene();
        } else if (afficherTransaction != null) {
            first = afficherTransaction.getScene();
        } else if (ajouterArgentGuichet != null) {
            first = ajouterArgentGuichet.getScene();
        } else if (prelevementHypo != null) {
            first = prelevementHypo.getScene();
        }

        ((Stage) first.getWindow()).setTitle("Login");
        first.setRoot(root);
    }

}
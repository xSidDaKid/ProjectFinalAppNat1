package com.example.appnatprojetsession.Controllers;


import com.example.appnatprojetsession.Models.GestionnaireGuichet;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 16 decembre 2021
 * @author: A. Alperen, B. Shajaan et I. Gafran
 */
public class AdminController extends GestionnaireGuichet {

    public static String codeUtilisateur = "";
    public static String nipUtilisateur = "";
    public static String nomC = "";
    public static String prenomC = "";
    public static String telephoneC = "";
    public static String courrielC = "";
    public static String nipC = "";

    GestionnaireGuichet gg = new GestionnaireGuichet();
    //Menu Admin pour pouvoir changer de fenetre
    @FXML
    Label menuAdmin;

    //Creation d'un client
    @FXML
    TextField nomClient;
    @FXML
    TextField prenomClient;
    @FXML
    TextField telephoneClient;
    @FXML
    TextField courrielClient;
    @FXML
    TextField nipClient;

    //Back-Deconnexion
    @FXML
    Label creation;
    @FXML
    Label creationCompte;
    @FXML
    Label statutCompteClient;
    @FXML
    Label afficherTransaction;
    @FXML
    Label ajouterArgentGuichet;
    @FXML
    Label prelevementHypo;

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

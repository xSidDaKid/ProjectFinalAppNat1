package com.example.appnatprojetsession.Controllers;

import com.example.appnatprojetsession.Models.Client;
import com.example.appnatprojetsession.Models.Compte;
import com.example.appnatprojetsession.Models.GestionnaireGuichet;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 16 decembre 2021
 * @author: A. Alperen, B. Shajaan et I. Gafran
 */
public class UserController implements Initializable {


    GestionnaireGuichet gg = new GestionnaireGuichet();


    @FXML
    private Label menuUser;
    @FXML
    private Label consulterSolde;
    @FXML
    private Label transfertPaiement;
    @FXML
    private Label depotRetrait;

    // depot solde
    @FXML
     ComboBox<Compte> listeComptes=new ComboBox<>();


    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> testString= FXCollections.observableArrayList();
        testString.add("test");
        testString.add("test2");



        int idUser = Integer.parseInt(LoginController.codeUtilisateur);
        ObservableList<Compte> comptes= FXCollections.observableArrayList();

        comptes.addAll(GestionnaireGuichet.getComptesCheque());

        comptes.addAll(GestionnaireGuichet.getComptesCheque());
            comptes.addAll(GestionnaireGuichet.getComptesEpargne());
            comptes.addAll(GestionnaireGuichet.getComptesHypothecaire());



        ObservableList<Compte> comptesClient= FXCollections.observableArrayList();

        for (Compte c: comptes){
            if(c.getCodeClient() == idUser){
                comptesClient.add(c);

            }
        }
        System.out.println(comptes);
        System.out.println(comptes.get(0).getCodeClient());
        System.out.println(idUser);

            this.listeComptes.setItems(comptesClient);

    }

    @FXML
    void comptesDisponibles(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/User/consulterSolde.fxml"));
        Scene first = menuUser.getScene();
        ((Stage) first.getWindow()).setTitle("Soldes");
        first.setRoot(root);
    }


    public void depotCompte(){




    }
    @FXML
    void selectionChanged(ActionEvent event) {

    }


    @FXML
    void depotAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/User/DepotRetrait.fxml"));
        Scene first = menuUser.getScene();
        ((Stage) first.getWindow()).setTitle("Dépot");
        first.setRoot(root);
    }

    @FXML
    void paiementAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/User/transfertPaiement.fxml"));
        Scene first = menuUser.getScene();
        ((Stage) first.getWindow()).setTitle("Paiement");
        first.setRoot(root);
    }

    @FXML
    void retraitAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/User/DepotRetrait.fxml"));
        Scene first = menuUser.getScene();
        ((Stage) first.getWindow()).setTitle("Retrait");
        first.setRoot(root);
    }

    @FXML
    void transfertAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/User/transfertPaiement.fxml"));
        Scene first = menuUser.getScene();
        ((Stage) first.getWindow()).setTitle("Transfert");
        first.setRoot(root);
    }

    @FXML
    public void back() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/User/menuUser.fxml"));
        Scene first = null;

        if ((menuUser) != null) {
            first = menuUser.getScene();
        } else if (consulterSolde != null) {
            first = consulterSolde.getScene();
        } else if (transfertPaiement != null) {
            first = transfertPaiement.getScene();
        } else if (depotRetrait != null) {
            first = depotRetrait.getScene();
        }

        ((Stage) first.getWindow()).setTitle("Login");
        first.setRoot(root);
    }

        public void deconnexion() throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/LoginMenu.fxml"));
            Scene first = null;

            if ((menuUser) != null) {
                first = menuUser.getScene();
            } else if (consulterSolde != null) {
                first = consulterSolde.getScene();
            } else if (transfertPaiement != null) {
                first = transfertPaiement.getScene();
            } else if (depotRetrait != null) {
                first = depotRetrait.getScene();
            }

            ((Stage) first.getWindow()).setTitle("Login");
            first.setRoot(root);
        }
    }


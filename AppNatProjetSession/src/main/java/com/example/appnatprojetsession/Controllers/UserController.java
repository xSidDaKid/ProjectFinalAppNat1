package com.example.appnatprojetsession.Controllers;

import com.example.appnatprojetsession.Models.Compte;
import com.example.appnatprojetsession.Models.GestionnaireGuichet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Cours: Applications natives 1
 * @Remis_à: Toufik Bellal
 * @Date_de_remise: 16 decembre 2021
 * @author: A. Alperen, B. Shajaan et I. Gafran
 */
public class UserController implements Initializable {

    GestionnaireGuichet gg = new GestionnaireGuichet();

    // depot solde
    @FXML
    ComboBox<Compte> listeComptes = new ComboBox<>();
    @FXML
    private Label menuUser;
    @FXML
    private Label consulterSolde;
    @FXML
    private Label transfertPaiement;
    @FXML
    private Label depotRetrait;
    @FXML
    private RadioButton radioRetrait;

    @FXML
    private ToggleGroup grDepot;

    @FXML
    private RadioButton radioDepot;

    @FXML
    private TextField inputMontant;


    /**
     * MENU OPTION 1 - Redirection vers le menu Depot/Retrait
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void depotAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/User/DepotRetrait.fxml"));
        Scene first = menuUser.getScene();
        ((Stage) first.getWindow()).setTitle("Dépot");
        first.setRoot(root);
    }

    /**
     * MENU OPTION 2 - Redirection vers le menu Transfert/Paiement
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void transfertAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/User/transfertPaiement.fxml"));
        Scene first = menuUser.getScene();
        ((Stage) first.getWindow()).setTitle("Transfert");
        first.setRoot(root);
    }

    /**
     * MENU OPTION 3 - Redirection vers le menu Comptes Disponibles
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void comptesDisponibles(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/User/consulterSolde.fxml"));
        Scene first = menuUser.getScene();
        ((Stage) first.getWindow()).setTitle("Soldes");
        first.setRoot(root);
    }

//----------------------------------------------------------------------------------------------------------------------

    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> testString = FXCollections.observableArrayList();
        testString.add("test");
        testString.add("test2");


        int idUser = Integer.parseInt(LoginController.codeUtilisateur);
        ObservableList<Compte> comptes = FXCollections.observableArrayList();

        comptes.addAll(GestionnaireGuichet.getComptesCheque());

        comptes.addAll(GestionnaireGuichet.getComptesCheque());
        comptes.addAll(GestionnaireGuichet.getComptesEpargne());
        comptes.addAll(GestionnaireGuichet.getComptesHypothecaire());


        ObservableList<Compte> comptesClient = FXCollections.observableArrayList();

        for (Compte c : comptes) {
            if (c.getCodeClient() == idUser) {
                comptesClient.add(c);

            }
        }
        System.out.println(comptes);

        this.listeComptes.setItems(comptesClient);

    }

    /**
     * Methode qui sert a savoir ce que le client a choisi entre le depot et le retrait
     */
    public void depotRetrait() {
        if (radioDepot.isSelected()) {
            depotCompte();
        } else if (radioDepot.isSelected()) {
            retraitCompte();
        }
    }

    /**
     * Methode qui sert a faire un depot dans le compte du client
     */
    public void depotCompte() {
        Compte compte = (Compte) listeComptes.getSelectionModel().getSelectedItem();
        String compteString = compte.toString();

        String type = compteString.substring(compteString.indexOf("[") + 1, compteString.indexOf("{"));
        System.out.println(type);
        int montant = Integer.parseInt(inputMontant.getText());
    }

    /**
     * Methode qui sert a faire un retrait dans le compte du client
     */
    public void retraitCompte() {
        Compte compte = (Compte) listeComptes.getSelectionModel().getSelectedItem();
    }

    @FXML
    void selectionChanged(ActionEvent event) {
        //TODO
    }

    /**
     * Methode qui sert a retourner au menu User
     *
     * @throws IOException
     */
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

    /**
     * Methode qui permet la deconnexion
     *
     * @throws IOException
     */
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


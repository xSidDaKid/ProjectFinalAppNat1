package com.example.appnatprojetsession.Controllers;

import com.example.appnatprojetsession.Models.*;
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
    // depot solde
    @FXML
    ComboBox<String> listeComptes = new ComboBox<>();
    // Afficher comptes
    @FXML
    private ComboBox<String> tousComptes = new ComboBox<>();
    @FXML
    private Label lbSolde;
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

    // Transfert / Paiement

    @FXML
    private ComboBox<String> transfertComptes = new ComboBox<>();

    @FXML
    private RadioButton radioTranfert;

    @FXML
    private ToggleGroup grTransfert;

    @FXML
    private RadioButton radioPaiement;

    @FXML
    private TextField inputPaiement;

    /**
     * MENU OPTION 1 - Redirection vers le menu Depot/Retrait
     * @param event
     * @throws IOException
     */
    @FXML
    void depotAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/User/DepotRetrait.fxml"));
        Scene first = menuUser.getScene();
        ((Stage) first.getWindow()).setTitle("Dépot");
        ((Stage) first.getWindow()).setWidth(340);
        ((Stage) first.getWindow()).setHeight(355);
        ((Stage) first.getWindow()).centerOnScreen();
        first.setRoot(root);
    }

    /**
     * MENU OPTION 2 - Redirection vers le menu Transfert/Paiement
     * @param event
     * @throws IOException
     */
    @FXML
    void transfertAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/User/transfertPaiement.fxml"));
        Scene first = menuUser.getScene();
        ((Stage) first.getWindow()).setTitle("Transfert");
        ((Stage) first.getWindow()).setWidth(415);
        ((Stage) first.getWindow()).setHeight(382);
        ((Stage) first.getWindow()).centerOnScreen();
        first.setRoot(root);
    }

    /**
     * MENU OPTION 3 - Redirection vers le menu Comptes Disponibles
     * @param event
     * @throws IOException
     */
    @FXML
    void comptesDisponibles(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/User/consulterSolde.fxml"));
        Scene first = menuUser.getScene();
        ((Stage) first.getWindow()).setTitle("Comptes Disponibles");
        ((Stage) first.getWindow()).setWidth(500);
        ((Stage) first.getWindow()).setHeight(279);
        ((Stage) first.getWindow()).centerOnScreen();
        first.setRoot(root);
    }

//----------------------------------------------------------------------------------------------------------------------

    /**
     * Methodes qui sert a initialiser les ComboBox
     * @param location
     * @param resources
     */
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> testString = FXCollections.observableArrayList();
        testString.add("test");
        testString.add("test2");


        int idUser = Integer.parseInt(LoginController.codeUtilisateur);
        ObservableList<Compte> comptes = FXCollections.observableArrayList();

        comptes.addAll(GestionnaireGuichet.getComptesCheque());
        comptes.addAll(GestionnaireGuichet.getComptesEpargne());
        comptes.addAll(GestionnaireGuichet.getComptesHypothecaire());


        ObservableList<String> comptesClient = FXCollections.observableArrayList();

        for (Compte c : comptes) {
            if (c.getCodeClient() == idUser) {
                String txt = c.getClass().toString();
                String[] split = txt.split("\\.");
                txt = "Type: " + split[4] + " :" + (c.getNumeroCompte());
                comptesClient.add(txt);

            }
        }
        System.out.println(comptes);

        this.listeComptes.setItems(comptesClient);

        ObservableList<Compte> comptesTout = FXCollections.observableArrayList();
        ObservableList<String> comptesClientTout = FXCollections.observableArrayList();
        comptesTout.addAll(GestionnaireGuichet.getComptesCheque());
        comptesTout.addAll(GestionnaireGuichet.getComptesEpargne());
        comptesTout.addAll(GestionnaireGuichet.getComptesHypothecaire());
        comptesTout.addAll(GestionnaireGuichet.getComptesMarge());
        for (Compte c : comptesTout) {
            if (c.getCodeClient() == idUser) {
                String txt = c.getClass().toString();
                String[] split = txt.split("\\.");
                txt = "Type: " + split[4] + " :" + (c.getNumeroCompte());
                comptesClientTout.add(txt);

            }
        }


        this.tousComptes.setItems(comptesClientTout);

        ObservableList<Compte> comptesTransfert = FXCollections.observableArrayList();
        ObservableList<String> comptesClientTranfert = FXCollections.observableArrayList();
        comptesTransfert.addAll(GestionnaireGuichet.getComptesEpargne());
        comptesTransfert.addAll(GestionnaireGuichet.getComptesHypothecaire());
        comptesTransfert.addAll(GestionnaireGuichet.getComptesMarge());
        for (Compte c : comptesTransfert) {
            if (c.getCodeClient() == idUser) {
                String txt = c.getClass().toString();
                String[] split = txt.split("\\.");
                txt = "Type: " + split[4] + " :" + (c.getNumeroCompte());
                comptesClientTranfert.add(txt);

            }
        }


        this.transfertComptes.setItems(comptesClientTranfert);

    }

    /**
     * Methode qui sert a savoir ce que le client a choisi entre le depot et le retrait
     */
    public void depotRetrait() {
        if (radioDepot.isSelected()) {
            depotCompte();
        } else if (radioRetrait.isSelected()) {
            retraitCompte();
        }
    }

    /**
     * Methode qui sert a faire un depot dans le compte du client
     */
    public void depotCompte() {

        String compte = listeComptes.getSelectionModel().getSelectedItem();

        System.out.println(compte);
        String[] typeList = compte.split(":");
        String type = typeList[1].trim();
        System.out.println(type + "test");
        compte = typeList[2];


        int montant = Integer.parseInt(inputMontant.getText());
        int modulo = montant % 10;

        if (modulo != 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Il faut ajouter un montant qui est un  multiple de 10 dans le guichet");
            alert.showAndWait();
            return;
        } else {

            if (type.equals("Cheque")) {

                Cheque compteCheque;
                ArrayList<Cheque> listeCheque = GestionnaireGuichet.getComptesCheque();

                for (int i = 0; i < listeCheque.size(); i++) {

                    if (listeCheque.get(i).getNumeroCompte() == Integer.parseInt(compte)) {
                        compteCheque = listeCheque.get(i);
                        System.out.println(compteCheque.getSoldeCompte());
                        double solde = compteCheque.getSoldeCompte();
                        solde = solde + montant;
                        compteCheque.setSoldeCompte(solde);
                        System.out.println(compteCheque.getSoldeCompte());
                        listeCheque.set(i, compteCheque);

                        GestionnaireGuichet.setComptesCheque(listeCheque);

                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Un solde de " + montant + " a été ajouté");
                        alert.showAndWait();
                    }

                }

            } else if (type.equals("Hypothécaire")) {
                Hypothécaire compteCheque;
                ArrayList<Hypothécaire> listeCheque = GestionnaireGuichet.getComptesHypothecaire();

                for (int i = 0; i < listeCheque.size(); i++) {

                    if (listeCheque.get(i).getNumeroCompte() == Integer.parseInt(compte)) {
                        compteCheque = listeCheque.get(i);
                        System.out.println(compteCheque.getSoldeCompte());
                        double solde = compteCheque.getSoldeCompte();
                        solde = solde + montant;
                        compteCheque.setSoldeCompte(solde);
                        System.out.println(compteCheque.getSoldeCompte());
                        listeCheque.set(i, compteCheque);

                        GestionnaireGuichet.setComptesHypothecaire(listeCheque);

                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Un solde de " + montant + " a été ajouté");
                        alert.showAndWait();
                    }

                }

            } else if (type.equals("Epargne")) {
                Epargne compteCheque;
                ArrayList<Epargne> listeCheque = GestionnaireGuichet.getComptesEpargne();

                for (int i = 0; i < listeCheque.size(); i++) {

                    if (listeCheque.get(i).getNumeroCompte() == Integer.parseInt(compte)) {
                        compteCheque = listeCheque.get(i);
                        System.out.println(compteCheque.getSoldeCompte());
                        double solde = compteCheque.getSoldeCompte();
                        solde = solde + montant;
                        compteCheque.setSoldeCompte(solde);
                        System.out.println(compteCheque.getSoldeCompte());
                        listeCheque.set(i, compteCheque);


                        GestionnaireGuichet.setComptesEpargne(listeCheque);


                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Un solde de " + montant + " a été ajouté");
                        alert.showAndWait();
                    }

                }
            }

            return;
        }

    }

    /**
     * Methode qui sert a faire un retrait dans le compte du client
     */
    public void retraitCompte() {

        String compte = listeComptes.getSelectionModel().getSelectedItem();

        System.out.println(compte);
        String[] typeList = compte.split(":");
        String type = typeList[1].trim();
        System.out.println(type + "test");
        compte = typeList[2];


        double montant = Integer.parseInt(inputMontant.getText());
        double modulo = montant % 10;

        if (modulo != 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Il faut ajouter un montant qui est un  multiple de 10 dans le guichet");
            alert.showAndWait();
            return;

        } else if (type.equals("Hypothécaire")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Vous ne pouvez pas retirer d'un compte hypothécaire");
            alert.showAndWait();
            return;

        } else {

            if (type.equals("Cheque")) {

                Cheque compteCheque;
                ArrayList<Cheque> listeCheque = GestionnaireGuichet.getComptesCheque();

                for (int i = 0; i < listeCheque.size(); i++) {

                    if (listeCheque.get(i).getNumeroCompte() == Integer.parseInt(compte)) {
                        compteCheque = listeCheque.get(i);
                        System.out.println(compteCheque.getSoldeCompte());
                        double solde = compteCheque.getSoldeCompte();

                        if (solde < montant + 1.25) {
                            boolean validation=false;
                            int idUser = Integer.parseInt(LoginController.codeUtilisateur);
                            ArrayList<Marge> listeMarge = GestionnaireGuichet.getComptesMarge();
                            for (int j = 0; j < listeMarge.size(); j++){
                                if(listeMarge.get(j).getCodeClient()==idUser){

                                    double soldeTemp=montant-solde;

                                    Marge compteMarge= listeMarge.get(j);
                                    compteMarge.setSoldeCompte(compteMarge.getSoldeCompte()+soldeTemp+1.25);
                                    listeMarge.set(j,compteMarge);

                                    GestionnaireGuichet.setComptesMarge(listeMarge);


                                    compteCheque.setSoldeCompte(0.0);
                                    System.out.println(compteCheque.getSoldeCompte());
                                    listeCheque.set(i, compteCheque);

                                    GestionnaireGuichet.setComptesCheque(listeCheque);
                                    validation=true;

                                }



                            }

                            if(validation==false){
                                Alert alert = new Alert(Alert.AlertType.ERROR, "Solde insuffisant. Vous n'avez pas de compte de marge");
                                alert.showAndWait();
                            }

                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "LE montant qui depasse votre solde à été ajouté comme facture dans votre compte de marge");
                            alert.showAndWait();
                            return;
                        }


                        solde = (solde - montant) - 1.25;
                        compteCheque.setSoldeCompte(solde);
                        System.out.println(compteCheque.getSoldeCompte());
                        listeCheque.set(i, compteCheque);

                        GestionnaireGuichet.setComptesCheque(listeCheque);

                        // gg.getBanque().retraitGuichet(montant);

                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Un solde de " + montant + " a été retiré");
                        alert.showAndWait();
                    }

                }

            } else if (type.equals("Epargne")) {
                Epargne compteCheque;
                ArrayList<Epargne> listeCheque = GestionnaireGuichet.getComptesEpargne();

                for (int i = 0; i < listeCheque.size(); i++) {

                    if (listeCheque.get(i).getNumeroCompte() == Integer.parseInt(compte)) {
                        compteCheque = listeCheque.get(i);
                        System.out.println(compteCheque.getSoldeCompte());
                        double solde = compteCheque.getSoldeCompte();

                        if (solde < montant + 1.25) {
                            boolean validation=false;

                            int idUser = Integer.parseInt(LoginController.codeUtilisateur);
                            ArrayList<Marge> listeMarge = GestionnaireGuichet.getComptesMarge();
                            for (int j = 0; j < listeMarge.size(); j++){
                                if(listeMarge.get(j).getCodeClient()==idUser){

                                    double soldeTemp=montant-solde;

                                    Marge compteMarge= listeMarge.get(j);
                                    compteMarge.setSoldeCompte(compteMarge.getSoldeCompte()+soldeTemp+1.25);
                                    listeMarge.set(j,compteMarge);

                                    GestionnaireGuichet.setComptesMarge(listeMarge);


                                    compteCheque.setSoldeCompte(0.0);
                                    System.out.println(compteCheque.getSoldeCompte());
                                    listeCheque.set(i, compteCheque);

                                    GestionnaireGuichet.setComptesEpargne(listeCheque);
                                    validation=true;

                                }


                            }
                            if(validation==false){
                                Alert alert = new Alert(Alert.AlertType.ERROR, "Solde insuffisant. Vous n'avez pas de compte de marge");
                                alert.showAndWait();
                            }

                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "LE montant qui depasse votre solde à été ajouté comme facture dans votre compte de marge");
                            alert.showAndWait();
                            return;
                        }

                        solde = (solde - montant) - 1.25;
                        compteCheque.setSoldeCompte(solde);
                        System.out.println(compteCheque.getSoldeCompte());
                        listeCheque.set(i, compteCheque);

                        GestionnaireGuichet.setComptesEpargne(listeCheque);

                        gg.getBanque().retraitGuichet(montant);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Un solde de " + montant + " a été retiré");
                        alert.showAndWait();
                    }

                }
            }

            return;
        }

    }

    /**
     * Methode qui sert a savoir quelle compte le client a choisi
     * @param event
     */
    @FXML
    void selectionCompte(ActionEvent event) {
        String compte = tousComptes.getSelectionModel().getSelectedItem();

        System.out.println(compte);
        String[] typeList = compte.split(":");
        String type = typeList[1].trim();
        System.out.println(type + "test");
        compte = typeList[2];

        Compte compteCheque;
        ArrayList<Compte> listeCheque = new ArrayList<>();
        listeCheque.addAll(GestionnaireGuichet.getComptesCheque());
        listeCheque.addAll(GestionnaireGuichet.getComptesEpargne());
        listeCheque.addAll(GestionnaireGuichet.getComptesHypothecaire());
        listeCheque.addAll(GestionnaireGuichet.getComptesMarge());

        double solde = 0.0;

        for (int i = 0; i < listeCheque.size(); i++) {

            if (listeCheque.get(i).getNumeroCompte() == Integer.parseInt(compte)) {
                compteCheque = listeCheque.get(i);
                System.out.println(compteCheque.getSoldeCompte());
                solde = compteCheque.getSoldeCompte();

            }

        }
        lbSolde.setText(solde + "$");
    }


    /**
     * Methode qui sert a savoir ce que le client a choisi entre le treansfert et le paiement
     * @param event
     */
    @FXML
    void transfertPaiement(ActionEvent event) {
        if (radioTranfert.isSelected()) {
            transfert();
        } else if (radioPaiement.isSelected()) {
            paiement();
        }
    }

    /**
     * Methode qui sert a faire un transfert
     */
    public void transfert() {

        if (inputPaiement.getText().equalsIgnoreCase("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "S.V.P. veuillez remplir les champs");
            alert.showAndWait();
            return;
        }
        double montantTransfert = Double.parseDouble(inputPaiement.getText());
        String compte = transfertComptes.getSelectionModel().getSelectedItem();


        System.out.println(compte);
        String[] typeList = compte.split(":");
        String type = typeList[1].trim();
        System.out.println(type + "test");
        compte = typeList[2];

        Compte compteCheque;
        ArrayList<Compte> listeCheque = new ArrayList<>();
        listeCheque.addAll(GestionnaireGuichet.getComptesEpargne());
        listeCheque.addAll(GestionnaireGuichet.getComptesHypothecaire());
        listeCheque.addAll(GestionnaireGuichet.getComptesMarge());


        Cheque compteChequeUser;
        ArrayList<Cheque> listeChequeUser = new ArrayList<>();
        listeChequeUser = (GestionnaireGuichet.getComptesCheque());


        for (int i = 0; i < listeChequeUser.size(); i++) {

            if (listeChequeUser.get(i).getCodeClient() == Integer.parseInt(LoginController.codeUtilisateur)) {
                compteChequeUser = listeChequeUser.get(i);
                System.out.println(compteChequeUser.getSoldeCompte());
                double solde = compteChequeUser.getSoldeCompte();


                if (solde < montantTransfert + 1.25) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Votre solde n'est pas suffisant");
                    alert.showAndWait();
                    return;
                }


                solde = (solde - montantTransfert);
                compteChequeUser.setSoldeCompte(solde);
                System.out.println(compteChequeUser.getSoldeCompte());
                listeChequeUser.set(i, compteChequeUser);

                GestionnaireGuichet.setComptesCheque(listeChequeUser);


            }

        }


        for (int i = 0; i < listeCheque.size(); i++) {
            System.out.println("test boucle");
            if (listeCheque.get(i).getNumeroCompte() == Integer.parseInt(compte)) {

                compteCheque = listeCheque.get(i);
                System.out.println(compteCheque.getSoldeCompte());
                double solde = compteCheque.getSoldeCompte();


                solde = (solde + montantTransfert);
                compteCheque.setSoldeCompte(solde);
                System.out.println(compteCheque.getSoldeCompte());
                listeCheque.set(i, compteCheque);


                for (int j = 0; j < listeCheque.size(); j++) {

                    System.out.println(compte);
                    String[] typeListUser = listeCheque.get(j).getClass().toString().split(":");
                    String typeUser = typeList[1].trim();
                    System.out.println(type + "test");
                    compte = typeList[2];


                    if (typeUser.equals("Epargne")) {
                        Epargne epargne = (Epargne) listeCheque.get(i);
                        ArrayList<Epargne> liste = GestionnaireGuichet.getComptesEpargne();
                        liste.set(i, epargne);
                        GestionnaireGuichet.setComptesEpargne(liste);

                    } else if (typeUser.equals("Hypothécaire")) {
                        Hypothécaire epargne = (Hypothécaire) listeCheque.get(i);
                        ArrayList<Hypothécaire> liste = GestionnaireGuichet.getComptesHypothecaire();
                        liste.set(i, epargne);
                        GestionnaireGuichet.setComptesHypothecaire(liste);

                    } else if (typeUser.equals("Marge")) {
                        Marge epargne = (Marge) listeCheque.get(i);
                        ArrayList<Marge> liste = GestionnaireGuichet.getComptesMarge();
                        liste.set(i, epargne);
                        GestionnaireGuichet.setComptesMarge(liste);
                    }


                }


                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Transfert effectué");
                alert.showAndWait();
                return;

            }

        }

    }

    public void paiement(){

        if (inputPaiement.getText().equalsIgnoreCase("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "S.V.P. veuillez remplir les champs");
            alert.showAndWait();
            return;
        }
        double montantTransfert = Double.parseDouble(inputPaiement.getText());
        String compte = transfertComptes.getSelectionModel().getSelectedItem();



        System.out.println(compte);
        String[] typeList = compte.split(":");
        String type = typeList[1].trim();
        System.out.println(type + "test");
        compte = typeList[2];

        if (!type.equals("Marge")){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Vous pouvez payer seuleument votre facture de Marge");
            alert.showAndWait();
            return;
        }



        Compte compteCheque;
        ArrayList<Compte> listeCheque = new ArrayList<>();
        listeCheque.addAll(GestionnaireGuichet.getComptesMarge());


        Cheque compteChequeUser;
        ArrayList<Cheque> listeChequeUser = new ArrayList<>();
        listeChequeUser = (GestionnaireGuichet.getComptesCheque());


        for (int i = 0; i < listeChequeUser.size(); i++) {

            if (listeChequeUser.get(i).getCodeClient() == Integer.parseInt(LoginController.codeUtilisateur)) {
                compteChequeUser = listeChequeUser.get(i);
                System.out.println(compteChequeUser.getSoldeCompte());
                double solde = compteChequeUser.getSoldeCompte();


                if (solde < montantTransfert + 1.25) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Votre solde n'est pas suffisant");
                    alert.showAndWait();
                    return;
                }


                solde = (solde - montantTransfert);
                compteChequeUser.setSoldeCompte(solde);
                System.out.println(compteChequeUser.getSoldeCompte());
                listeChequeUser.set(i, compteChequeUser);

                GestionnaireGuichet.setComptesCheque(listeChequeUser);


            }

        }


        for (int i = 0; i < listeCheque.size(); i++) {
            System.out.println("test boucle");
            if (listeCheque.get(i).getNumeroCompte() == Integer.parseInt(compte)) {

                compteCheque = listeCheque.get(i);
                System.out.println(compteCheque.getSoldeCompte());
                double solde = compteCheque.getSoldeCompte();



                if(montantTransfert==compteCheque.getSoldeCompte()){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Vous avez une facture de "+solde+" a payer. (Veuillez entrer le montant exact)");
                    alert.showAndWait();
                    return;

                }


                solde = (solde - montantTransfert);
                compteCheque.setSoldeCompte(solde);
                System.out.println(compteCheque.getSoldeCompte());
                listeCheque.set(i, compteCheque);


                for (int j = 0; j < listeCheque.size(); j++) {

                    System.out.println(compte);
                    String[] typeListUser = listeCheque.get(j).getClass().toString().split(":");
                    String typeUser = typeList[1].trim();
                    System.out.println(type + "test");
                    compte = typeList[2];


                    if (typeUser.equals("Epargne")) {
                        Epargne epargne = (Epargne) listeCheque.get(i);
                        ArrayList<Epargne> liste = GestionnaireGuichet.getComptesEpargne();
                        liste.set(i, epargne);
                        GestionnaireGuichet.setComptesEpargne(liste);

                    } else if (typeUser.equals("Hypothécaire")) {
                        Hypothécaire epargne = (Hypothécaire) listeCheque.get(i);
                        ArrayList<Hypothécaire> liste = GestionnaireGuichet.getComptesHypothecaire();
                        liste.set(i, epargne);
                        GestionnaireGuichet.setComptesHypothecaire(liste);

                    } else if (typeUser.equals("Marge")) {
                        Marge epargne = (Marge) listeCheque.get(i);
                        ArrayList<Marge> liste = GestionnaireGuichet.getComptesMarge();
                        liste.set(i, epargne);
                        GestionnaireGuichet.setComptesMarge(liste);
                    }


                }


                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Paiement effectué");
                alert.showAndWait();
                return;

            }

        }

    }


    /**
     * Methode qui sert a retourner au menu User
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

        ((Stage) first.getWindow()).setWidth(582);
        ((Stage) first.getWindow()).setHeight(311);
        ((Stage) first.getWindow()).centerOnScreen();
        ((Stage) first.getWindow()).setTitle("Menu User");
        first.setRoot(root);
    }

    /**
     * Methode qui permet de se deconnecter
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
        ((Stage) first.getWindow()).setWidth(551);
        ((Stage) first.getWindow()).setHeight(359);
        ((Stage) first.getWindow()).centerOnScreen();
        first.setRoot(root);
    }
}


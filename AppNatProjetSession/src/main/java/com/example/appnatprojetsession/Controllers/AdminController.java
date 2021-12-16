package com.example.appnatprojetsession.Controllers;


import com.example.appnatprojetsession.Models.*;
import javafx.application.Platform;
import javafx.beans.Observable;
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
public class AdminController implements Initializable {

    //creerClient variables
    private static String nomC = "";
    private static String prenomC = "";
    private static String telephoneC = "";
    private static String courrielC = "";
    private static String nipC = "";

    //creerCompte variables
    private static int codeClient;
    private static String codeCli = "";
    private static String typeCompte = "";

    //bloquerCompte variables
    private static String statusClient = "";
    private static int codeClientSaisi;

    //ajouterArgentGuichet variables
    private static String montantAjouter = "";
    private static int montantAjouterAGuichet;
    GestionnaireGuichet gg = new GestionnaireGuichet();

    //preleverMontantGuichet
    private static String montantPreleve = "";
    private static int montantAPrel;

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

    // Creer_Compte & Afficher_Transaction & bloquer_Compte
    @FXML
    private TextField saisiCodeClient;
    @FXML
    private RadioButton radioEpargne, radioMargeDeCredit, radioHypothecaire, radioBloquer, radioDebloquer;

    //Ajouter_Argent_Guichet
    @FXML
    private TextField montantAjouterGuichet;

    //Prelevement_Hypothecaire
    @FXML
    public ComboBox<String> listComptesHypothecaires = new ComboBox<>();
    @FXML
    private TextField montantAPrelever;

    /**
     * Login avec enter
     *
     * @param ae
     * @throws IOException
     */
    @FXML
    public void onEnter(ActionEvent ae) throws IOException {
        back();
    }

    /**
     * MENU OPTION 1 - Redirection vers le menu Creer Client
     *
     * @throws IOException
     */
    public void creerClient() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/Admin/creerClient.fxml"));
        Scene first = menuAdmin.getScene();
        ((Stage) first.getWindow()).setTitle("Creation d'un client");
        ((Stage) first.getWindow()).setWidth(298);
        ((Stage) first.getWindow()).setHeight(416);
        ((Stage) first.getWindow()).centerOnScreen();
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
        ((Stage) first.getWindow()).setWidth(341);
        ((Stage) first.getWindow()).setHeight(369);
        ((Stage) first.getWindow()).centerOnScreen();
        first.setRoot(root);
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
        ((Stage) first.getWindow()).setWidth(406);
        ((Stage) first.getWindow()).setHeight(384);
        ((Stage) first.getWindow()).centerOnScreen();
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
        ((Stage) first.getWindow()).setWidth(385);
        ((Stage) first.getWindow()).setHeight(382);
        ((Stage) first.getWindow()).centerOnScreen();
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
        ((Stage) first.getWindow()).setWidth(402);
        ((Stage) first.getWindow()).setHeight(336);
        ((Stage) first.getWindow()).centerOnScreen();
        first.setRoot(root);
    }

    /**
     * MENU OPTION 6 - Payer de l'interet
     *
     * @throws IOException
     */
    public void payerInteret() throws IOException {
        Epargne epargne = new Epargne();
        for (int i = 0; i < gg.getComptesEpargne().size(); i++) {
            double solde = epargne.paiementInteret(gg.getComptesEpargne().get(i).getSoldeCompte());
            gg.getComptesEpargne().get(i).setSoldeCompte(solde);
        }
        Alert alert;
        if (gg.getComptesEpargne().size() == 0) {
            alert = new Alert(Alert.AlertType.ERROR, "Il existe aucun compte epargne");
        } else {
            alert = new Alert(Alert.AlertType.INFORMATION, "Un interet de 1% a ete attribue a tous les comptes epargnes");
        }
        alert.showAndWait();
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
        ((Stage) first.getWindow()).setWidth(414);
        ((Stage) first.getWindow()).setHeight(330);
        ((Stage) first.getWindow()).centerOnScreen();
        first.setRoot(root);
    }

    /**
     * MENU OPTION 8 - Augmenter le solde de 5%
     *
     * @throws IOException
     */
    public void augmenterSolde() throws IOException {

        Marge marge = new Marge();
        for (int i = 0; i < gg.getComptesMarge().size(); i++) {
            double solde = marge.augmenterSoldeMarge(gg.getComptesMarge().get(i).getSoldeCompte());
            gg.getComptesMarge().get(i).setSoldeCompte(solde);
            System.out.println(gg.getComptesMarge().get(i).getSoldeCompte());
        }

        Alert alert;
        if (gg.getComptesMarge().size() == 0) {
            alert = new Alert(Alert.AlertType.ERROR, "Il existe aucun compte marge");
        } else {
            alert = new Alert(Alert.AlertType.INFORMATION, "Une augmentation de 5% a ete attribue a tous les comptes marges");
        }
        alert.showAndWait();

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
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Le client " + nomClient.getText() + " " + prenomClient.getText() + "a ete creer");
        alert.showAndWait();
    }

    /**
     * Methodes qui sert a creer un compte pour un client
     *
     * @param actionEvent
     */
    public void creerCompte(ActionEvent actionEvent) {
        this.setSelectedButtons();

        if (codeCli.equalsIgnoreCase("") || typeCompte.equalsIgnoreCase("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "S.V.P. Remplir tous les champs");
            alert.showAndWait();
            return;
        } else {
            try {
                codeClient = Integer.parseInt(codeCli);
                //System.out.println("codeClient:"+ codeClient+" type Compte:"+ typeCompte);
            } catch (Exception e) {
                //System.out.println(e);
                Alert alert = new Alert(Alert.AlertType.ERROR, "Le code du client doit etre des numeros");
                alert.showAndWait();
                return;
            }
            ArrayList<Client> clients = gg.getClients();
            for (Client c : clients) {
                if (c.getCodeClient() == codeClient) {
                    if(typeCompte.equalsIgnoreCase("Marge de crédit")){
                        ArrayList<Marge> margeList = gg.getComptesMarge();
                        for (Marge m: margeList) {
                            if(m.getCodeClient() == c.getCodeClient()){
                                Alert alert = new Alert(Alert.AlertType.ERROR, "le client " + codeClient + " possede deja un compte de marge, un client " +
                                        "peut seulement avoir un compte de marge de credit");
                                alert.showAndWait();
                                return;
                            }
                        }
                    }
                    gg.creerCompte(typeCompte, c.getNumeroNIP(), c.getCodeClient());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Le compte " + typeCompte + " pour le client " + codeClient + " a ete creer");
                    alert.showAndWait();
                    return;
                }
            }
            Alert alert = new Alert(Alert.AlertType.ERROR, "le client " + codeClient + " n'existe pas");
            alert.showAndWait();
        }
    }

    /**
     * Methode qui sert a savoir quelle compte on a choisi de creer
     */
    public void setSelectedButtons() {
        codeCli = saisiCodeClient.getText();
        if (radioEpargne.isSelected()) {
            typeCompte = radioEpargne.getText();
        } else if (radioMargeDeCredit.isSelected()) {
            typeCompte = radioMargeDeCredit.getText();
        } else if (radioHypothecaire.isSelected()) {
            typeCompte = radioHypothecaire.getText();
        }
    }

    /**
     * Methodes qui sert a afficher les transactions du clients
     *
     * @param actionEvent
     */
    public void afficherTransaction(ActionEvent actionEvent) {
        this.setSelectedButtons();

        if (codeCli.equalsIgnoreCase("") || typeCompte.equalsIgnoreCase("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "S.V.P. Remplir tous les champs");
            alert.showAndWait();
            return;
        } else {
            try {
                codeClient = Integer.parseInt(codeCli);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Le code du client doit etre des numeros");
                alert.showAndWait();
                return;
            }
            ArrayList<Client> clients = gg.getClients();
            ArrayList<Transaction> transactions = gg.getTransactions();
            ArrayList<Transaction> transactionsClient = new ArrayList<Transaction>();
            for (Client c : clients) {
                if (c.getCodeClient() == codeClient) {
                    for (Transaction t : transactions) {
                        if (t.getCompte().getCodeClient() == c.getCodeClient()) {
                            if (t.getType() == "Épargne") {
                                transactions.add(t);
                            } else if (t.getType() == "Hypothécaire") {
                                transactions.add(t);
                            } else if (t.getType() == "Marge de crédit") {
                                transactions.add(t);
                            }
                        }
                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Voici la liste des clients:\n" + transactions);
                    alert.showAndWait();
                    return;
                }
            }
            Alert alert = new Alert(Alert.AlertType.ERROR, "le client " + codeClient + " n'existe pas");
            alert.showAndWait();
        }
    }

    /**
     * Methodes qui sert a bloquer ou debloquer un client
     *
     * @param actionEvent
     */
    public void blockClient(ActionEvent actionEvent) {
        codeCli = saisiCodeClient.getText();
        if (radioBloquer.isSelected()) {
            statusClient = radioBloquer.getText();
        } else if (radioDebloquer.isSelected()) {
            statusClient = radioDebloquer.getText();
        }

        if (codeCli.equalsIgnoreCase("") || statusClient.equalsIgnoreCase("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "S.V.P. Remplir tous les champs");
            alert.showAndWait();
            return;
        } else {
            try {
                codeClientSaisi = Integer.parseInt(codeCli);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Le code du client doit etre des numeros");
                alert.showAndWait();
                return;
            }
            ArrayList<Client> clients = gg.getClients();
            ArrayList<Integer> listClientBloques = gg.getClientBloque();
            for (Integer i : listClientBloques) {
                System.out.println(i.toString());
            }
            for (Client c : clients) {
                System.out.println("test 1");

                if (c.getCodeClient() == codeClientSaisi) {
                    if (statusClient.equalsIgnoreCase("Bloquer")) {
                        for (Integer cli : listClientBloques) {
                            if (cli == c.getCodeClient()) {
                                Alert alert = new Alert(Alert.AlertType.ERROR, "Le Client " + codeClientSaisi + " est deja bloquee ");
                                alert.showAndWait();
                                return;
                            }
                        }
                        gg.bloquerClient(codeClientSaisi);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Le Client " + codeClientSaisi + " a ete bloque");
                        alert.showAndWait();
                        return;
                    } else if (statusClient.equalsIgnoreCase("Débloquer")) {
                        for (Integer cli : listClientBloques) {
                            if (cli == c.getCodeClient()) {
                                gg.debloquerClient(cli);
                                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Le Client " + codeClientSaisi + " a ete debloque");
                                alert.showAndWait();
                                return;
                            }
                        }
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Le Client " + codeClientSaisi + " est deja debloque ");
                        alert.showAndWait();
                        return;
                    }
                }
            }
            Alert alert = new Alert(Alert.AlertType.ERROR, "le client " + codeClientSaisi + " n'existe pas");
            alert.showAndWait();
        }
    }

    /**
     * Methode qui sert ajouter de largent dans le guichet
     *
     * @param actionEvent
     */
    public void AjouterArgentGuichet(ActionEvent actionEvent) {
        montantAjouter = montantAjouterGuichet.getText();
        if (montantAjouter.equalsIgnoreCase("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "S.V.P. Remplir tous les champs");
            alert.showAndWait();
            return;
        } else {
            try {
                montantAjouterAGuichet = Integer.parseInt(montantAjouter);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Il faut saisir un montant en chiffre a ajouter dans le guichet");
                alert.showAndWait();
                return;
            }
        }

        int modulo = montantAjouterAGuichet % 10;
        if (modulo != 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Il faut ajouter un montant qui est un  multiple de 10 dans le guichet");
            alert.showAndWait();
            return;
        } else {
            double montantDansGuichet = gg.getBanque().getSoldeCompte();
            System.out.println(montantDansGuichet);
            double montantTotal = montantDansGuichet + montantAjouterAGuichet;
            if (montantTotal > 20000) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Le montant dans le guichet ne peut pas exceder 20,000$");
                alert.showAndWait();
                return;
            } else {
                gg.getBanque().remplirGuichet(montantAjouterAGuichet);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Un montant de " + montantAjouterAGuichet + "$ dans le guichet.\n Le solde courant du guichet est de " + montantTotal + " $.");
                alert.showAndWait();
                return;
            }
        }

    }

    public void prelevementHypothecaire(ActionEvent actionEvent) {
        montantPreleve = montantAPrelever.getText();
        String compteChoisi = this.listComptesHypothecaires.getSelectionModel().getSelectedItem();
        String[] listString = compteChoisi.split("Compte ID:");
        String[] listString2 = listString[1].split(" ");
        String idCompte = listString2[1];
        System.out.println(idCompte);

        if(idCompte.equalsIgnoreCase("") || montantPreleve.equalsIgnoreCase("")){
            Alert alert = new Alert(Alert.AlertType.ERROR, "S.V.P. Remplir tous les champs");
            alert.showAndWait();
            return;
        }else{
            int idCompteHypothecaire;
            try {
                montantAPrel = Integer.parseInt(montantPreleve);
                idCompteHypothecaire = Integer.parseInt(idCompte);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Il faut saisir un montant en chiffre a ajouter dans le guichet");
                alert.showAndWait();
                return;
            }

            ArrayList<Hypothécaire> listHypothecaire = gg.getComptesHypothecaire();
            ArrayList<Marge> listMarge = gg.getComptesMarge();
            int codeCli;
            for (Hypothécaire h: listHypothecaire) {
                if(idCompteHypothecaire == h.getNumeroCompte()){
                   codeCli = h.getCodeClient();
                   if(montantAPrel > h.getSoldeCompte()){
                       for (Marge m: listMarge) {
                           if(m.getCodeClient() == codeCli){
                               double debt = montantAPrel - h.getSoldeCompte();
                               m.setSoldeCompte(m.getSoldeCompte() + debt);
                               Alert alert = new Alert(Alert.AlertType.INFORMATION, "Le Client du compte Hypothecaire ne possedait pas un solde suffissant," +
                                       "un montant de"+ debt+ " $ a ete ajoute a son compte de credit." );
                               alert.showAndWait();
                               return;
                           }
                       }
                       Alert alert = new Alert(Alert.AlertType.ERROR, "Le montant desire de prelever depasse le solde du compte hypothecaire et le client ne" +
                               "possede pas de compte marge de credit pour augmenter le credit");
                       alert.showAndWait();
                       return;
                   }else{
                       h.setSoldeCompte(h.getSoldeCompte() - montantAPrel);
                       Alert alert = new Alert(Alert.AlertType.INFORMATION, "Le compte du Client Hypothecaire choisi sait fait retire un montant de "+ montantAPrel+
                               " $ et sa nouvelle balance dans son compte hypothecaire est de "+h.getSoldeCompte() +" $.");
                       alert.showAndWait();
                       return;
                   }
                }
            }
        }
    }


    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Hypothécaire> listHypotechaire = gg.getComptesHypothecaire();
        ObservableList<String> comptesHypotechaires = FXCollections.observableArrayList();
        System.out.println(listHypotechaire);

        for (Hypothécaire h : listHypotechaire) {
            String txt = h.getClass().toString();
            String[] split = txt.split("\\.");
            txt = split[4] + " , Compte ID: " + (h.getNumeroCompte()) + " Solde: " + (h.getSoldeCompte());
            comptesHypotechaires.add(txt);
        }
        this.listComptesHypothecaires.setItems(comptesHypotechaires);
        System.out.println(comptesHypotechaires);
    }

    /**
     * Methode qui sert a afficher la liste des clients
     */
    public void afficherClients() {
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
        ((Stage) first.getWindow()).setWidth(554);
        ((Stage) first.getWindow()).setHeight(333);
        ((Stage) first.getWindow()).centerOnScreen();
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
        ((Stage) first.getWindow()).setWidth(551);
        ((Stage) first.getWindow()).setHeight(359);
        ((Stage) first.getWindow()).centerOnScreen();
        first.setRoot(root);
    }
}

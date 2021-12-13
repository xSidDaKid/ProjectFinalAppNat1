package com.example.appnatprojetsession.Controllers;


import com.example.appnatprojetsession.Models.Client;
import com.example.appnatprojetsession.Models.GestionnaireGuichet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
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
    //Login
    @FXML
    TextField code;
    @FXML
    TextField nip;
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
    //Deconnexion
    @FXML
    Label creation;
    @FXML
    Label creationCompte;

    /**
     * Login avec enter
     *
     * @param ae
     * @throws IOException
     */
    @FXML
    public void onEnter(ActionEvent ae) throws IOException {
        Login();
    }

    public void Login() throws IOException {

        codeUtilisateur = code.getText();
        nipUtilisateur = nip.getText();
        System.out.println(codeUtilisateur + " " + nipUtilisateur);

        if (codeUtilisateur.trim().equalsIgnoreCase("") || nipUtilisateur.equalsIgnoreCase("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "S.V.P. Remplir tous les champs");
            alert.showAndWait();
        } else if (codeUtilisateur.equalsIgnoreCase("admin") && nipUtilisateur.equalsIgnoreCase("0000")) {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/Admin/menuAdmin.fxml"));
            Scene first = code.getScene();
            ((Stage) first.getWindow()).setTitle("Admin");
            first.setRoot(root);
        } else {
            int codeCli = 0, nip = 0;
            try {
                codeCli = Integer.parseInt(codeUtilisateur);
                nip = Integer.parseInt(nipUtilisateur);
            } catch (Exception e) {
                System.out.println(e);
                Alert alert = new Alert(Alert.AlertType.ERROR, "S.V.P. Entrez des numeros");
                alert.showAndWait();
                return;
            }
//            System.out.println(codeCli);
//            System.out.println(nip);
            Client client = new Client(codeCli, nip);
            GestionnaireGuichet gg = new GestionnaireGuichet();
            ArrayList<Client> clients = gg.getClients();
            System.out.println("HERE 1");
            //System.out.println(clients);
            for (Client c : clients) {
                //System.out.println("HERE 2");
                if (client.getCodeClient() == c.getCodeClient()) {
                    if (c.getNumeroNIP() == client.getNumeroNIP()) {
                        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/User/menuUser.fxml"));
                        Scene first = code.getScene();
                        ((Stage) first.getWindow()).setTitle("Admin");
                        first.setRoot(root);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING, "Client non trouvable");
                        alert.showAndWait();
                    }
                }
            }
        }
    }

    public void creerClient() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/Admin/creerClient.fxml"));
        Scene first = menuAdmin.getScene();
        ((Stage) first.getWindow()).setTitle("Creation d'un client");
        first.setRoot(root);
    }

    public void infoClient() {
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


        System.out.println("Nom: " + nomC + "\nPrenom: " + prenomC + "\nTelephone: " + telephoneC + "\nCourriel: " + courrielC + "\nNIP: " + nip);

        gg.creerClient(nomC, prenomC, telephoneC, courrielC, nip);
        GestionnaireGuichet gg = new GestionnaireGuichet();
        System.out.println(gg.getClients());
    }

    public void creerCompteClient() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/Admin/creerCompte.fxml"));
        Scene first = menuAdmin.getScene();
        ((Stage) first.getWindow()).setTitle("Creation d'un compte pour le client");
        first.setRoot(root);
        gg.creerCheque();
    }

    public void back() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/Admin/menuAdmin.fxml"));
        Scene first = null;

        if ((menuAdmin) != null) {
            first = menuAdmin.getScene();
        } else if (creation != null) {
            first = creation.getScene();
        }else if (creationCompte != null) {
            first = creationCompte.getScene();
        }

        ((Stage) first.getWindow()).setTitle("Login");
        first.setRoot(root);
    }

    public void deconnexion() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/LoginMenu.fxml"));
        Scene first = null;

        if ((menuAdmin) != null) {
            first = menuAdmin.getScene();
        } else if (creation != null) {
            first = creation.getScene();
        }else if (creationCompte != null) {
            first = creationCompte.getScene();
        }

        ((Stage) first.getWindow()).setTitle("Login");
        first.setRoot(root);
    }
}

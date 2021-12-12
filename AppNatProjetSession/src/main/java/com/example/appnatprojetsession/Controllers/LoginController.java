package com.example.appnatprojetsession.Controllers;

import com.example.appnatprojetsession.Models.GestionnaireGuichet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class LoginController extends GestionnaireGuichet {

    public static String codeUtilisateur = "";
    public static String nipUtilisateur = "";
    public static String nomC = "";
    public static String prenomC = "";
    public static String telephoneC = "";
    public static String courrielC = "";
    public static String nipC = "";
    public int compteur = 1;
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

    /**
     * Login avec enter
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


        if (codeUtilisateur.equalsIgnoreCase("admin") && nipUtilisateur.equalsIgnoreCase("admin")) {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/Admin/menuAdmin.fxml"));
            Scene first = code.getScene();
            ((Stage) first.getWindow()).setTitle("Admin");
            first.setRoot(root);
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

        System.out.println("Nom: " + nomC + "\nPrenom: " + prenomC + "\nTelephone: " + telephoneC + "\nCourriel: " + courrielC + "\nNIP: " + nipC);

        gg.creerClient(this.compteur, nomC, prenomC, telephoneC, courrielC, nipC);
        this.compteur++;
    }
}

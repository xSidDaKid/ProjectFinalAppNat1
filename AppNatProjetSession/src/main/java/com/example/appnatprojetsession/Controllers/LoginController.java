package com.example.appnatprojetsession.Controllers;

<<<<<<< HEAD
import com.example.appnatprojetsession.Models.GestionnaireGuichet;
import javafx.event.ActionEvent;
=======
import com.example.appnatprojetsession.Models.Client;
import com.example.appnatprojetsession.Models.GestionnaireGuichet;
>>>>>>> devModel
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
<<<<<<< HEAD
import javafx.scene.control.Label;
=======
import javafx.scene.control.Alert;
>>>>>>> devModel
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

<<<<<<< HEAD
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
=======
>>>>>>> devModel
    @FXML
    TextField code;
    @FXML
    TextField nip;
<<<<<<< HEAD
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
    @FXML
    Label creation;

    /**
     * Login avec enter
     * @param ae
     * @throws IOException
     */
    @FXML
    public void onEnter(ActionEvent ae) throws IOException {
        Login();
    }
=======

    public static String codeUtilisateur = "";
    public static String nipUtilisateur = "";
>>>>>>> devModel

    public void Login() throws IOException {

        codeUtilisateur = code.getText();
        nipUtilisateur = nip.getText();
        System.out.println(codeUtilisateur + " " + nipUtilisateur);

<<<<<<< HEAD

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

    public void deconnexion() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/LoginMenu.fxml"));
        Scene first = null;

        if ((menuAdmin) != null) {
            first = menuAdmin.getScene();
        }else if (creation.getScene() != null) {
            first = creation.getScene();
        }


        ((Stage) first.getWindow()).setTitle("Login");
        first.setRoot(root);
=======
        if(codeUtilisateur.trim().equalsIgnoreCase("") || nipUtilisateur.equalsIgnoreCase("")){
            Alert alert = new Alert(Alert.AlertType.ERROR, "S.V.P. Remplir tous les champs");
            alert.showAndWait();
        }
        else if (codeUtilisateur.equalsIgnoreCase("admin") && nipUtilisateur.equalsIgnoreCase("0000")){
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/Admin/menuAdmin.fxml"));
            Scene first = code.getScene();
            ((Stage)first.getWindow()).setTitle("Admin");
            first.setRoot(root);
        }
        else {
            int codeCli = 0, nip = 0;
            try{
                codeCli = Integer.parseInt(codeUtilisateur);
                nip = Integer.parseInt(nipUtilisateur);
            }catch(Exception e){
                System.out.println(e);
                Alert alert = new Alert(Alert.AlertType.ERROR, "S.V.P. Entrez des numeros");
                alert.showAndWait();
                return;
            }
//            System.out.println(codeCli);
//            System.out.println(nip);
            Client client = new Client(codeCli, nip);
            GestionnaireGuichet gg = new GestionnaireGuichet();

            for (Client c: gg.getClients()
                 ) {
                if(c.getNumeroNIP() == client.getNumeroNIP()){
                    if(c.getNumeroNIP() == client.getNumeroNIP()){
                        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/User/menuUser.fxml"));
                        Scene first = code.getScene();
                        ((Stage)first.getWindow()).setTitle("Admin");
                        first.setRoot(root);
                    }
                    else{
                        Alert alert = new Alert(Alert.AlertType.WARNING, "Client non trouvable");
                        alert.showAndWait();
                    }
                }
            }
        }
>>>>>>> devModel
    }
}

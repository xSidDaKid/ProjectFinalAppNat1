package com.example.appnatprojetsession.Controllers;

import com.example.appnatprojetsession.Models.GestionnaireGuichet;
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

    @FXML
    TextField code;
    @FXML
    TextField nip;
    @FXML
    Label menuAdmin;

    public static String codeUtilisateur = "";
    public static String nipUtilisateur = "";

    public void Login() throws IOException {

        codeUtilisateur = code.getText();
        nipUtilisateur = code.getText();
        System.out.println(codeUtilisateur + " " + nipUtilisateur);


        if (codeUtilisateur.equalsIgnoreCase("admin") && codeUtilisateur.equalsIgnoreCase("admin")){
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/Admin/menuAdmin.fxml"));
            Scene first = code.getScene();
            ((Stage)first.getWindow()).setTitle("Admin");
            first.setRoot(root);
        }
    }

    public void creerClient() throws IOException {
        System.out.println("allo");
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/Admin/creerClient.fxml"));
        Scene first = menuAdmin.getScene();
        ((Stage)first.getWindow()).setTitle("Creation d'un client");
        first.setRoot(root);
    }
}

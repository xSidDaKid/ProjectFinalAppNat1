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
public class LoginController {

    public static String codeUtilisateur = "";
    public static String nipUtilisateur = "";
    //Login
    @FXML
    TextField code;
    @FXML
    TextField nip;
    GestionnaireGuichet gg = new GestionnaireGuichet();
    @FXML
    private Label nomUser;

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

    /**
     * Methode qui sert a se connecter en tant que Administrateur ou Client
     *
     * @throws IOException
     */
    public void Login() throws IOException {

        codeUtilisateur = code.getText();
        nipUtilisateur = nip.getText();

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

            ArrayList<Integer> comptesBloques = gg.getClientBloque();
            for(Integer i: comptesBloques){
                if(i == codeCli){
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Votre compte a ete bloque, S.V.P., contacter votre banque pour plus d'information.");
                    alert.showAndWait();
                    return;
                }
            }

            Client client = new Client(codeCli, nip);
            ArrayList<Client> clients = gg.getClients();
            System.out.println("HERE 1");
            for (Client c : clients) {
                if (client.getCodeClient() == c.getCodeClient()) {
                    if (c.getNumeroNIP() == client.getNumeroNIP()) {
                        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/User/menuUser.fxml"));
                        Scene first = code.getScene();
                        ((Stage) first.getWindow()).setTitle("Client");
                        ((Stage) first.getWindow()).setWidth(582);
                        ((Stage) first.getWindow()).setHeight(311);
                        ((Stage) first.getWindow()).centerOnScreen();
                        first.setRoot(root);
                        ((Label) first.lookup("#nomUser")).setText("Bonjour " + c.getNom() + " " + c.getPrenom());
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING, "Client non trouvable");
                        alert.showAndWait();
                    }
                }
            }
        }
    }
}

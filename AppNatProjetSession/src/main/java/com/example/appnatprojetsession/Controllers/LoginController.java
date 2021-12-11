package com.example.appnatprojetsession.Controllers;

import com.example.appnatprojetsession.Models.Client;
import com.example.appnatprojetsession.Models.GestionnaireGuichet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

    public static String codeUtilisateur = "";
    public static String nipUtilisateur = "";

    public void Login() throws IOException {

        codeUtilisateur = code.getText();
        nipUtilisateur = nip.getText();
        System.out.println(codeUtilisateur + " " + nipUtilisateur);

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
            int code = 0, nip = 0;
            try{
                code = Integer.parseInt(codeUtilisateur);
                nip = Integer.parseInt(nipUtilisateur);
            }catch(Exception e){
                System.out.println(e);
                Alert alert = new Alert(Alert.AlertType.ERROR, "S.V.P. Entrez des numeros");
                alert.showAndWait();
                return;
            }
//            System.out.println(code);
//            System.out.println(nip);
            Client client = new Client(code, nip);
            GestionnaireGuichet gg = new GestionnaireGuichet();

            for (Client c: gg.getClients()
                 ) {
                if(c.getNumeroNIP() == client.getNumeroNIP()){
                    if(c.getNumeroNIP() == client.getNumeroNIP()){
//                        Parent root = FXMLLoader.load(getClass().getResource("/com/example/appnatprojetsession/Admin/menuAdmin.fxml"));
//                        Scene first = code.getScene();
//                        ((Stage)first.getWindow()).setTitle("Admin");
//                        first.setRoot(root);
                    }
                    else{
                        Alert alert = new Alert(Alert.AlertType.WARNING, "Client non trouvable");
                        alert.showAndWait();
                    }
                }
            }
        }
    }
}

package com.example.appnatprojetsession;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginMenu.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/appnatprojetsession/Admin/menuAdmin.fxml"));// Pour faciliter le test des menus admin
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
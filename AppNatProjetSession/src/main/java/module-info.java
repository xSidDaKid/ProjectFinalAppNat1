module com.example.appnatprojetsession {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.appnatprojetsession to javafx.fxml;
    exports com.example.appnatprojetsession;
    exports com.example.appnatprojetsession.Controllers;
    opens com.example.appnatprojetsession.Controllers to javafx.fxml;
    exports com.example.appnatprojetsession.Models;
    opens com.example.appnatprojetsession.Models to javafx.fxml;
}
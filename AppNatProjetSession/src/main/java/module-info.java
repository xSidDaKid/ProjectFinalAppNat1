module com.example.appnatprojetsession {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.appnatprojetsession to javafx.fxml;
    exports com.example.appnatprojetsession;
}
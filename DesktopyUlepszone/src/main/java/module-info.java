module com.example.desktopyulepszone {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.desktopyulepszone to javafx.fxml;
    exports com.example.desktopyulepszone;
}
module com.example.trojkat_i_kropka {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.trojkat_i_kropka to javafx.fxml;
    exports com.example.trojkat_i_kropka;
}
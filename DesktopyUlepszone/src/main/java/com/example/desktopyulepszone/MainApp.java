package com.example.desktopyulepszone;

import com.example.desktopyulepszone.AplikacjaDziennika;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AplikacjaDziennika aplikacjaDziennika = new AplikacjaDziennika();
        Scene scene = new Scene(aplikacjaDziennika.stworzZawartosc(), 800, 600);

        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.setMaxWidth(600);
        primaryStage.setMaxHeight(400);

        primaryStage.setTitle("Dziennik Elektroniczny");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

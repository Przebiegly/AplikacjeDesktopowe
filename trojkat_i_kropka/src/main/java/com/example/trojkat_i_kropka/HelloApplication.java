package com.example.trojkat_i_kropka;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Path path = new Path();

        MoveTo moveTo = new MoveTo(108, 71);

        LineTo line1 = new LineTo(321, 161);

        LineTo line2 = new LineTo(126,232);

        LineTo line3 = new LineTo(232,52);

        LineTo line4 = new LineTo(269, 250);

        LineTo line5 = new LineTo(108, 71);

        Circle circle = new Circle(220, 150, 25);

        path.getElements().add(moveTo);
        path.getElements().addAll(line1, line2, line3, line4, line5);

        Group root = new Group(path);

        root.getChildren().add(circle);

        Scene scene = new Scene(root, 600, 300);


        stage.setTitle("Bartosz Lauer");

        stage.setScene(scene);

        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
package com.example.desktopyulepszone;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Blok extends StackPane {

    private StringProperty identyfikatorBloku;
    private DaneBloku daneBloku;

    private static final int LICZBA_KOLUMN = 7;

    public Blok(String identyfikatorBloku, DaneBloku daneBloku) {
        this.identyfikatorBloku = new SimpleStringProperty(identyfikatorBloku);
        this.daneBloku = daneBloku;
        inicjalizujBlok();
    }

    private void inicjalizujBlok() {
        Label label = stworzlabel();

        int wiersz = pobierzWierszZIdentyfikatoraBloku();
        int kolumna = pobierzKolumneZIdentyfikatoraBloku();

        if (wiersz > 0 && kolumna == 1) {
            CheckBox checkBox = stworzCheckBox();
            getChildren().add(checkBox);
        } else {
            getChildren().add(label);
        }

        zaktualizujWygladBloku();
    }


    private CheckBox stworzCheckBox() {
        CheckBox checkBox = new CheckBox();
        return checkBox;
    }
    private Label stworzlabel() {
        Label label = new Label();
        return label;
    }

    private void zaktualizujWygladBloku() {
        int wiersz = pobierzWierszZIdentyfikatoraBloku();
        int kolumna = pobierzKolumneZIdentyfikatoraBloku();

        int indeks = wiersz * LICZBA_KOLUMN + kolumna;

        //tu byly lekka pomoc osoby 3
        if (czyIndeksPoprawny(indeks)) {
            String tresc = daneBloku.getBloki().get(indeks).getTresc();

            Node childNode = getChildren().get(0);

            if (childNode instanceof Label) {
                Label label = (Label) childNode;
                label.setText(tresc);
            } else if (childNode instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) childNode;
                checkBox.setSelected(daneBloku.getBloki().get(indeks).isCzyZaznaczone());
            } else {
                System.err.println("Unexpected node type at index: " + wiersz + ", " + kolumna);
            }
        } else {
            System.err.println("Indeks poza zakresem: " + wiersz + ", " + kolumna);
        }
    }





    private boolean czyIndeksPoprawny(int indeks) {
        return indeks >= 0 && indeks < daneBloku.getBloki().size();
    }


    private int pobierzWierszZIdentyfikatoraBloku() {
        Matcher matcher = Pattern.compile("r(\\d+)c\\d+").matcher(identyfikatorBloku.get());
        return matcher.matches() ? Integer.parseInt(matcher.group(1)) : -1;
    }

    private int pobierzKolumneZIdentyfikatoraBloku() {
        Matcher matcher = Pattern.compile("r\\d+c(\\d+)").matcher(identyfikatorBloku.get());
        return matcher.matches() ? Integer.parseInt(matcher.group(1)) : -1;
    }
}

package com.example.desktopyulepszone;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AplikacjaDziennika {

    private GridPane siatka;
    private DaneBloku daneBloku;

    public AplikacjaDziennika() {
        siatka = new GridPane();
        daneBloku = new DaneBloku();
        inicjalizujDaneBloku();
    }

    private void inicjalizujDaneBloku() {
        wczytajZCSV("test.csv");
    }

    private void wczytajZCSV(String sciezkaPliku) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/com/example/desktopyulepszone/test.csv")))   {
            String linia;
            List<DaneBlok> listaBloku = new ArrayList<>();
            int numerWiersza = 0;
            while ((linia = br.readLine()) != null) {
                String[] czesci = linia.split(",");
                for (String tresc : czesci) {
                    listaBloku.add(new DaneBlok(tresc));
                }

                if (numerWiersza > 0) {
                    for (int i = 0; i < czesci.length; i++) {
                        String value = czesci[i].trim();
                        boolean czyZaznaczone = "true".equalsIgnoreCase(value);
                        listaBloku.get((numerWiersza) * czesci.length + i).setCzyZaznaczone(czyZaznaczone);
                    }
                }

                numerWiersza++;
            }
            daneBloku.ustawBloki(listaBloku);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public GridPane stworzZawartosc() {
        siatka.setAlignment(Pos.CENTER);
        siatka.setHgap(0);
        siatka.setVgap(0);
        siatka.setPadding(new Insets(1));
//        siatka.setBorder(Border.stroke(Color.BLACK));


        ColumnConstraints[] kolumnoweOgraniczenia = new ColumnConstraints[DaneBloku.LICZBA_KOLUMN];
        for (int i = 0; i < DaneBloku.LICZBA_KOLUMN; i++) {
            ColumnConstraints kolumna = new ColumnConstraints();
            kolumna.setPercentWidth(i == 0 ? 26.0 : i == 1 ? 18.0 : i == 4 ? 20.0 : 9.0);
            kolumnoweOgraniczenia[i] = kolumna;
        }
        siatka.getColumnConstraints().addAll(kolumnoweOgraniczenia);

        RowConstraints[] wierszoweOgraniczenia = new RowConstraints[DaneBloku.LICZBA_WIERSZY];
        for (int i = 0; i < DaneBloku.LICZBA_WIERSZY; i++) {
            RowConstraints wierszoweOgraniczenie = new RowConstraints();
            wierszoweOgraniczenie.setPercentHeight(100.0 / DaneBloku.LICZBA_WIERSZY);
            wierszoweOgraniczenia[i] = wierszoweOgraniczenie;
        }
        siatka.getRowConstraints().addAll(wierszoweOgraniczenia);

        for (int wiersz = 0; wiersz < DaneBloku.LICZBA_WIERSZY; wiersz++) {
            for (int kolumna = 0; kolumna < DaneBloku.LICZBA_KOLUMN; kolumna++) {
                Blok blok = new Blok("r" + wiersz + "c" + kolumna, daneBloku);
                if ((kolumna == 2 || kolumna == 3 || kolumna == 5 || kolumna == 6) && wiersz == 0) {
                    GridPane.setColumnSpan(blok, 2);
                    siatka.add(blok, kolumna, wiersz);
                    blok.setBorder(Border.stroke(Color.BLACK));
                    kolumna++;
                } else {
                    siatka.add(blok, kolumna, wiersz);
                    blok.setBorder(Border.stroke(Color.BLACK));
                }
            }
        }





        return siatka;
    }
}

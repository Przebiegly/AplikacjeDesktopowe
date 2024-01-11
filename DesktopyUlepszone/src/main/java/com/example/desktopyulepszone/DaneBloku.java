package com.example.desktopyulepszone;

import java.util.ArrayList;
import java.util.List;

public class DaneBloku {
    public static final int LICZBA_WIERSZY = 14;
    public static final int LICZBA_KOLUMN = 7;

    private List<DaneBlok> bloki;

    public DaneBloku() {
        bloki = new ArrayList<>();
    }

    public List<DaneBlok> getBloki() {
        return bloki;
    }

    public void ustawBloki(List<DaneBlok> bloki) {
        this.bloki = bloki;
    }
}

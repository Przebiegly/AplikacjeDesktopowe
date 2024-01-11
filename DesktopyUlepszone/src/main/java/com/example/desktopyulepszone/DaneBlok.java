package com.example.desktopyulepszone;

public class DaneBlok {
    private String tresc;
    private boolean czyZaznaczone;

    public DaneBlok(String tresc) {
        this.tresc = tresc;
    }

    public String getTresc() {
        return tresc;
    }

    public boolean isCzyZaznaczone() {
        return czyZaznaczone;
    }

    public void setCzyZaznaczone(boolean czyZaznaczone) {
        this.czyZaznaczone = czyZaznaczone;
    }
}

package com.example.amar.proektnizadatakrma;

/**
 * Created by Amar on 31.03.2017..
 */

public class Reziser {
        String ime,prezime,godiste,mjestoRodenja;

    public Reziser(String ime, String prezime, String godiste, String mjestoRodenja) {
        this.ime = ime;
        this.prezime = prezime;
        this.godiste = godiste;
        this.mjestoRodenja = mjestoRodenja;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getGodiste() {
        return godiste;
    }

    public void setGodiste(String godiste) {
        this.godiste = godiste;
    }

    public String getMjestoRodenja() {
        return mjestoRodenja;
    }

    public void setMjestoRodenja(String mjestoRodenja) {
        this.mjestoRodenja = mjestoRodenja;
    }
}

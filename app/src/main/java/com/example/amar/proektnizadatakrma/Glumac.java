package com.example.amar.proektnizadatakrma;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by Amar on 31.03.2017..
 */

public class Glumac {
    String ime,prezime,godinaRodenja,mjestoRodenja,spol,link,biografija,rating;

    public Glumac(String ime, String prezime, String godinaRodenja, String mjestoRodenja, String spol, String link, String biografija, String rating) {
        this.ime = ime;
        this.prezime = prezime;
        this.godinaRodenja = godinaRodenja;
        this.mjestoRodenja = mjestoRodenja;
        this.spol = spol;
        this.link = link;
        this.biografija = biografija;
        this.rating = rating;
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

    public String getGodinaRodenja() {
        return godinaRodenja;
    }

    public void setGodinaRodenja(String godinaRodenja) {
        this.godinaRodenja = godinaRodenja;
    }

    public String getMjestoRodenja() {
        return mjestoRodenja;
    }

    public void setMjestoRodenja(String mjestoRodenja) {
        this.mjestoRodenja = mjestoRodenja;
    }

    public String getSpol() {
        return spol;
    }

    public void setSpol(String spol) {
        this.spol = spol;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getBiografija() {
        return biografija;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}

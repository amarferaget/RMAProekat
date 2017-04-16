package com.example.amar.proektnizadatakrma;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

/**
 * Created by Amar on 31.03.2017..
 */

public class Glumac implements Parcelable{

    private String ime,prezime,godinaRodenja,mjestoRodenja,spol,link,biografija,rating;

    public Glumac(){}

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

    protected Glumac(Parcel in)
    {
        ime=in.readString();
        prezime=in.readString();
        godinaRodenja=in.readString();
        mjestoRodenja=in.readString();
        spol=in.readString();
        link=in.readString();
        biografija=in.readString();
        rating=in.readString();
    }

    public static final Creator<Glumac> CREATOR=new Creator<Glumac>() {
        @Override
        public Glumac createFromParcel(Parcel source) {
            return new Glumac(source);
        }

        @Override
        public Glumac[] newArray(int size) {
            return new Glumac[size];
        }
    };

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

    @Override
    public int describeContents() {return  0;}

    @Override
    public void writeToParcel(Parcel dest,int flags)
    {
        dest.writeString(ime);
        dest.writeString(prezime);
        dest.writeString(godinaRodenja);
        dest.writeString(mjestoRodenja);
        dest.writeString(spol);
        dest.writeString(link);
        dest.writeString(biografija);
        dest.writeString(rating);
    }
}

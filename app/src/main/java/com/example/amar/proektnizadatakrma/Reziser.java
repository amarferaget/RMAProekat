package com.example.amar.proektnizadatakrma;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amar on 31.03.2017..
 */

public class Reziser implements Parcelable{

        String ime,prezime,godiste,mjestoRodenja;

    public Reziser(){}

    public Reziser(String ime, String prezime, String godiste, String mjestoRodenja) {
        this.ime = ime;
        this.prezime = prezime;
        this.godiste = godiste;
        this.mjestoRodenja = mjestoRodenja;
    }

    protected Reziser(Parcel in)
    {
        ime=in.readString();
        prezime=in.readString();
        godiste=in.readString();
        mjestoRodenja=in.readString();
    }

    public static final Creator<Reziser> CREATOR=new Creator<Reziser>() {
        @Override
        public Reziser createFromParcel(Parcel source) {
            return new Reziser(source);
        }

        @Override
        public Reziser[] newArray(int size) {
            return new Reziser[size];
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

    @Override
    public int describeContents() {return  0;}

    @Override
    public void writeToParcel(Parcel dest,int flags)
    {
        dest.writeString(ime);
        dest.writeString(prezime);
        dest.writeString(godiste);
        dest.writeString(mjestoRodenja);
    }

}

package com.example.amar.proektnizadatakrma;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amar on 15.04.2017..
 */

public class Zanr implements Parcelable {
    private String naziv;

    public Zanr(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    protected Zanr(Parcel in)
    {
        naziv=in.readString();
    }

    public static final Creator<Zanr> CREATOR=new Creator<Zanr>() {
        @Override
        public Zanr createFromParcel(Parcel source) {
            return new Zanr(source);
        }

        @Override
        public Zanr[] newArray(int size) {
            return new Zanr[size];
        }
    };

    public int  describeContents() {return 0;}

    public void writeToParcel(Parcel dest,int flags)
    {
        dest.writeString(naziv);
    }
}

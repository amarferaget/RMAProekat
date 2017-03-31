package com.example.amar.proektnizadatakrma;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Amar on 31.03.2017..
 */

public class ReziseriArrayAdapter extends ArrayAdapter{
    private Context mContext;
    private List<Reziser> mReziserList;
    int[] slikeRezisera;

    public ReziseriArrayAdapter(@NonNull Context mContext, @LayoutRes int resource, List<Reziser> mReziserList, int[] slikeRezisera) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mReziserList = mReziserList;
        this.slikeRezisera = slikeRezisera;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder mViewHolder=new ViewHolder();
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //convertView=inflater.inflate(R.layout.reziser_layout);
        }
        return  convertView;
    }

    static class ViewHolder{
        ImageView mReziser;
        TextView ime;
        TextView prezime;
        TextView godiste;
        TextView mjestoRodenja;
    }
}

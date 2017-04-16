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
 * Created by Amar on 15.04.2017..
 */

public class ZanroviArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private List<Zanr> mZanrovi;
    int[] slikeZanrova;
    public ZanroviArrayAdapter(@NonNull Context mContext, @LayoutRes int _resource,List<Zanr> mZanrovi,int[] slike) {
        super(mContext, _resource, mZanrovi);
        this.mContext=mContext;
        this.mZanrovi=mZanrovi;
        this.slikeZanrova=slike;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder mViewHolder=new ViewHolder();
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.zanr_list,parent,false);
            mViewHolder.slika=(ImageView)convertView.findViewById(R.id.slikaZanra);
            mViewHolder.naziv=(TextView)convertView.findViewById(R.id.tv_zanr_naziv);
            convertView.setTag(mViewHolder);
        }
        else
        {
            mViewHolder=(ViewHolder)convertView.getTag();
        }
        mViewHolder.slika.setImageResource(slikeZanrova[position]);
        mViewHolder.naziv.setText(mZanrovi.get(position).getNaziv());
        return convertView;
    }

    static class ViewHolder{
        ImageView slika;
        TextView naziv;
    }
}

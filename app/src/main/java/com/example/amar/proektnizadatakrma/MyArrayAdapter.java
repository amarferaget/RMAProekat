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

public class MyArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private List<Glumac> mGlumciList;
    int[] slikeGlumaca;

    public MyArrayAdapter(@NonNull Context mContext, @LayoutRes int _resource, List<Glumac> mGlumciList,int[] slike) {
        super(mContext, _resource,mGlumciList);
        this.mContext = mContext;
        this.mGlumciList = mGlumciList;
        this.slikeGlumaca=slike;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder mViewHolder=new ViewHolder();
        if(convertView==null)
        {
            LayoutInflater mInflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=mInflater.inflate(R.layout.actor_list,parent,false);
            mViewHolder.mGLumac=(ImageView)convertView.findViewById(R.id.imageView);
            mViewHolder.ime=(TextView)convertView.findViewById(R.id.tv_reziser_ime);
            mViewHolder.prezime=(TextView)convertView.findViewById(R.id.tv_prezime);
            mViewHolder.godiste=(TextView)convertView.findViewById(R.id.tv_reziser_godiste);
            mViewHolder.mjestoRodenja=(TextView)convertView.findViewById(R.id.tv_reziser_grad);
            mViewHolder.rating=(TextView)convertView.findViewById(R.id.tv_rating);


            convertView.setTag(mViewHolder);
        }
        else
        {
            mViewHolder=(ViewHolder)convertView.getTag();
        }
        mViewHolder.mGLumac.setImageResource(slikeGlumaca[position]);
        mViewHolder.ime.setText(mGlumciList.get(position).getIme());
        mViewHolder.prezime.setText(mGlumciList.get(position).getPrezime());
        mViewHolder.godiste.setText(mGlumciList.get(position).getGodinaRodenja());
        mViewHolder.mjestoRodenja.setText(mGlumciList.get(position).getMjestoRodenja());
        mViewHolder.rating.setText(mGlumciList.get(position).getRating());
        return convertView;
    }

    static class ViewHolder{
        ImageView mGLumac;
        TextView ime;
        TextView prezime;
        TextView godiste;
        TextView mjestoRodenja;
        TextView rating;
    }
}

package com.example.amar.proektnizadatakrma;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amar on 15.04.2017..
 */

public class ReziseriArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private List<Reziser> mReziseriList;
    int[] slikeRezisera;

    public ReziseriArrayAdapter(@NonNull Context mContext, @LayoutRes int _resource, List<Reziser> mReziseriList, int[] slike) {
        super(mContext, _resource,mReziseriList);
        this.mContext=mContext;
        this.mReziseriList = mReziseriList;
        this.slikeRezisera = slike;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder mViewHolder=new ViewHolder();
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.reziser_layout,parent,false);
            mViewHolder.mReziser=(ImageView)convertView.findViewById(R.id.reziserImage);
            mViewHolder.ime=(TextView)convertView.findViewById(R.id.tv_reziser_ime);
            mViewHolder.prezime=(TextView)convertView.findViewById(R.id.tv_reziser_prezime);
            mViewHolder.godiste=(TextView)convertView.findViewById(R.id.tv_reziser_godiste);
            mViewHolder.grad=(TextView)convertView.findViewById(R.id.tv_reziser_grad);

            convertView.setTag(mViewHolder);
        }
        else
        {
            mViewHolder=(ViewHolder)convertView.getTag();
        }
        mViewHolder.mReziser.setImageResource(slikeRezisera[position]);
        mViewHolder.ime.setText(mReziseriList.get(position).getIme());
        mViewHolder.prezime.setText(mReziseriList.get(position).getPrezime());
        mViewHolder.godiste.setText(mReziseriList.get(position).getGodiste());
        mViewHolder.grad.setText(mReziseriList.get(position).getMjestoRodenja());
        return convertView;
    }

    static class ViewHolder
    {
        ImageView mReziser;
        TextView ime;
        TextView prezime;
        TextView godiste;
        TextView grad;
    }
}

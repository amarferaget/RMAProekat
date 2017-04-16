package com.example.amar.proektnizadatakrma;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Amar on 14.04.2017..
 */

public class FragmentDetaljiGlumac extends Fragment{
    private Glumac glumac=new Glumac();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances)
    {
        View iv=inflater.inflate(R.layout.biogafija_glumca,container,false);
        if(getArguments()!=null && getArguments().containsKey("glumac"))
        {
            glumac=getArguments().getParcelable("glumac");
            Toolbar toolbar=(Toolbar)iv.findViewById(R.id.toolbar);
            ImageView slika=(ImageView)iv.findViewById(R.id.slikaGlumca);
            TextView godinaRodenja=(TextView)iv.findViewById(R.id.tv_godinaRodenja);
            TextView mjestoRodenja=(TextView)iv.findViewById(R.id.tv_mjestoRodenja);
            TextView spol=(TextView)iv.findViewById(R.id.tv_spol);
            TextView link=(TextView)iv.findViewById(R.id.tv_link);
            TextView biografija=(TextView)iv.findViewById(R.id.tv_biografija);
            toolbar.setTitle(glumac.getIme());
            godinaRodenja.setText(glumac.getGodinaRodenja());
            mjestoRodenja.setText(glumac.getMjestoRodenja());
            spol.setText(glumac.getSpol());
            link.setText(glumac.getLink());
            biografija.setText(glumac.getBiografija());
        }
        return iv;
    }
    @Override
    public void onActivityCreated(Bundle savedInstancesState){
        super.onActivityCreated(savedInstancesState);
        if(glumac.getSpol()=="Musko")
            getView().setBackgroundColor(Color.BLUE);
        else
            getView().setBackgroundColor(Color.RED);
    }
}

package com.example.amar.proektnizadatakrma;

import android.app.Fragment;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentListaGlumaca extends Fragment {
    int[] slikeGLumaca={R.drawable.dominik,
            R.drawable.scofield};
    ArrayList<Glumac> glumci=new ArrayList<>();
    OnItemClick oic;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstances)
    {
        return inflater.inflate(R.layout.fragment_lista_glumaca,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        if(getArguments().containsKey("Glista"));
        glumci= getArguments().getParcelableArrayList("Glista");
        ListView lv=(ListView)getView().findViewById(R.id.listaGlumci);
        MyArrayAdapter aa=new MyArrayAdapter(getActivity(),R.layout.actor_list,glumci,slikeGLumaca);
        lv.setAdapter(aa);

        try {
            oic=(OnItemClick)getActivity();
        }
        catch (ClassCastException e)
        {
            throw  new ClassCastException(getActivity().toString()+"Treba implementirat ONItemClick");
        }
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                oic.onItemClicked(position);
            }
        });
    }




    public interface OnItemClick{
        public void onItemClicked(int pos);
    }
}


package com.example.amar.proektnizadatakrma;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amar on 15.04.2017..
 */

public class FragmentListaZanrova extends Fragment {
    int[] slikeZanrova={R.drawable.slikarock,
                        R.drawable.slikapop};
    ArrayList<Zanr> zanrovi=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances)
    {
        return inflater.inflate(R.layout.fragment_lista_zanrova,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstancesState){
        super.onActivityCreated(savedInstancesState);
        if(getArguments().containsKey("Zlista"));
        zanrovi=getArguments().getParcelableArrayList("Zlista");
        ListView lv=(ListView)getView().findViewById(R.id.listaZanrovi);
        ZanroviArrayAdapter aa=new ZanroviArrayAdapter(getActivity(),R.layout.zanr_list,zanrovi,slikeZanrova);
        lv.setAdapter(aa);
    }
}

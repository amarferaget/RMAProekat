package com.example.amar.proektnizadatakrma;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;



public class FragmentListaRezisera extends Fragment {
    int[] slikeRezisera={R.drawable.steven,
            R.drawable.tarantino};
    ArrayList<Reziser> reziseri=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInsatnces)
    {
        return inflater.inflate(R.layout.fragment_lista_rezisera,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstancesState){
        super.onActivityCreated(savedInstancesState);
        if(getArguments().containsKey("Rlista"));
        reziseri=getArguments().getParcelableArrayList("Rlista");
        ListView lv=(ListView)getView().findViewById(R.id.listaReziseri);
        ReziseriArrayAdapter aa=new ReziseriArrayAdapter(getActivity(),R.layout.reziser_layout,reziseri,slikeRezisera);
        lv.setAdapter(aa);
    }
}

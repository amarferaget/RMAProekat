package com.example.amar.proektnizadatakrma;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity implements FragmentListaGlumaca.OnItemClick {
    private List<Glumac> glumci;
    private List<Reziser> reziseri;
    private List<Zanr> zanrovi;
    Button dugmeGlumci,dugmeReziseri,dugmeZanrovi;
    private Boolean siri=false;



    @Override
    public void onItemClicked(int pos)
    {
        Bundle arguments=new Bundle();
        arguments.putParcelable("glumac",glumci.get(pos));
        FragmentDetaljiGlumac fdg=new FragmentDetaljiGlumac();
        fdg.setArguments(arguments);
        //if(siri)
        //{
        //    getFragmentManager().beginTransaction().replace(R.id.frameF2,fdg).commit();
        //}
        //else
        //{
            getFragmentManager().beginTransaction().replace(R.id.frameF1,fdg).addToBackStack(null).commit();
        //}

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        glumci=new ArrayList<>();
        reziseri=new ArrayList<>();
        zanrovi=new ArrayList<>();
        dugmeReziseri=(Button)findViewById(R.id.b_reziseri);
        dugmeGlumci=(Button)findViewById(R.id.b_glumci);
        dugmeZanrovi=(Button)findViewById(R.id.b_zanrovi);

        glumci.add(new Glumac("Dominic","Purcel","1970","England","Musko","http://www.imdb.com/name/nm0700712/","Purcell was born in Wallasey, Cheshire, the son of Phil Myrtvedt and Mary T. Purcell. " +
                "His mother was of Irish descent and his father was a Norwegian of French descent. In 1972, he and his family moved to Bondi, New South Wales, and later to Western Sydney." +
                " He attended Blaxland East Public School and Blaxland High School, as well as St Dominic's College and McCarthy Catholic College, Emu Plains. " +
                "After becoming a landscape gardener, he grew tired of the profession and decided to become an actor after watching the film Platoon." +
                " He later attended the Australian Theatre for Young People and then enrolled at the Western Australian Academy of Performing Arts, where he studied with Hugh Jackman.","5"  ));
        glumci.add(new Glumac("Wentworth","Miller","1974","England","Musko","http://www.imdb.com/character/ch0007970/?ref_=ch_mv_close","Michael Scofield is a law-abiding man who takes extreme measures to save his older brother Lincoln Burrows from the electric chair. " +
                "Believing Lincoln to be wrongly convinced for killing Terrence Steadman, the brother of the Vice President of the United States Caroline Reynolds, and with Lincoln's execution date fast approaching, " +
                "Michael commits a bank robbery and surrenders peacefully in order to be sent to Fox River State Penitentiary to break out with his brother.","4"));
        reziseri.add(new Reziser("Steven","Spilberg","1846","Cincinnati"));
        reziseri.add(new Reziser("Quentin","Tarantino","1963","Knoxville"));
        zanrovi.add(new Zanr("Rok"));
        zanrovi.add(new Zanr("Pop"));
        final FragmentManager fm=getFragmentManager();
        /*FrameLayout ldetalji=(FrameLayout)findViewById(R.id.frameF2);
        if(ldetalji!=null)
        {
            siri=true;
            FragmentDetaljiGlumac fd;
            fd=(FragmentDetaljiGlumac)fm.findFragmentById(R.id.frameF2);
            if(fd==null)
            {
                fd=new FragmentDetaljiGlumac();
                fm.beginTransaction().replace(R.id.frameF2,fd).commit();
            }
        }
*/

        FragmentListaGlumaca flg=(FragmentListaGlumaca)fm.findFragmentByTag("ListaGlumci");
        if(flg==null)
        {
        flg=new FragmentListaGlumaca();
            Bundle argumenti=new Bundle();
            argumenti.putParcelableArrayList("Glista", (ArrayList<? extends Parcelable>) glumci);
            flg.setArguments(argumenti);
            fm.beginTransaction().replace(R.id.frameF1,flg,"ListaGlumci").commit();
        }
        else
        {
            fm.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }


        dugmeReziseri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentListaRezisera flr=(FragmentListaRezisera)fm.findFragmentByTag("ListaReziseri");
                if(flr==null)
                {
                    flr=new FragmentListaRezisera();
                    Bundle argumenti=new Bundle();
                    argumenti.putParcelableArrayList("Rlista", (ArrayList<? extends Parcelable>) reziseri);
                    flr.setArguments(argumenti);
                    fm.beginTransaction().replace(R.id.frameF1,flr,"ListaReziseri").commit();
                }
                else
                {
                    fm.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
                }
            }
        });

        final FragmentListaGlumaca finalFlg = flg;
        dugmeGlumci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              fm.beginTransaction().replace(R.id.frameF1, finalFlg,"ListaGlumci").commit();
            }
        });

        dugmeZanrovi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentListaZanrova flz=(FragmentListaZanrova)fm.findFragmentByTag("ListaZanrovi");
                if(flz==null)
                {
                    flz=new FragmentListaZanrova();
                    Bundle argumenti=new Bundle();
                    argumenti.putParcelableArrayList("Zlista", (ArrayList<? extends Parcelable>) zanrovi);
                    flz.setArguments(argumenti);
                    fm.beginTransaction().replace(R.id.frameF1,flz,"ListaZanrovi").commit();
                }
                else
                {
                    fm.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
                }
            }
        });
        //lvGlumci=(ListView)findViewById(R.id.listaGlumci);


        //adapterGlumci=new MyArrayAdapter(getApplicationContext(),R.layout.actor_list,glumci,slikeGLumaca);
        //lvGlumci.setAdapter(adapterGlumci);
       // reziserAdapte=new ReziseriArrayAdapter(getApplicationContext(),R.layout.reziser_layout,reziseri,slikeRezisera);
       // lvGlumci.setAdapter(reziserAdapte);
       /* dugmeGlumci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterGlumci.notifyDataSetChanged();

            }
        });
*/
       /*
        dugmeReziseri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent("com.example.amar.proektnizadatakrma.ReziserActivity");
               // startActivity(intent);
                reziserAdapte.notifyDataSetChanged();
            }
        });

        lvGlumci.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent=new Intent(MainActivity.this,ActorActivity.class);
                mIntent.putExtra("naziv",glumci.get(position).getIme()+" "+glumci.get(position).getPrezime());
               // mIntent.putExtra("slika",slikeGLumaca[position]);
                mIntent.putExtra("godinaRodenja",glumci.get(position).getGodinaRodenja());
                mIntent.putExtra("mjestoRodenja",glumci.get(position).getMjestoRodenja());
                mIntent.putExtra("spol",glumci.get(position).getSpol());
                mIntent.putExtra("link",glumci.get(position).getLink());
                mIntent.putExtra("biografija",glumci.get(position).getBiografija());
                startActivity(mIntent);
            }
        });
*/
    }
}

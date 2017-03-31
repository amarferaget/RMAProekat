package com.example.amar.proektnizadatakrma;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvGlumci;
    private MyArrayAdapter adapterGlumci;
    private ReziseriArrayAdapter reziserAdapte;
    private List<Glumac> glumci;
    private List<Reziser> reziseri;
    Button dugmeGlumci,dugmeReziseri;
    int[] slikeGLumaca={R.drawable.dominik,
                        R.drawable.scofield};
    int[] slikeRezisera={R.drawable.steven,
                         R.drawable.tarantino};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvGlumci=(ListView)findViewById(R.id.lista);
        dugmeGlumci=(Button)findViewById(R.id.b_glumci);
        dugmeReziseri=(Button)findViewById(R.id.b_reziseri);
        glumci=new ArrayList<>();
        reziseri=new ArrayList<>();
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
        adapterGlumci=new MyArrayAdapter(getApplicationContext(),R.layout.actor_list,glumci,slikeGLumaca);
        lvGlumci.setAdapter(adapterGlumci);
        reziserAdapte=new MyArrayAdapter(getApplicationContext(),R.layout.reziser_layout,reziseri,slikeRezisera);

        dugmeGlumci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterGlumci.notifyDataSetChanged();

            }
        });

        dugmeReziseri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.example.amar.proektnizadatakrma.ReziserActivity");
                startActivity(intent);
            }
        });

        lvGlumci.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent=new Intent(MainActivity.this,ActorActivity.class);
                mIntent.putExtra("naziv",glumci.get(position).getIme()+" "+glumci.get(position).getPrezime());
                mIntent.putExtra("slika",slikeGLumaca[position]);
                mIntent.putExtra("godinaRodenja",glumci.get(position).getGodinaRodenja());
                mIntent.putExtra("mjestoRodenja",glumci.get(position).getMjestoRodenja());
                mIntent.putExtra("spol",glumci.get(position).getSpol());
                mIntent.putExtra("link",glumci.get(position).getLink());
                mIntent.putExtra("biografija",glumci.get(position).getBiografija());
                startActivity(mIntent);
            }
        });

    }
}

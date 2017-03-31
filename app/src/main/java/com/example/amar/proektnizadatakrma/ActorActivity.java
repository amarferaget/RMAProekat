package com.example.amar.proektnizadatakrma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class ActorActivity extends AppCompatActivity {
    Toolbar mToolbar;
    ImageView image;
    TextView godinaRodenja,mjestoRodenja,spol,link,biografija;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biogafija_glumca);
        mToolbar=(Toolbar)findViewById(R.id.toolbar);
        image=(ImageView)findViewById(R.id.slikaGlumca);
        godinaRodenja=(TextView)findViewById(R.id.tv_godinaRodenja);
        mjestoRodenja=(TextView)findViewById(R.id.tv_mjestoRodenja);
        spol=(TextView)findViewById(R.id.tv_spol);
        link=(TextView)findViewById(R.id.tv_link);
        biografija=(TextView)findViewById(R.id.tv_biografija);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            mToolbar.setTitle(bundle.getString("naziv"));
            image.setImageResource(bundle.getInt("slika"));
            godinaRodenja.setText(bundle.getString("godinaRodenja"));
            mjestoRodenja.setText(bundle.getString("mjestoRodenja"));
            spol.setText(bundle.getString("spol"));
            link.setText(bundle.getString("link"));
            biografija.setText(bundle.getString("biografija"));
        }
    }
}

package com.example.amar.proektnizadatakrma;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WebActivity extends AppCompatActivity {
  TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biogafija_glumca);
        t=(TextView)findViewById(R.id.tv_link);
       t.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            browser();
           }
       });
    }

    public void browser()
    {
        String url="http://www.google.com";
        Intent mIntent=new Intent(Intent.ACTION_VIEW);
        mIntent.setData(Uri.parse(url));
        startActivity(mIntent);
    }
}

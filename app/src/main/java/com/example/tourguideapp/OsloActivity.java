package com.example.tourguideapp;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class OsloActivity extends AppCompatActivity {


    private ArrayList<Sedvardhet> sedvard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_pa_sevardheter);

        //Skapa en lista pa alla sedvardheter

        sedvard = new ArrayList<Sedvardhet>();

        Location sibeliusMonument = new Location(getResources().getString(R.string.oslo_sedvardhet_namn_1));
        sibeliusMonument.setLatitude(59.9228);
        sibeliusMonument.setLongitude(10.7001);
        sedvard.add(new Sedvardhet(getResources().getString(R.string.oslo_sedvardhet_namn_1), getResources().getString(R.string.oslo_sedvardhet_nummer_1), getResources().getString(R.string.oslo_sedvardhet_adress_1), getResources().getString(R.string.oslo_sedvardhet_bild_1), sibeliusMonument));


        Location ateneum = new Location(getResources().getString(R.string.oslo_sedvardhet_namn_2));
        ateneum.setLatitude(59.9075);
        ateneum.setLongitude(10.7531);
        sedvard.add(new Sedvardhet(getResources().getString(R.string.oslo_sedvardhet_namn_2), getResources().getString(R.string.oslo_sedvardhet_nummer_2), getResources().getString(R.string.oslo_sedvardhet_adress_2), getResources().getString(R.string.oslo_sedvardhet_bild_2), ateneum));

        Location fin = new Location(getResources().getString(R.string.oslo_sedvardhet_namn_3));
        fin.setLatitude(59.9228);
        fin.setLongitude(10.7001);
        sedvard.add(new Sedvardhet(getResources().getString(R.string.oslo_sedvardhet_namn_3), getResources().getString(R.string.oslo_sedvardhet_nummer_3), getResources().getString(R.string.oslo_sedvardhet_adress_3), getResources().getString(R.string.oslo_sedvardhet_bild_3), fin));


        Adapter adapter = new Adapter(this, sedvard);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = sedvard.get(position).getPlats().getLatitude();
                double lon = sedvard.get(position).getPlats().getLongitude();
                String keyword = sedvard.get(position).getSedvardhetNamn();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(keyword));

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
    }
}
package com.example.tourguideapp;

import android.location.Location;

/**
 * Created by estlander on 27/02/2017.
 */

public class Sedvardhet {
    private String namn;
    private String nummer;
    private String adress;
    private String BildURL;
    private Location sedvardhetLocation;


    //Lonar sig att kolla om det faller pa "this". Kan vara att man inte kan kopiera det har...
    public Sedvardhet(String namn1, String nummer1, String adress1, String bild, Location plats){
        namn = namn1;
        nummer = nummer1;
        adress = adress1;
        BildURL = bild;
        sedvardhetLocation = plats;
    }

    public String getSedvardhetNamn() {
        return namn;
    }

    public String getSedvardhetNummer() {
        return nummer;
    }

    public String getAdress() {
        return adress;
    }

    public String getImageUrl() {
        return BildURL;
    }

    public Location getPlats(){
        return sedvardhetLocation;
    }

}

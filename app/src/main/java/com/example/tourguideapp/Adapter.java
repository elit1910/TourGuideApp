package com.example.tourguideapp;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;
import java.util.ArrayList;
/**
 * Created by estlander on 27/02/2017.
 */

public class Adapter extends ArrayAdapter<Sedvardhet>{

    public Adapter(Context context, ArrayList<Sedvardhet> attractions){
        super(context, 0, attractions);
    }

    @Override
    public View getView(int postion, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.lista_objekt, parent, false);
        }

        Sedvardhet denNuvarandeSedvardheten = getItem(postion);

        TextView namnPaTextView = (TextView) listItemView.findViewById(R.id.name);
        namnPaTextView.setText(denNuvarandeSedvardheten.getSedvardhetNamn());

        TextView nummerTextView = (TextView) listItemView.findViewById(R.id.phone);
        if("".equals(denNuvarandeSedvardheten.getSedvardhetNummer()))
            nummerTextView.setVisibility(View.GONE);
        else {
            nummerTextView.setVisibility(View.VISIBLE);
            nummerTextView.setText(denNuvarandeSedvardheten.getSedvardhetNummer());
        }

        TextView adressTextView = (TextView) listItemView.findViewById(R.id.address);
        adressTextView.setText(denNuvarandeSedvardheten.getAdress());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);

        // Improve picture loading.

        Picasso.with(getContext())
                .load(denNuvarandeSedvardheten.getImageUrl())
                .resizeDimen(R.dimen.image_width,R.dimen.image_heigth)
                .centerInside()
                .into(imageView);

        return listItemView;

    }


}

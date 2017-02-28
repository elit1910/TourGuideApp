package com.example.tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Helsinki = (TextView)findViewById(R.id.Helsinki);
        Helsinki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HelsinkiIntent = new Intent(MainActivity.this, HelsinkiActivity.class);
                startActivity(HelsinkiIntent);
            }
        });

        TextView Stockholm = (TextView)findViewById(R.id.Stockholm);
        Stockholm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent StockholmIntent = new Intent(MainActivity.this, StockholmActivity.class);
                startActivity(StockholmIntent);
            }
        });

        TextView Copenhagen = (TextView)findViewById(R.id.Copenhagen);
        Copenhagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CopenhagenIntent = new Intent(MainActivity.this, CopenhagenActivity.class);
                startActivity(CopenhagenIntent);
            }
        });

        TextView Oslo = (TextView)findViewById(R.id.Oslo);
        Oslo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent OsloIntent = new Intent(MainActivity.this, OsloActivity.class);
                startActivity(OsloIntent);
            }
        });
    }
}

package com.example.findheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.squareup.picasso.Picasso;

public class SuperHeroHabilities extends AppCompatActivity {
    TextView nombre1;
    TextView nombreC1;
    ImageView imagenN;
    GraphView grafica;
    TextView inte;
    TextView force;
    TextView vel;
    TextView dur;
    TextView pot;
    TextView com;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_hero_habilities);
        mostrarDatos();
    }


    private void mostrarDatos(){

        Bundle extras =getIntent().getExtras();
        String nomb= extras.getString("nombre");
        String nombreC= extras.getString("full-name");
        String imagen= extras.getString("imagen");
        int intelligence= extras.getInt("intelligence");
        int strength= extras.getInt("strength");
        int speed= extras.getInt("speed");
        int durability= extras.getInt("durability");
        int power= extras.getInt("power");
        int combat= extras.getInt("combat");

        nombre1 = (TextView) findViewById(R.id.nombre);
        nombreC1 = (TextView) findViewById(R.id.nombreCom);
        imagenN = (ImageView) findViewById(R.id.imageView);


        nombre1.setText(nomb);
        nombreC1.setText(nombreC);
        Picasso.get().load(imagen).resize(250,250).centerCrop().into(imagenN);






    }
}
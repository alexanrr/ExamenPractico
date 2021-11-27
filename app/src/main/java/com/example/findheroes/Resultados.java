package com.example.findheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;

public class Resultados extends AppCompatActivity {
    TextView numdatos;
    LinearLayout nuevo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        recibirDatos();
    }
    private void recibirDatos(){
        Bundle extras =getIntent().getExtras();
        int num = extras.getInt("numresults");

        numdatos = (TextView) findViewById(R.id.textView5);
        numdatos.setText(String.valueOf(num));
        nuevo= (LinearLayout) findViewById(R.id.nuevoLinear);
        for(int j=0; j<num; j++){
            String valor= extras.getString("nombre"+j);
            String valor1= extras.getString("full-name"+j);
            String valor2= extras.getString("imagen"+j);
            int valor3= extras.getInt("intelligence"+j);
            int valor4= extras.getInt("strength"+j);
            int valor5= extras.getInt("speed"+j);
            int valor6= extras.getInt("durability"+j);
            int valor7= extras.getInt("power"+j);
            int valor8= extras.getInt("combat"+j);
            TextView tvdin= new TextView(Resultados.this);

            tvdin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i1= new Intent(Resultados.this, SuperHeroHabilities.class);
                    i1.putExtra("nombre",valor);
                    i1.putExtra("full-name",valor1);
                    i1.putExtra("imagen",valor2);
                    i1.putExtra("intelligence",valor3);
                    i1.putExtra("strength",valor4);
                    i1.putExtra("speed",valor5);
                    i1.putExtra("durability",valor6);
                    i1.putExtra("power",valor7);
                    i1.putExtra("combat",valor8);




                    startActivity(i1);

                }
            });

            tvdin.setText(valor);
            tvdin.setTextSize(20);
            nuevo.addView(tvdin);
        }





    }


}
package com.example.findheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    private RequestQueue mQueue;
    private String token = "2005008006332152";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQueue = Volley.newRequestQueue(this);
    }

    public void buscar(View v){

        final EditText pal = (EditText) findViewById(R.id.SuperHero);
        String palabra= pal.getText().toString();
        buscarHeroe(palabra);
    }
    private void buscarHeroe(String heroe){



        String url=  "https://www.superheroapi.com/api.php/"+token+"/search/"+heroe;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response);
                try {
                    Intent i = new Intent(MainActivity.this,Resultados.class);
                    JSONArray Arreglo= response.getJSONArray("results");

                    for(int j=0; j<Arreglo.length(); j++){

                        JSONObject mObject= Arreglo.getJSONObject(j);
                        String name = mObject.getString("name");
                        JSONObject jobj= mObject.optJSONObject("biography");
                        String nameC = jobj.getString("full-name");
                        JSONObject jobj2= mObject.optJSONObject("image");
                        String imagen = jobj2.getString("url");
                        JSONObject jobj3= mObject.optJSONObject("powerstats");
                        String intelligence= jobj3.getString("intelligence");
                        String strength= jobj3.getString("strength");
                        String speed= jobj3.getString("speed");
                        String durability= jobj3.getString("durability");
                        String power= jobj3.getString("power");
                        String combat= jobj3.getString("combat");

                        i.putExtra("nombre"+j,name);
                        i.putExtra("full-name"+j,nameC);
                        i.putExtra("imagen"+j,imagen);
                        i.putExtra("intelligence"+j,intelligence);
                        i.putExtra("strength"+j,strength);
                        i.putExtra("speed"+j,speed);
                        i.putExtra("durability"+j,durability);
                        i.putExtra("power"+j,power);
                        i.putExtra("combat"+j,combat);
                    };


                    i.putExtra("numresults",Arreglo.length());
                    startActivity(i);
                } catch (JSONException e) {
                    e.printStackTrace();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }});
        mQueue.add(request);
    }



}
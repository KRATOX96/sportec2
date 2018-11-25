package com.example.christian.adminsportec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.christian.adminsportec.Models.Juego;
import com.example.christian.adminsportec.io.SportecApiAdapter;
import com.example.christian.adminsportec.io.SportecApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Hashtable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AsignarResultados extends AppCompatActivity implements Callback<Juego> {
    TextView tvEquipo1;
    TextView tvEquipo2;
    TextView tvMarcador1;
    TextView tvMarcador2;
    Button boton;

    String sMarcador1;
    String sMarcador2;
    String resultado;
    String fecha;
    String equipo1_nombre;
    String equipo2_nombre;
    int deporte_id;
    int iniciado;
    String set_actual;

    Call<Juego> call;
    SportecApiService sportecApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignar_resultados);
        SportecApiAdapter.getApiService().getResultadpsById(1);
        call = SportecApiAdapter.getApiService().getResultadpsById(1);
        sportecApiService= SportecApiAdapter.getApiService();
        call.enqueue(this);

        tvEquipo1=findViewById(R.id.Equipo1);
        tvEquipo2=findViewById(R.id.Equipo2);
        tvMarcador1=findViewById(R.id.resultado_equipo1);
        tvMarcador2=findViewById(R.id.resultado_equipo2);
        boton =findViewById(R.id.Aceptar);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    sendPost(sMarcador1,
                            sMarcador2, resultado,fecha,equipo1_nombre,equipo2_nombre,
                            deporte_id,iniciado,set_actual);
            }
        });
    }
    public void sendPost(String marcador1, String marcador2, String resultado
            , String fecha, String equipo1_nombre , String equipo2_nombre
            , int deporte_id, int iniciado , String set_actual) {
        sportecApiService.updatePost(1, marcador1,marcador2, ""+resultado,""+fecha,""+equipo1_nombre,
                ""+equipo2_nombre,deporte_id,iniciado,set_actual).enqueue(new Callback<Juego>() {
            @Override
            public void onResponse(Call<Juego> call, Response<Juego> response) {
                Log.i("rugal1","si entra");
                if(response.isSuccessful()) {
                    Log.i("rugal2",response.toString());

                }
                else{
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(getApplicationContext(), jObjError.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Juego> call, Throwable t) {
            }
        });
    }
    @Override
    public void onResponse(Call<Juego> call, Response<Juego> response) {
       Juego juego = response.body();

        tvEquipo1.setText(juego.getEquipo1Nombre());
        tvEquipo2.setText(juego.getEquipo2Nombre());
        tvMarcador1.setText(juego.getMarcador1());
        tvMarcador2.setText(juego.getMarcador2());

        sMarcador1 = juego.getMarcador1();
        sMarcador2= juego.getMarcador2();
        resultado = juego.getResultado();
        fecha = convertFecha(juego.getFecha());
        equipo1_nombre = juego.getEquipo1Nombre();
        equipo2_nombre = juego.getEquipo2Nombre();
        deporte_id = juego.getDeporteId();
        iniciado = juego.getIniciado();
        set_actual = juego.getSetActual();
    }



    @Override
    public void onFailure(Call<Juego> call, Throwable t) {

    }
    private String convertFecha(String fecha) {
        fecha = fecha.replace(" ","");
        fecha = fecha.replace(":","");
        fecha = fecha.replace("-","");
        return  fecha;
    }
}

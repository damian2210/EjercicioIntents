package com.example.ejerciciointents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Ejercicio1Navegacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1_navegacion);
        Button cerrar=findViewById(R.id.btnCerrarNaveg);
        Button navegar=findViewById(R.id.btnNaveg);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        navegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText textoNaveg=findViewById(R.id.txtURl);
                String url=textoNaveg.getText().toString();
                Intent buscar = new Intent(Intent.ACTION_WEB_SEARCH);
                buscar.putExtra(SearchManager.QUERY, url);
                startActivity(buscar);
            }
        });
    }
}
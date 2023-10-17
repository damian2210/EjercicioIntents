package com.example.ejerciciointents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
        Button llamar=findViewById(R.id.btnLlamar);
        EditText nombre=findViewById(R.id.editText);
        CheckBox check=findViewById(R.id.checkBox);
        Button telefono=findViewById(R.id.btntlf);
        Button navegar=findViewById(R.id.btnnavegador);
        Button localizacion=findViewById(R.id.btnlocalizacion);
        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent clase2=new Intent();
                String name=nombre.getText().toString();
                boolean marcado=check.isChecked();

                    if(name==null||name.compareTo("")==0){
                        Toast.makeText(Ejercicio1.this, "Nombre vacio", Toast.LENGTH_SHORT).show();
                     }else{
                        clase2.putExtra("nombre",name);
                        clase2.setAction(Intent.ACTION_SEND);
                         clase2.setClass(view.getContext(), Ejercicio1Segunda.class);
                         startActivity(clase2);
                    }
                if(marcado==true){
                    finish();
                }
                }

        });
        telefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent clasetlf=new Intent();
                clasetlf.setClass(view.getContext(), Ejercicio1Telefono.class);
                startActivity(clasetlf);
            }
        });
        navegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent clasenaveg=new Intent();
                clasenaveg.setClass(view.getContext(), Ejercicio1Navegacion.class);
                startActivity(clasenaveg);
            }
        });
        localizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapa = new Intent(Intent.ACTION_WEB_SEARCH);
                mapa.putExtra(SearchManager.QUERY, "https://www.google.es/maps/preview");
                startActivity(mapa);
            }
        });
        TextView res=findViewById(R.id.resultado);
        String n=getIntent().getStringExtra("nombre_completo");
        res.setText(n);


    }
}
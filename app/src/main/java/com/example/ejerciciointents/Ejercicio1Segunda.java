package com.example.ejerciciointents;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ejercicio1Segunda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1_segunda);
        String n=getIntent().getExtras().getString("nombre");
        TextView texto=findViewById(R.id.txtHola);
        texto.setText("hola "+n);
        Button cerrar=findViewById(R.id.btnCerrar);
        EditText apellidos=findViewById(R.id.apellidos);
        Intent clase1=new Intent();
        ActivityResultLauncher<Intent> someActivityResultLauncher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {

                    }
                }

        );
        cerrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String a=apellidos.getText().toString();
                String completo=n+" "+a;
                clase1.putExtra("nombre_completo",completo);
                clase1.setClass(view.getContext(), Ejercicio1.class);
                someActivityResultLauncher.launch(clase1);
                finish();

            }
        });

    }/*preguntar que hacer porque lo de arriba debe de ir aqui pero no se como recoger los datos en ejercicio1*/
}
package com.example.ejerciciointents;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Ejercicio1Telefono extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1_telefono);
        Button cerrar=findViewById(R.id.btnCerrartlf);
        ImageButton llamada=findViewById(R.id.imageButton);
        EditText numeroTlf=findViewById(R.id.txttlf);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        llamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tlf=numeroTlf.getText().toString();
                Intent llamar = new Intent(Intent.ACTION_CALL);
                llamar.setData(Uri.parse("tel:"+tlf));


                startActivity(llamar);
            }
        });
    }
}
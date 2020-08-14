package com.example.checadorpaso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroUnidadesActivity extends AppCompatActivity {
    Button btnA, btnB, btnC;

    RutaAFragment rutaAFragment;
    RutaBFragment rutaBFragment;
    RutaCFragment rutaCFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_unidades);
        btnA = findViewById(R.id.btn_a);
        btnB = findViewById(R.id.btn_b);
        btnC = findViewById(R.id.btn_c);

        rutaAFragment = new RutaAFragment();
        rutaBFragment = new RutaBFragment();
        rutaCFragment = new RutaCFragment();


        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragment, rutaAFragment).commit();


        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedorFragment, rutaAFragment);
                transaction.commit();
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedorFragment, rutaBFragment);
                transaction.commit();
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedorFragment, rutaCFragment);
                transaction.commit();


            }
        });

    }
}

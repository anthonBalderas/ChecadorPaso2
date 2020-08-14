package com.example.checadorpaso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);



        final ImageView imgAddA, imgAddB, imgAddC, imgList, imgPay, imgLogOut;

        imgAddA = findViewById(R.id.btn_agregar_A);
        imgAddB = findViewById(R.id.btn_agregar_B);
        imgAddC = findViewById(R.id.btn_agregar_C);
        imgList = findViewById(R.id.btn_listas);
        imgPay = findViewById(R.id.btn_pagos);
        imgLogOut = findViewById(R.id.btn_cerrar_sesion);


        imgAddA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToA = new Intent(DashBoardActivity.this, RegistroUnidadesActivity.class);
                startActivity(inToA);

            }
        });
    }
}

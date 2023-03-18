package com.med.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class EspecialidadeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialidade);

        CardView voltar = findViewById(R.id.cardEVoltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EspecialidadeActivity.this, HomeActivity.class));
            }
        });

        CardView psicologo = findViewById(R.id.cardEPsicologo);
        psicologo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(EspecialidadeActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title", "Psicólogo");
                startActivity(it);
            }
        });

        CardView nutricionista = findViewById(R.id.cardENutricionista);
        nutricionista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(EspecialidadeActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title", "Nutricionista");
                startActivity(it);
            }
        });

        CardView dentista = findViewById(R.id.cardEDentista);
        dentista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(EspecialidadeActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title", "Dentista");
                startActivity(it);
            }
        });

        CardView cirurgiao = findViewById(R.id.cardECirurgiao);
        cirurgiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(EspecialidadeActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title", "Cirurgião");
                startActivity(it);
            }
        });

        CardView cardiologista = findViewById(R.id.cardECardiologista);
        cardiologista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(EspecialidadeActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title", "Cardiologista");
                startActivity(it);
            }
        });

    }
}
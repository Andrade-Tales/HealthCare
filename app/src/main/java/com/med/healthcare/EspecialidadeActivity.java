package com.med.healthcare;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class EspecialidadeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialidade);

        CardView voltar = findViewById(R.id.cardEVoltar);
        voltar.setOnClickListener(v -> startActivity(new Intent(EspecialidadeActivity.this, HomeActivity.class)));

        CardView psicologo = findViewById(R.id.cardEPsicologo);
        psicologo.setOnClickListener(v -> {
            Intent it = new Intent(EspecialidadeActivity.this, DetalhesDrActivity.class);
            it.putExtra("titulo", "Psicólogo");
            startActivity(it);
        });

        CardView nutricionista = findViewById(R.id.cardENutricionista);
        nutricionista.setOnClickListener(v -> {
            Intent it = new Intent(EspecialidadeActivity.this, DetalhesDrActivity.class);
            it.putExtra("titulo", "Nutricionista");
            startActivity(it);
        });

        CardView dentista = findViewById(R.id.cardEDentista);
        dentista.setOnClickListener(v -> {
            Intent it = new Intent(EspecialidadeActivity.this, DetalhesDrActivity.class);
            it.putExtra("titulo", "Dentista");
            startActivity(it);
        });

        CardView cirurgiao = findViewById(R.id.cardECirurgiao);
        cirurgiao.setOnClickListener(v -> {
            Intent it = new Intent(EspecialidadeActivity.this, DetalhesDrActivity.class);
            it.putExtra("titulo", "Cirurgião");
            startActivity(it);
        });

        CardView cardiologista = findViewById(R.id.cardECardiologista);
        cardiologista.setOnClickListener(v -> {
            Intent it = new Intent(EspecialidadeActivity.this, DetalhesDrActivity.class);
            it.putExtra("titulo", "Cardiologista");
            startActivity(it);
        });

    }
}
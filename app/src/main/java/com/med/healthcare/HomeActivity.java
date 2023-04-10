package com.med.healthcare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "").toString();
        Toast.makeText(getApplicationContext(), "Olá!" + username, Toast.LENGTH_SHORT).show();

        CardView exit = findViewById(R.id.cardHomeSair);
        exit.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        });

        CardView especialidade = findViewById(R.id.cardHomeEspecialidade);
        especialidade.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, EspecialidadeActivity.class)));

        CardView testeDeLaboratorio = findViewById(R.id.cardHomeLabTest);
        testeDeLaboratorio.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, LabTestActivity.class)));

        CardView outrosDetalhes = findViewById(R.id.cardHomeOutrosDetalhes);
        outrosDetalhes.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, OutrosDetalhesActivity.class)));
    }
}
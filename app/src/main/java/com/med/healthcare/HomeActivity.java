package com.med.healthcare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
        Toast.makeText(getApplicationContext(), "Olá! " + username, Toast.LENGTH_SHORT).show();

        CardView exit = findViewById(R.id.cardExit);
        exit.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        });

        CardView especialidade = findViewById(R.id.cardFindDoctor);
        especialidade.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, FindDoctorActivity.class)));

        CardView testeDeLaboratorio = findViewById(R.id.cardLabTest);
        testeDeLaboratorio.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, LabTestActivity.class)));

        CardView outrosDetalhes = findViewById(R.id.cardOrderDetails);
        outrosDetalhes.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, OrderDetailsActivity.class)));

        CardView comprarMedicamento = findViewById(R.id.cardBuyMedicine);
        comprarMedicamento.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, BuyMedicineActivity.class)));
    }
}
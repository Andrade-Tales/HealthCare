package com.med.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetalhesActivity extends AppCompatActivity {

    TextView tvLTDNomePacote, tvLTDTotal;
    EditText edDetalhes;

    Button botaoLTDCarrinho, botaoLTDVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_detalhes);

        tvLTDNomePacote = findViewById(R.id.textViewLTDNomePacote);
        tvLTDTotal = findViewById(R.id.textViewLTDTotal);
        edDetalhes = findViewById(R.id.editTextLTDDetalhes);
        botaoLTDCarrinho = findViewById(R.id.botaoLTDCarrinho);
        botaoLTDVoltar = findViewById(R.id.botaoLTDVoltar);

        edDetalhes.setKeyListener(null);

        Intent intent = getIntent();
        tvLTDNomePacote.setText(intent.getStringExtra("text1"));
        edDetalhes.setText(intent.getStringExtra("text2"));
        tvLTDTotal.setText("Total: " + intent.getStringExtra("text3") + " R$");

        botaoLTDVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetalhesActivity.this, LabTestActivity.class));
            }
        });

        botaoLTDCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                String product = tvLTDNomePacote.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db = new Database(getApplicationContext(), "healthcare", null, 1);

                if (db.checkCart(username, product) == 1) {
                    Toast.makeText(getApplicationContext(), "Produto já adicionado!", Toast.LENGTH_SHORT).show();
                } else {
                    db.addCart(username, product, price, "lab");
                    Toast.makeText(getApplicationContext(), "Registro já inserido no carrinho!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetalhesActivity.this, LabTestActivity.class));
                }
            }
        });
    }

}
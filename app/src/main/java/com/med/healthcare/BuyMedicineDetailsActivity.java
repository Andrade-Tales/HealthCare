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

public class BuyMedicineDetailsActivity extends AppCompatActivity {

    TextView tvPackageName, tvTotal;
    EditText edDetails;
    Button btnVoltar, btnCarrinho;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_details);

        tvPackageName = findViewById(R.id.textViewBMDNomePacote);
        tvTotal = findViewById(R.id.textViewBMDTotal);
        edDetails = findViewById(R.id.editTextBMDMultiline);
        edDetails.setKeyListener(null);
        btnVoltar = findViewById(R.id.botaoBMDVoltar);
        btnCarrinho = findViewById(R.id.botaoBMDCarrinho);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotal.setText("Total: " + intent.getStringExtra("text3") + " R$");

        btnVoltar.setOnClickListener(view -> startActivity(new Intent(BuyMedicineDetailsActivity.this, BuyMedicineActivity.class)));

        btnCarrinho.setOnClickListener(view -> {
            SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
            String username = sharedPreferences.getString("username", "").toString();
            String product = tvPackageName.getText().toString();
            float price = Float.parseFloat(intent.getStringExtra("text3").toString());

            Database db = new Database(getApplicationContext(), "healthcare", null, 1);

            if (db.checkCart(username, product) == 1) {
                Toast.makeText(getApplicationContext(), "Produto já adicionado!", Toast.LENGTH_SHORT).show();
            } else {
                db.addCart(username, product, price, "medicine");
                Toast.makeText(getApplicationContext(), "Medicamento inserido no carrinho!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BuyMedicineDetailsActivity.this, BuyMedicineActivity.class));
            }
        });
    }
}
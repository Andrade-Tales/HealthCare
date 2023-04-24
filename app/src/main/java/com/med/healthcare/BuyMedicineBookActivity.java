package com.med.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuyMedicineBookActivity extends AppCompatActivity {

    EditText ednome, edendereco, edcontato, edpincode;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book);

        ednome = findViewById(R.id.editTextBMBNomeCompleto);
        edendereco = findViewById(R.id.editTextBMBEndereco);
        edcontato = findViewById(R.id.editTextBMBContato);
        edpincode = findViewById(R.id.editTextBMBPinCode);
        btnRegistrar = findViewById(R.id.buttonBMBRegistrar);

        Intent intent = getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");

        btnRegistrar.setOnClickListener(view -> {
            SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
            String username = sharedPreferences.getString("username", "").toString();

            Database db = new Database(getApplicationContext(), "healthcare", null, 1);
            db.addOrder(username, ednome.getText().toString(), edendereco.getText().toString(), edcontato.getText().toString(), Integer.parseInt(edpincode.getText().toString()), date.toString(), time.toString(), Float.parseFloat(price[1].toString()), "medicine");
            db.removeCart(username, "lab");
            Toast.makeText(getApplicationContext(), "Seu pedido foi feito com sucesso", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(BuyMedicineBookActivity.this, HomeActivity.class));
        });
    }
}


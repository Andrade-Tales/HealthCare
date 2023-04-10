package com.med.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LabTestBookActivity extends AppCompatActivity {

    EditText ednome, edendereco, edcontato, edpincode;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);

        ednome = findViewById(R.id.editTextLTBNomeCompleto);
        edendereco = findViewById(R.id.editTextLTBEndereco);
        edcontato = findViewById(R.id.editTextLTBContato);
        edpincode = findViewById(R.id.editTextLTBPinCode);
        btnRegistrar = findViewById(R.id.buttonLTBRegistrar);

        Intent intent = getIntent();
        String[] price = intent.getStringExtra("preço").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("data");
        String time = intent.getStringExtra("tempo");

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();

                Database db = new Database(getApplicationContext(), "healthcare", null, 1);
                db.addOrder(username, ednome.getText().toString(), edendereco.getText().toString(), edcontato.getText().toString(), Integer.parseInt(edpincode.getText().toString()), date.toString(), time.toString(), Float.parseFloat(price[1].toString()), "lab");
                db.removeCart(username, "lab");
                Toast.makeText(getApplicationContext(), "Seu pedido foi feito com sucesso", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabTestBookActivity.this, HomeActivity.class));
            }
        });
    }
}
package com.med.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private final String[][] packages =
            {
                    {"Pacote 1 : Check-up completo", "", "", "", "150"},
                    {"Pacote 2 : Teste de glicemia", "", "", "", "60"},
                    {"Pacote 3 : Teste de covid-19", "", "", "", "25"},
                    {"Pacote 4 : Teste de tireoide", "", "", "", "55"},
                    {"Pacote 5 : Teste de imunidade", "", "", "", "35"}
            };

    private final String[] details_packages = {
            "Teste de glicemia\n" +
                    "Hemograma completo\n" +
                    "HBAC1\n" +
                    "Teste de função renal\n" +
                    "Teste de lactato desidrogenase, soro\n" +
                    "Perfil lipídico\n" +
                    "Teste de função de prata",
            "Teste de glicemia",
            "Teste de convid-19",
            "Teste de Tireoide completo (T3, T4 & TSH ultra-sensível)",
            "Hemograma completo\n" +
                    "PCR (Proteína C Reativa) quantitativa, soro\n" +
                    "Teste de função de prata\n" +
                    "Teste de função renal\n" +
                    "Vitamina D total-25 hidroxi\n" +
                    "Teste de função hepática\n" +
                    "Perfil lipídico"

    };

    HashMap<String, String> item;
    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;
    Button btnCarrinho, btnVoltar;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnCarrinho = findViewById(R.id.botaoLTCarrinho);
        btnVoltar = findViewById(R.id.botaoLTVoltar);
        listView = findViewById(R.id.listaViewLT);

        btnVoltar.setOnClickListener(v -> startActivity(new Intent(LabTestActivity.this, HomeActivity.class)));


        list = new ArrayList<>();
        for (String[] pacote : packages) {
            item = new HashMap<String, String>();
            item.put("line1", pacote[0]);
            item.put("line2", pacote[1]);
            item.put("line3", pacote[2]);
            item.put("line4", pacote[3]);
            item.put("line5", "Valor: " + pacote[4] + " R$");
            list.add(item);

        }

        sa = new SimpleAdapter(this, list, R.layout.multi_lines, new String[]{"line1", "line2", "line3", "line4", "line5"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
            it.putExtra("text1", packages[i][0]);
            it.putExtra("text2", details_packages[i]);
            it.putExtra("text3", packages[i][4]);
            startActivity(it);
        });

        btnCarrinho.setOnClickListener(view -> startActivity(new Intent(LabTestActivity.this, CartLabActivity.class)));
    }

}

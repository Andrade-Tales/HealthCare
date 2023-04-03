package com.med.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LabTestActivity extends AppCompatActivity {

    private String[][] pacotes =
            {
                    {"Pacote 1 : Check-up completo", "", "", "", "999"},
                    {"Pacote 2 : Teste de glicemia", "", "", "", "299"},
                    {"Pacote 3 : Teste de covid-19", "", "", "", "899"},
                    {"Pacote 4 : Teste de tireoide", "", "", "", "499"},
                    {"Pacote 5 : Teste de imunidade", "", "", "", "699"}
            };

    private String[] detalhes_pacote = {
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
    ArrayList lista;
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


        lista = new ArrayList();
        for (int i = 0; i < pacotes.length; i++) {
            item = new HashMap<String, String>();
            item.put("linha1", pacotes[i][0]);
            item.put("linha2", pacotes[i][1]);
            item.put("linha3", pacotes[i][2]);
            item.put("linha4", pacotes[i][3]);
            item.put("linha5", "Total: " + pacotes[i][4] + " R$");
            lista.add(item);

        }

        sa = new SimpleAdapter(this, lista, R.layout.multi_lines, new String[]{"linha1", "linha2", "linha3", "linha4", "linha5"}, new int[]{R.id.linha_a, R.id.linha_b, R.id.linha_c, R.id.linha_d, R.id.linha_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this, LabTestDetalhesActivity.class);
                it.putExtra("text1", pacotes[i][0]);
                it.putExtra("text2", detalhes_pacote[i]);
                it.putExtra("text3", pacotes[i][4]);
                startActivity(it);
            }
        });

        btnCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, CartLabActivity.class));
            }
        });
    }

}

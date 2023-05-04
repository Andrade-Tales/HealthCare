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

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Cápsula Uprise-D3 100UI", "", "", "", "50"},
                    {"HealthVit 200mcg Cápsula", "", "", "", "45"},
                    {"Cápsulas vitamina B", "", "", "", "65"},
                    {"Inlife Vitamina E", "", "", "", "90"},
                    {"Dolo 650 Tablet", "", "", "", "30"},
                    {"Crocin 650 Advance Tablet", "", "", "", "50"},
                    {"Pastilhas Strepsils para garganta", "", "", "", "40"},
                    {"Tata 1mg Cálcio + Vitamina D3", "", "", "", "30"},
                    {"Feronia - XT Tablet", "", "", "", "130"},
            };
    private String[] package_details = {
            "Construindo e mantendo os ossos e dentes fortes\n" +
                    "Reduzindo a fadiga/estresse e dores musculares\n" +
                    "Aumentar a imunidade e aumentar a resistência contra infecções",
            "O cromo é um mineral essencial que desempenha um papel importante em ajudar a insulina a regular a glicose no sangue.",
            "Fornece alívio de deficiências de vitamina B\n" +
                    "Ajuda na formação de glóbulos vermelhos\n" +
                    "Mantém o sistema nervoso saudável",
            "Promove a saúde, bem como benefícios para a pele.\n" +
                    "Ajuda a reduzir manchas e pigmentação da pele.\n" +
                    "Ele age como uma proteção da pele contra os raios solares UVA e UVB agressivos.",
            "Dolo 650 Tablet ajuda a aliviar dores e febre bloqueando a liberação de certos mensageiros químicos responsáveis por febre e dor.",
            "Ajuda a aliviar a febre e baixar a temperatura alta\n" +
                    "Adequado para pessoas com problemas cardíacos ou pressão alta",
            "Alivia os sintomas de uma infecção bacteriana na garganta e facilita o processo de recuperação\n" +
                    "Fornece uma sensação quente e reconfortante durante a dor de garganta",
            "Reduz o risco de deficiência de cálcio, raquitismo e osteoporose\n" +
                    "Promove a mobilidade e flexibilidade das articulações",
            "Ajuda a reduzir a deficiência de ferro devido à perda crônica de sangue ou baixa ingestão de ferro"
    };

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnVoltar, btnCarrinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listaViewBM);
        btnVoltar = findViewById(R.id.botaoBMVoltar);
        btnCarrinho = findViewById(R.id.botaoBMCarrinho);

        btnVoltar.setOnClickListener(v -> {
            startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
        });

        btnCarrinho.setOnClickListener(v -> {
            startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class));
        });

        list = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Valor: " + packages[i][4] + " R$");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list, R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e
                });
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }

        });
    }
}
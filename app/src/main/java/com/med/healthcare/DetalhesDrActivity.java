package com.med.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DetalhesDrActivity extends AppCompatActivity {

    private final String[][] dr_detlhes1 = {
            {"Dr : André Santos", "Atende : Hospital Estadual Mário Covas", "Exp: 5 anos", "Cel: 9898989898", "600"},
            {"Dr : Maria Fernandes", "Atende : Hospital Geral de Pirajussara", "Exp: 15 anos", "Cel: 7898989898", "900"},
            {"Dr : Augusto Almeida", "Atende : Hospital Regional de Jundiaí", "Exp: 8 anos", "Cel: 8898989898", "300"},
            {"Dr : Elisa Duarte", "Atende : Hospital Regional de São José dos Campos", "Exp: 6 anos", "Cel: 9898000000", "500"},
            {"Dr : Silvia de Fátima", "Atende : Hospital Regional do Sertão Central", "Exp: 7 anos", "Cel: 9898989898", "800"}
    };

    private final String[][] dr_detlhes2 = {
            {"Dr : André Santos", "Atende : Hospital Estadual Mário Covas", "Exp: 5 anos", "Cel: 9898989898", "600"},
            {"Dr : Maria Fernandes", "Atende : Hospital Geral de Pirajussara", "Exp: 15 anos", "Cel: 7898989898", "900"},
            {"Dr : Augusto Almeida", "Atende : Hospital Regional de Jundiaí", "Exp: 8 anos", "Cel: 8898989898", "300"},
            {"Dr : Elisa Duarte", "Atende : Hospital Regional de São José dos Campos", "Exp: 6 anos", "Cel: 9898000000", "500"},
            {"Dr : Silvia de Fátima", "Atende : Hospital Regional do Sertão Central", "Exp: 7 anos", "Cel: 9898989898", "800"}
    };

    private final String[][] dr_detlhes3 = {
            {"Dr : André Santos", "Atende : Hospital Estadual Mário Covas", "Exp: 5 anos", "Cel: 9898989898", "600"},
            {"Dr : Maria Fernandes", "Atende : Hospital Geral de Pirajussara", "Exp: 15 anos", "Cel: 7898989898", "900"},
            {"Dr : Augusto Almeida", "Atende : Hospital Regional de Jundiaí", "Exp: 8 anos", "Cel: 8898989898", "300"},
            {"Dr : Elisa Duarte", "Atende : Hospital Regional de São José dos Campos", "Exp: 6 anos", "Cel: 9898000000", "500"},
            {"Dr : Silvia de Fátima", "Atende : Hospital Regional do Sertão Central", "Exp: 7 anos", "Cel: 9898989898", "800"}
    };

    private final String[][] dr_detlhes4 = {
            {"Dr : André Santos", "Atende : Hospital Estadual Mário Covas", "Exp: 5 anos", "Cel: 9898989898", "600"},
            {"Dr : Maria Fernandes", "Atende : Hospital Geral de Pirajussara", "Exp: 15 anos", "Cel: 7898989898", "900"},
            {"Dr : Augusto Almeida", "Atende : Hospital Regional de Jundiaí", "Exp: 8 anos", "Cel: 8898989898", "300"},
            {"Dr : Elisa Duarte", "Atende : Hospital Regional de São José dos Campos", "Exp: 6 anos", "Cel: 9898000000", "500"},
            {"Dr : Silvia de Fátima", "Atende : Hospital Regional do Sertão Central", "Exp: 7 anos", "Cel: 9898989898", "800"}
    };

    private final String[][] dr_detlhes5 = {
            {"Dr : André Santos", "Atende : Hospital Estadual Mário Covas", "Exp: 5 anos", "Cel: 9898989898", "600"},
            {"Dr : Maria Fernandes", "Atende : Hospital Geral de Pirajussara", "Exp: 15 anos", "Cel: 7898989898", "900"},
            {"Dr : Augusto Almeida", "Atende : Hospital Regional de Jundiaí", "Exp: 8 anos", "Cel: 8898989898", "300"},
            {"Dr : Elisa Duarte", "Atende : Hospital Regional de São José dos Campos", "Exp: 6 anos", "Cel: 9898000000", "500"},
            {"Dr : Silvia de Fátima", "Atende : Hospital Regional do Sertão Central", "Exp: 7 anos", "Cel: 9898989898", "800"}
    };

    TextView tv;
    Button btn;
    String[][] dr_detalhes = {};
    HashMap<String, String> item;
    ArrayList<HashMap<String, String>> lista;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr_detalhes);

        tv = findViewById(R.id.textViewDDTitulo);
        btn = findViewById(R.id.botaoDDVoltar);

        Intent it = getIntent();
        String titulo = it.getStringExtra("titulo");
        tv.setText(titulo);

        if (titulo.compareTo("Psicólogo") == 0)
            dr_detalhes = dr_detlhes1;
        else if (titulo.compareTo("Nutricionista") == 0)
            dr_detalhes = dr_detlhes2;
        else if (titulo.compareTo("Cirurgião") == 0)
            dr_detalhes = dr_detlhes3;
        else if (titulo.compareTo("Dentista") == 0)
            dr_detalhes = dr_detlhes4;
        else
            dr_detalhes = dr_detlhes5;


        btn.setOnClickListener(v -> startActivity(new Intent(DetalhesDrActivity.this, EspecialidadeActivity.class)));

        lista = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < dr_detalhes.length; i++) {
            item = new HashMap<String, String>();
            item.put("linha1", dr_detalhes[i][0]);
            item.put("linha2", dr_detalhes[i][1]);
            item.put("linha3", dr_detalhes[i][2]);
            item.put("linha4", dr_detalhes[i][3]);
            item.put("linha5", "Valor: " + dr_detalhes[i][4] + " R$");
            lista.add(item);
        }
        sa = new SimpleAdapter(this, lista,
                R.layout.multi_lines,
                new String[]{"linha1", "linha2", "linha3", "linha4", "linha5"},
                new int[]{R.id.linha_a, R.id.linha_b, R.id.linha_c, R.id.linha_d, R.id.linha_e});
        ListView lst = findViewById(R.id.listaViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent it1 = new Intent(DetalhesDrActivity.this, LivroDeAgendamentoActivity.class);
            it1.putExtra("text1", titulo);
            it1.putExtra("text2", dr_detalhes[i][0]);
            it1.putExtra("text3", dr_detalhes[i][1]);
            it1.putExtra("text4", dr_detalhes[i][3]);
            it1.putExtra("text5", dr_detalhes[i][4]);
            startActivity(it1);
        });
    }
}
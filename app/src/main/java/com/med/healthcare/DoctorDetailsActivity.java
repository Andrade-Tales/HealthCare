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

public class DoctorDetailsActivity extends AppCompatActivity {

    private final String[][] dr_detalhes1 = {{"Dr : André Santos", "Atende : Hospital Estadual Mário Covas", "Exp: 5 anos", "Cel: 9898989898", "150"}, {"Dr : Maria Carmem", "Atende : Hospital Geral de Pirajussara", "Exp: 15 anos", "Cel: 7898989898", "300"}, {"Dr : Augusto Almeida", "Atende : Hospital Regional de Jundiaí", "Exp: 8 anos", "Cel: 8898989898", "125"}, {"Dr : Elisa Almeida", "Atende : Hospital Regional de São José dos Campos", "Exp: 6 anos", "Cel: 9898000000", "160"}, {"Dr : Silvia de Fátima", "Atende : Hospital Regional do Sertão Central", "Exp: 7 anos", "Cel: 9898989898", "160"}};

    private final String[][] dr_detalhes2 = {{"Dr : Pedro Costa", "Atende : Hospital Estadual Mário Covas", "Exp: 7 anos", "Cel: 9898989898", "200"}, {"Dr : Elias Faria", "Atende : Hospital Geral de Pirajussara", "Exp: 9 anos", "Cel: 7898989898", "100"}, {"Dr : Lucas Ferreira", "Atende : Hospital Regional de Jundiaí", "Exp: 10 anos", "Cel: 8898989898", "65"}, {"Dr : Ana Clara", "Atende : Hospital Regional de São José dos Campos", "Exp: 10 anos", "Cel: 9898000000", "155"}, {"Dr : Bianca Antunes", "Atende : Hospital Regional do Sertão Central", "Exp: 10 anos", "Cel: 9898989898", "75"}};

    private final String[][] dr_detalhes3 = {{"Dr : Lúcia Tavares", "Atende : Hospital Estadual Mário Covas", "Exp: 4 anos", "Cel: 9898989898", "60"}, {"Dr : Thiago Antunes", "Atende : Hospital Geral de Pirajussara", "Exp: 12 anos", "Cel: 7898989898", "125"}, {"Dr : Roberto Augusto", "Atende : Hospital Regional de Jundiaí", "Exp: 6 anos", "Cel: 8898989898", "110"}, {"Dr : Yasmin Ferreira", "Atende : Hospital Regional de São José dos Campos", "Exp: 8 anos", "Cel: 9898000000", "85"}, {"Dr : Gabriel Oliveira", "Atende : Hospital Regional do Sertão Central", "Exp: 8 anos", "Cel: 9898989898", "60"}};

    private final String[][] dr_detalhes4 = {{"Dr : Ricardo Souza", "Atende : Hospital Estadual Mário Covas", "Exp: 9 anos", "Cel: 9898989898", "80"}, {"Dr : Márcia Fernandes", "Atende : Hospital Geral de Pirajussara", "Exp: 6 anos", "Cel: 7898989898", "160"}, {"Dr : Carmem Farias", "Atende : Hospital Regional de Jundiaí", "Exp: 11 anos", "Cel: 8898989898", "90"}, {"Dr : Fernando Luiz", "Atende : Hospital Regional de São José dos Campos", "Exp: 12 anos", "Cel: 9898000000", "70"}, {"Dr : Fátima Fernandes", "Atende : Hospital Regional do Sertão Central", "Exp: 6 anos", "Cel: 9898989898", "120"}};

    private final String[][] dr_detalhes5 = {{"Dr : Ana Farias", "Atende : Hospital Estadual Mário Covas", "Exp: 10 anos", "Cel: 9898989898", "120"}, {"Dr : Eduarda Cavalcante", "Atende : Hospital Geral de Pirajussara", "Exp: 7 anos", "Cel: 7898989898", "75"}, {"Dr : Eliza Duarte", "Atende : Hospital Regional de Jundiaí", "Exp: 7 anos", "Cel: 8898989898", "85"}, {"Dr : Marina Fernandes", "Atende : Hospital Regional de São José dos Campos", "Exp: 5 anos", "Cel: 9898000000", "95"}, {"Dr : Eliseu Costa", "Atende : Hospital Regional do Sertão Central", "Exp: 11 anos", "Cel: 9898989898", "85"}};

    TextView tv;
    Button btn;
    String[][] dr_detalhes = {};
    HashMap<String, String> item;
    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitulo);
        btn = findViewById(R.id.botaoDDVoltar);

        Intent it = getIntent();
        String titulo = it.getStringExtra("titulo");
        tv.setText(titulo);

        if (titulo.compareTo("Psicólogo") == 0) dr_detalhes = dr_detalhes1;
        else if (titulo.compareTo("Nutricionista") == 0) dr_detalhes = dr_detalhes2;
        else if (titulo.compareTo("Cirurgião") == 0) dr_detalhes = dr_detalhes3;
        else if (titulo.compareTo("Dentista") == 0) dr_detalhes = dr_detalhes4;
        else dr_detalhes = dr_detalhes5;


        btn.setOnClickListener(v -> startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class)));

        list = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < dr_detalhes.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", dr_detalhes[i][0]);
            item.put("line2", dr_detalhes[i][1]);
            item.put("line3", dr_detalhes[i][2]);
            item.put("line4", dr_detalhes[i][3]);
            item.put("line5", "Valor: " + dr_detalhes[i][4] + " R$");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list, R.layout.multi_lines, new String[]{"line1", "line2", "line3", "line4", "line5"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        ListView lst = findViewById(R.id.listaViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent it1 = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
            it1.putExtra("text1", titulo);
            it1.putExtra("text2", dr_detalhes[i][0]);
            it1.putExtra("text3", dr_detalhes[i][1]);
            it1.putExtra("text4", dr_detalhes[i][3]);
            it1.putExtra("text5", dr_detalhes[i][4]);
            startActivity(it1);
        });
    }
}
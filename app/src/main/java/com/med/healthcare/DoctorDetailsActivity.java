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

    private final String[][] dr_detalhes1 = {{"Dr : André Santos", "Atende : Hospital Estadual Mário Covas", "Exp: 5 anos", "Cel: 9898989898", "600"}, {"Dr : Maria Fernandes", "Atende : Hospital Geral de Pirajussara", "Exp: 15 anos", "Cel: 7898989898", "900"}, {"Dr : Augusto Almeida", "Atende : Hospital Regional de Jundiaí", "Exp: 8 anos", "Cel: 8898989898", "300"}, {"Dr : Elisa Duarte", "Atende : Hospital Regional de São José dos Campos", "Exp: 6 anos", "Cel: 9898000000", "500"}, {"Dr : Silvia de Fátima", "Atende : Hospital Regional do Sertão Central", "Exp: 7 anos", "Cel: 9898989898", "800"}};

    private final String[][] dr_detalhes2 = {{"Dr : André Santos", "Atende : Hospital Estadual Mário Covas", "Exp: 5 anos", "Cel: 9898989898", "600"}, {"Dr : Maria Fernandes", "Atende : Hospital Geral de Pirajussara", "Exp: 15 anos", "Cel: 7898989898", "900"}, {"Dr : Augusto Almeida", "Atende : Hospital Regional de Jundiaí", "Exp: 8 anos", "Cel: 8898989898", "300"}, {"Dr : Elisa Duarte", "Atende : Hospital Regional de São José dos Campos", "Exp: 6 anos", "Cel: 9898000000", "500"}, {"Dr : Silvia de Fátima", "Atende : Hospital Regional do Sertão Central", "Exp: 7 anos", "Cel: 9898989898", "800"}};

    private final String[][] dr_detalhes3 = {{"Dr : André Santos", "Atende : Hospital Estadual Mário Covas", "Exp: 5 anos", "Cel: 9898989898", "600"}, {"Dr : Maria Fernandes", "Atende : Hospital Geral de Pirajussara", "Exp: 15 anos", "Cel: 7898989898", "900"}, {"Dr : Augusto Almeida", "Atende : Hospital Regional de Jundiaí", "Exp: 8 anos", "Cel: 8898989898", "300"}, {"Dr : Elisa Duarte", "Atende : Hospital Regional de São José dos Campos", "Exp: 6 anos", "Cel: 9898000000", "500"}, {"Dr : Silvia de Fátima", "Atende : Hospital Regional do Sertão Central", "Exp: 7 anos", "Cel: 9898989898", "800"}};

    private final String[][] dr_detalhes4 = {{"Dr : André Santos", "Atende : Hospital Estadual Mário Covas", "Exp: 5 anos", "Cel: 9898989898", "600"}, {"Dr : Maria Fernandes", "Atende : Hospital Geral de Pirajussara", "Exp: 15 anos", "Cel: 7898989898", "900"}, {"Dr : Augusto Almeida", "Atende : Hospital Regional de Jundiaí", "Exp: 8 anos", "Cel: 8898989898", "300"}, {"Dr : Elisa Duarte", "Atende : Hospital Regional de São José dos Campos", "Exp: 6 anos", "Cel: 9898000000", "500"}, {"Dr : Silvia de Fátima", "Atende : Hospital Regional do Sertão Central", "Exp: 7 anos", "Cel: 9898989898", "800"}};

    private final String[][] dr_detalhes5 = {{"Dr : André Santos", "Atende : Hospital Estadual Mário Covas", "Exp: 5 anos", "Cel: 9898989898", "600"}, {"Dr : Maria Fernandes", "Atende : Hospital Geral de Pirajussara", "Exp: 15 anos", "Cel: 7898989898", "900"}, {"Dr : Augusto Almeida", "Atende : Hospital Regional de Jundiaí", "Exp: 8 anos", "Cel: 8898989898", "300"}, {"Dr : Elisa Duarte", "Atende : Hospital Regional de São José dos Campos", "Exp: 6 anos", "Cel: 9898000000", "500"}, {"Dr : Silvia de Fátima", "Atende : Hospital Regional do Sertão Central", "Exp: 7 anos", "Cel: 9898989898", "800"}};

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
package com.med.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private final String[][] doctor_details1 = {
            {"Dr : André Santos", "Atende : Hospital Estadual Mário Covas", "Exp: 5 anos", "Cel: 9898989898", "600"},
            {"Dr : Maria Fernandes", "Atende : Hospital Geral de Pirajussara", "Exp: 15 anos", "Cel: 7898989898", "900"},
            {"Dr : Augusto Almeida", "Atende : Hospital Regional de Jundiaí", "Exp: 8 anos", "Cel: 8898989898", "300"},
            {"Dr : Elisa Duarte", "Atende : Hospital Regional de São José dos Campos", "Exp: 6 anos", "Cel: 9898000000", "500"},
            {"Dr : Silvia de Fátima", "Atende : Hospital Regional do Sertão Central", "Exp: 7 anos", "Cel: 9898989898", "800"}
    };

    private final String[][] doctor_details2 = {
            {"Dr : André Santos", "Atende : Hospital Estadual Mário Covas", "Exp: 5 anos", "Cel: 9898989898", "600"},
            {"Dr : Maria Fernandes", "Atende : Hospital Geral de Pirajussara", "Exp: 15 anos", "Cel: 7898989898", "900"},
            {"Dr : Augusto Almeida", "Atende : Hospital Regional de Jundiaí", "Exp: 8 anos", "Cel: 8898989898", "300"},
            {"Dr : Elisa Duarte", "Atende : Hospital Regional de São José dos Campos", "Exp: 6 anos", "Cel: 9898000000", "500"},
            {"Dr : Silvia de Fátima", "Atende : Hospital Regional do Sertão Central", "Exp: 7 anos", "Cel: 9898989898", "800"}
    };

    private final String[][] doctor_details3 = {
            {"Dr : André Santos", "Atende : Hospital Estadual Mário Covas", "Exp: 5 anos", "Cel: 9898989898", "600"},
            {"Dr : Maria Fernandes", "Atende : Hospital Geral de Pirajussara", "Exp: 15 anos", "Cel: 7898989898", "900"},
            {"Dr : Augusto Almeida", "Atende : Hospital Regional de Jundiaí", "Exp: 8 anos", "Cel: 8898989898", "300"},
            {"Dr : Elisa Duarte", "Atende : Hospital Regional de São José dos Campos", "Exp: 6 anos", "Cel: 9898000000", "500"},
            {"Dr : Silvia de Fátima", "Atende : Hospital Regional do Sertão Central", "Exp: 7 anos", "Cel: 9898989898", "800"}
    };

    private final String[][] doctor_details4 = {
            {"Dr : André Santos", "Atende : Hospital Estadual Mário Covas", "Exp: 5 anos", "Cel: 9898989898", "600"},
            {"Dr : Maria Fernandes", "Atende : Hospital Geral de Pirajussara", "Exp: 15 anos", "Cel: 7898989898", "900"},
            {"Dr : Augusto Almeida", "Atende : Hospital Regional de Jundiaí", "Exp: 8 anos", "Cel: 8898989898", "300"},
            {"Dr : Elisa Duarte", "Atende : Hospital Regional de São José dos Campos", "Exp: 6 anos", "Cel: 9898000000", "500"},
            {"Dr : Silvia de Fátima", "Atende : Hospital Regional do Sertão Central", "Exp: 7 anos", "Cel: 9898989898", "800"}
    };

    private final String[][] doctor_details5 = {
            {"Dr : André Santos", "Atende : Hospital Estadual Mário Covas", "Exp: 5 anos", "Cel: 9898989898", "600"},
            {"Dr : Maria Fernandes", "Atende : Hospital Geral de Pirajussara", "Exp: 15 anos", "Cel: 7898989898", "900"},
            {"Dr : Augusto Almeida", "Atende : Hospital Regional de Jundiaí", "Exp: 8 anos", "Cel: 8898989898", "300"},
            {"Dr : Elisa Duarte", "Atende : Hospital Regional de São José dos Campos", "Exp: 6 anos", "Cel: 9898000000", "500"},
            {"Dr : Silvia de Fátima", "Atende : Hospital Regional do Sertão Central", "Exp: 7 anos", "Cel: 9898989898", "800"}
    };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Psicólogo") == 0)
            doctor_details = doctor_details1;
        else if (title.compareTo("Nutricionista") == 0)
            doctor_details = doctor_details2;
        else if (title.compareTo("Cirurgião") == 0)
            doctor_details = doctor_details3;
        else if (title.compareTo("Dentista") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, EspecialidadeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Taxas : " + doctor_details[i][4] + "/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, LivroDeAgendamentoActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);
            }

        });
    }
}
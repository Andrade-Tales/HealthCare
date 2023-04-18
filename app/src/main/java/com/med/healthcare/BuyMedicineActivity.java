package com.med.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Cápsula Uprise-D3 100UI", "", "", "", "50"},
                    {"HealthVit Chromium Picolinate 200mcg Capsule", "", "", "", "305"},
                    {"Cápsulas do complexo de vitamina B", "", "", "", "448"},
                    {"Inlife Vitamin E Wheat Germ Oil Capsule", "", "", "", "539"},
                    {"Dolo 650 Tablet", "", "", "", "30"},
                    {"Crocin 650 Advance Tablet", "", "", "", "50"},
                    {"Pastilhas medicamentosas Strepsils para dor de garganta", "", "", "", "40"},
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);
    }
}
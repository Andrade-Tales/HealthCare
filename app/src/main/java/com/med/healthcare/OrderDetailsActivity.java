package com.med.healthcare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderDetailsActivity extends AppCompatActivity {

    private String[][] order_details = {};

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        btn = findViewById(R.id.botaoODVoltar);
        lst = findViewById(R.id.listaViewOD);

        btn.setOnClickListener(v -> startActivity(new Intent(OrderDetailsActivity.this, HomeActivity.class)));

        Database db = new Database(getApplicationContext(), "healthcare", null, 1);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "").toString();
        ArrayList dbData = db.getOrderData(username);

        order_details = new String[dbData.size()][];
        for (int i = 0; i < order_details.length; i++) {
            order_details[i] = new String[5];
            String arrData = dbData.get(i).toString();
            String[] strData = arrData.split(java.util.regex.Pattern.quote("$"));
            order_details[i][0] = strData[0];
            order_details[i][1] = strData[1]; // +" " + strData[3];
            if (strData[7].compareTo("medicine") == 0) {
                order_details[i][3] = "Del:" + strData[4];
            } else {
                order_details[i][3] = "Del:" + strData[4] + " " + strData[5];
            }
            order_details[i][2] = "Rs." + strData[6];
            order_details[i][4] = strData[7];
        }

        list = new ArrayList<>();
        for (int i = 0; i < order_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("linha1", order_details[i][0]);
            item.put("linha2", order_details[i][1]);
            item.put("linha3", order_details[i][2]);
            item.put("linha4", order_details[i][3]);
            item.put("linha5", order_details[i][4]);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list, R.layout.multi_lines, new String[]
                {"linha1", "linha2", "linha3", "linha4", "linha5"},
                new int[] {R.id.linha_a, R.id.linha_b, R.id.linha_c, R.id.linha_d, R.id.linha_e});
        lst.setAdapter(sa);
    }
}
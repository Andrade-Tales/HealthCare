package com.med.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class CartLabActivity extends AppCompatActivity {

    HashMap<String, String> item;
    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;
    TextView tvTotal;
    ListView lst;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Button dateButton, timeButton, btnCheckout, btnBack;
    private String[][] packages = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_lab);

        dateButton = findViewById(R.id.buttonCLLivroData);
        timeButton = findViewById(R.id.buttonCLLivroTime);
        btnCheckout = findViewById(R.id.buttonCLLivroCheckout);
        btnBack = findViewById(R.id.buttonCLLivroVoltar);
        tvTotal = findViewById(R.id.textViewCLTotal);
        lst = findViewById(R.id.listaViewCL);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "").toString();

        Database db = new Database(getApplicationContext(), "healthcare", null, 1);

        float totalAmount = 0;
        ArrayList dbData = db.getCartData(username, "lab");
        //Toast.makeText(getApplicationContext(), "" + dbData, Toast.LENGTH_LONG).show();

        packages = new String[dbData.size()][];
        for (int i = 0; i < packages.length; i++) {
            packages[i] = new String[5];
        }

        for (int i = 0; i < dbData.size(); i++) {
            String arrData = dbData.get(i).toString();
            String[] strData = arrData.split(java.util.regex.Pattern.quote("$"));
            packages[i][0] = strData[0];
            packages[i][4] = "Valor : " + strData[1] + "R$";
            totalAmount = totalAmount + Float.parseFloat(strData[1]);
        }

        tvTotal.setText("Total : " + totalAmount);

        list = new ArrayList<>();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("linha1", packages[i][0]);
            item.put("linha2", packages[i][1]);
            item.put("linha3", packages[i][2]);
            item.put("linha4", packages[i][3]);
            item.put("linha5", packages[i][4]);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list, R.layout.multi_lines, new String[]{"linha1", "linha2", "linha3", "linha4", "linha5"}, new int[]{R.id.linha_a, R.id.linha_b, R.id.linha_c, R.id.linha_d, R.id.linha_e});
        lst.setAdapter(sa);

        btnBack.setOnClickListener(view -> startActivity(new Intent(CartLabActivity.this, LabTestActivity.class)));

        btnCheckout.setOnClickListener(view -> {
            Intent it = new Intent(CartLabActivity.this, LabTestBookActivity.class);
            it.putExtra("price", tvTotal.getText());
            it.putExtra("date", dateButton.getText());
            it.putExtra("time", timeButton.getText());
            startActivity(it);
        });

        // DATEPICKER
        initDatePicker();
        dateButton.setOnClickListener(view -> datePickerDialog.show());

        // TIMEPICKER
        initTimePicker();
        timeButton.setOnClickListener(view -> timePickerDialog.show());
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = (datePicker, i, i1, i2) -> {
            i1 = i1 + 1;
            dateButton.setText(i2 + "/" + i1 + "/" + i);
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis() + 86400000);
    }

    private void initTimePicker() {

        TimePickerDialog.OnTimeSetListener timeSetListener = (timePicker, i, i1) -> timeButton.setText(i + ":" + i1);

        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR);
        int mins = cal.get(Calendar.MINUTE);

        int style = AlertDialog.THEME_HOLO_DARK;
        timePickerDialog = new TimePickerDialog(this, style, timeSetListener, hrs, mins, true);
    }
}
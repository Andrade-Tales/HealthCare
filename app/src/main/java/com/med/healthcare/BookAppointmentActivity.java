package com.med.healthcare;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4;
    TextView tv;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Button dateButton, timeButton, buttonAgendar, buttonVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        tv = findViewById(R.id.textViewLivro);
        ed1 = findViewById(R.id.editTextLivroNomeCompleto);
        ed2 = findViewById(R.id.editTextLivroEndereco);
        ed3 = findViewById(R.id.editTextLivroNumeroDeContato);
        ed4 = findViewById(R.id.editTextLivroTarifa);
        dateButton = findViewById(R.id.buttonLivroData);
        timeButton = findViewById(R.id.buttonLivroTime);
        buttonAgendar = findViewById(R.id.buttonLivroAgendar);
        buttonVoltar = findViewById(R.id.buttonLivroVoltar);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String fullname = it.getStringExtra("text2");
        String address = it.getStringExtra("text3");
        String contact = it.getStringExtra("text4");
        String price = it.getStringExtra("text5");

        tv.setText(title);
        ed1.setText(fullname);
        ed2.setText(address);
        ed3.setText(contact);
        ed4.setText("R$: " + price);

        // DATEPICKER
        initDatePicker();
        dateButton.setOnClickListener(v -> datePickerDialog.show());

        //TIMEPICKER
        initTimePicker();
        timeButton.setOnClickListener(v -> timePickerDialog.show());

        buttonVoltar.setOnClickListener(v -> startActivity(new Intent(BookAppointmentActivity.this, FindDoctorActivity.class)));

        buttonAgendar.setOnClickListener(view -> {
            Database db = new Database(getApplicationContext(), "healthcare", null, 1);
            SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
            String username = sharedPreferences.getString("username", "").toString();
            if (db.checkAppointmentExists(username, " ", title + fullname, address, dateButton.getText().toString(), timeButton.getText().toString()) == 1) {
                Toast.makeText(getApplicationContext(), "Registro já inserido", Toast.LENGTH_SHORT).show();
            } else {
                db.addOrder(username, title + " " + fullname, address, contact, 0, dateButton.getText().toString(), timeButton.getText().toString(), Float.parseFloat(price), "appointment");
                Toast.makeText(getApplicationContext(), "Registro inserido com suceso!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BookAppointmentActivity.this, HomeActivity.class));
            }
        });
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = (view, i, i1, i2) -> {
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
package com.example.listthings;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.IslamicCalendar;
import android.os.Bundle;
import android.text.Editable;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class listadd extends AppCompatActivity {
    EditText etN,t;
    Button btnsave;
    TextView td, etT;
    RadioGroup rg;
    RadioButton RB;
    int ho, mi;
    TextView TV;
    DatePickerDialog.OnDateSetListener li;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listadd);
        etN = findViewById(R.id.etN);
        t=findViewById(R.id.t);

        etT = findViewById(R.id.etT);

        td = findViewById(R.id.td);
        rg = findViewById(R.id.rg);
        TV = findViewById(R.id.TV);

        btnsave = findViewById(R.id.btnsave);

        Calendar calendar = Calendar.getInstance();
        final int y = calendar.get(Calendar.YEAR);
        final int m = calendar.get(Calendar.MONTH);
        final int d = calendar.get(Calendar.DAY_OF_MONTH);


        td.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dp = new DatePickerDialog(listadd.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, li, y, m, d);
                dp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dp.show();
            }
        });

        li = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String de = d + "-" + m + "-" + y;
                td.setText(de);
            }
        };
        etT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog tp = new TimePickerDialog(listadd.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        ho = hourOfDay;
                        mi = minute;

                        Calendar calendar1 = Calendar.getInstance();
                        calendar1.set(0, 0, 0, ho, mi);
                        etT.setText(DateFormat.format("hh:mm aa", calendar1));
                    }
                }, 12, 0, false
                );
                tp.updateTime(ho, mi);
                tp.show();

            }
        });


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name, date, time,thng;
                Name = etN.getText().toString().trim();
                date = td.getText().toString().trim();
                time = etT.getText().toString().trim();
                thng=t.getText().toString().trim();
                int radioid = rg.getCheckedRadioButtonId();
                RB = findViewById(radioid);

                TV.setText(RB.getText());
                String i = TV.getText().toString().trim();

                if (Name.isEmpty()) {
                    etN.setError("name cannot be empty");
                } else {
                    Intent intent4 = new Intent();
                    intent4.putExtra("n", Name);
                    intent4.putExtra("d", date);
                    intent4.putExtra("t", time);
                    intent4.putExtra("pr", i);
                    intent4.putExtra("thi",thng);

                    setResult(RESULT_OK, intent4);
                    finish();
                }

            }

        });
    }

        public void checkbutton (View v)
        {
        int radioid = rg.getCheckedRadioButtonId();
        RB = findViewById(radioid);
        // Toast.makeText(this,RB.getText(), Toast.LENGTH_SHORT).show();
         }


}









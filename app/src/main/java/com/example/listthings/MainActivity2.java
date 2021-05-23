package com.example.listthings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView name,dat,time,thig;
    ImageButton btnb;
    RadioButton u;
    RadioGroup g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name=findViewById(R.id.name);
        dat=findViewById(R.id.dat);
        time=findViewById(R.id.time);
        btnb=findViewById(R.id.btnb);
        thig=findViewById(R.id.thig);
        g = findViewById(R.id.RG);
        int radio = g.getCheckedRadioButtonId();
        u= findViewById(radio);

        name.setText(getIntent().getStringExtra("keyn"));
        dat.setText(getIntent().getStringExtra("keyd"));
        time.setText(getIntent().getStringExtra("keyt"));
        thig.setText(getIntent().getStringExtra("keytg"));
        //u.setText(getIntent().getStringExtra("keyp"));


        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(t);
                finish();
            }
        });
    }
}
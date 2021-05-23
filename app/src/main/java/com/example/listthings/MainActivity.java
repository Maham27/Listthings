package com.example.listthings;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static com.example.listthings.listdata.l;

public class MainActivity extends AppCompatActivity implements personadaptor.listclick {
    ImageButton btnadd;
    TextView etDate;
    final int listadd = 1;
    lfrag lf;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<listinfo> l1;
    RecyclerView.Adapter myadptr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.r);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myadptr);
        btnadd = findViewById(R.id.btnadd);
        etDate=findViewById(R.id.etDate);


        Calendar calender= Calendar.getInstance();
        String cd= DateFormat.getDateInstance(DateFormat.FULL).format(calender.getTime());
        etDate.setText(cd);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, listadd.class);
                startActivityForResult(intent, listadd);

            }
        });
        l1=new ArrayList<>();

        //l1.add(new listinfo("maham","27-0-19999","2:22:30","red","study"));
        myadptr = new personadaptor(this, l1);
        recyclerView.setAdapter(myadptr);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == listadd) {
            if (resultCode == RESULT_OK) {
                String name1 = data.getStringExtra("n");
                String date1 = data.getStringExtra("d");
                String time1 = data.getStringExtra("t");
                String p1=data.getStringExtra("pr");
                String tg=data.getStringExtra("thi");

                l1.add(new listinfo(name1, date1, time1, p1,tg));
               myadptr.notifyDataSetChanged();

                //Toast.makeText(this,tg, Toast.LENGTH_SHORT).show();

            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "result not passed", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onlistclick(int index) {
        //Toast.makeText(this,l1.get(index).getName(), Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        i.putExtra("keyn", l1.get(index).getName());
        i.putExtra("keyd",l1.get(index).getDate());
        i.putExtra("keyt",l1.get(index).getTime());
        i.putExtra("keyp",l1.get(index).getP());
        i.putExtra("keytg",l1.get(index).getS());
        startActivity(i);
    }
}
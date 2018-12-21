package com.example.acer.reddoorzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Detail extends AppCompatActivity {

    Button b1,b2, b3, b4;
    Finish f;
    Ulasan u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

            b1 = (Button) findViewById(R.id.btn_fasilitas);
            b2 = (Button) findViewById(R.id.btn_lokasi);
            b3 = (Button) findViewById(R.id.btn_foto);
            b4 = (Button) findViewById(R.id.btn_lanjut);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), Fasilitas.class);
                    startActivity(i);
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), Lokasi.class);
                    startActivity(i);
                }
            });

            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), Foto.class);
                    startActivity(i);
                }
            });

            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(getApplicationContext(), Finish.class);
                    startActivity(i);

//                Ulasan u = new Ulasan();
//
//                Finish f = new Finish();
                }
            });
        }
}

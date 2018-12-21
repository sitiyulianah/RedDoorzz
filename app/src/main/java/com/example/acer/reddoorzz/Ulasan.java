package com.example.acer.reddoorzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ulasan extends AppCompatActivity {
    TextView tgl, tgl2;
    private String tanggal, tanggal2;
    private String KEY_TANGGAL = "TANGGAL";
    private String KEY_TANGGAL2 = "TANGGAL2";
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulasan);

        tgl = (TextView) findViewById(R.id.txt_jm_masuk);
        tgl2 = (TextView) findViewById(R.id.txt_jm_keluar);

        Intent i = getIntent();
        Bundle extras = getIntent().getExtras();
        tanggal = i.getStringExtra("tanggal");
        tgl.setText(tanggal);
        tanggal2 = i.getStringExtra("tanggal2");
        tgl2.setText(tanggal2);

            next = (Button) findViewById(R.id.btn_next);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), Detail.class);
                    startActivity(i);
                }
            });
        }
}

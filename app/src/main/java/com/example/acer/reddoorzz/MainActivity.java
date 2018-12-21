package com.example.acer.reddoorzz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instansiasi button login
//        Button btnlogin=(Button)findViewById(R.id.bt_login);
//        btnlogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                Intent i = new Intent(MainActivity.this, Login.class);
//                startActivity(i);
//            }
//        });
        b1 = (Button) findViewById(R.id.bt_login);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
            }
        });


        //instansiasi button create akun
        Button btncr=(Button)findViewById(R.id.bt_createakun);
        btncr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(MainActivity.this, Buatakun.class);
                startActivity(i);
            }
        });
    }
}

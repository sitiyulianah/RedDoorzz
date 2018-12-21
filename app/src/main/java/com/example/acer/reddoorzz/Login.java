package com.example.acer.reddoorzz;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    DataHelper dbHelper; //membuat variabel dbHelper dari class DataHelper
    private Button loginBut; //membuat atribut untuk button login dan button logout
    private EditText user, pass; //membuat atribut untuk edit text user dan password
    SessionManagement sessionManagement; //membuat variabel session dari class sessionManagement
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText) findViewById(R.id.userLogin); //instansiasi objek yang memanggil id edit text username
        pass = (EditText) findViewById(R.id.PasswordLogin); //instansiasi objek yang memanggil id edit text password

        dbHelper = new DataHelper(this); //instansiasi objek datahelper

        sessionManagement = new SessionManagement(Login.this);

        if (sessionManagement.isLoggedIn()) {
            Intent i = new Intent(getApplicationContext(), Home.class);
            startActivity(i);
        }
        loginBut = (Button) findViewById(R.id.buttonLogin); //instansiasi objek yang memanggil id button login

        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();

                b.putString("username", user.getText().toString()); //memanggil kolom nama pada sql
                b.putString("password", pass.getText().toString()); //memanggil kolom password pada sql
                if (CekLogin()) {
                    if (cekValidasi()) {
                        Toast.makeText(getApplicationContext(), "True", Toast.LENGTH_SHORT).show(); //membuat toast notifikasi login benar
                        Intent i = new Intent(getApplicationContext(), Home.class); //membut intent button login berpindah ke halaman Halo Activity
                        sessionManagement.createLoginSession(user.getText().toString(), pass.getText().toString()); //memanggil session untuk membaca username dan password
                        i.putExtras(b);
                        startActivity(i);
                        finish();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "You are not registed", Toast.LENGTH_SHORT).show(); //membuat noti
                }
            }
        });
    }

    public boolean CekLogin() {
        SessionManagement sessionManagement = new SessionManagement(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from biodata WHERE username='" + user.getText().toString() + "' and password='" + pass.getText().toString()+"'", null);
        sessionManagement.createLoginSession(user.getText().toString(), pass.getText().toString());

        if (cursor.getCount() > 0) return true;
        else return false;
    }

    public boolean cekValidasi() {
        if (user.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Fill the Username", Toast.LENGTH_SHORT).show();
            return false;
        } else if (pass.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Fill the Password", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}

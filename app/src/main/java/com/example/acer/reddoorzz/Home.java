package com.example.acer.reddoorzz;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Home extends AppCompatActivity {

    private String KEY_TANGGAL = "TANGGAL";
    private String KEY_TANGGAL2 = "TANGGAL2";
    private Button b1;
    private DatePickerDialog datePickerDialog, datePickerDialog2;
    private SimpleDateFormat dateFormatter;
    private TextView tvDateResult, tvDateResult2;
    private Button btDatePicker, btDatePicker2;
    private Button btnext;
    Button buttonLogout;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        buttonLogout = (Button) findViewById(R.id.btn_keluar);
        tvDateResult = (TextView) findViewById(R.id.tv_dateresult);
        btDatePicker = (Button) findViewById(R.id.bt_datepicker);
        tvDateResult2 = (TextView) findViewById(R.id.tv_dateresult2);
        btDatePicker2 = (Button) findViewById(R.id.bt_datepicker2);

        btDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

        btDatePicker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog2();
            }
        });

        btnext = (Button) findViewById(R.id.next);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tanggal = tvDateResult.getText().toString(); //instansiasi objek string untuk di parsing
                String tanggal2 = tvDateResult2.getText().toString(); //instansiasi objek string untuk di parsing
                Intent i = new Intent(Home.this, Ulasan.class);
                i.putExtra("tanggal", tanggal);
                i.putExtra("tanggal2", tanggal2);
                startActivity(i);
            }
        });

        sessionManagement = new SessionManagement(this);
        buttonLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Clear the session data
                // This will clear all session data and
                // redirect user to LoginActivity
                sessionManagement.logoutUser();
            }
        });
        }

        private void showDateDialog(){

            /**
             * Calendar untuk mendapatkan tanggal sekarang
             */
            Calendar newCalendar = Calendar.getInstance();

            /**
             * Initiate DatePicker dialog
             */
            datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    /**
                     * Method ini dipanggil saat kita selesai memilih tanggal di DatePicker
                     */

                    /**
                     * Set Calendar untuk menampung tanggal yang dipilih
                     */
                    Calendar newDate = Calendar.getInstance();
                    newDate.set(year, monthOfYear, dayOfMonth);

                    /**
                     * Update TextView dengan tanggal yang kita pilih
                     */
                    tvDateResult.setText("Check In : "+dateFormatter.format(newDate.getTime()));
                }

            },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

            /**
             * Tampilkan DatePicker dialog
             */
            datePickerDialog.show();

        }

        private void showDateDialog2()
        {

            Calendar newCalendar = Calendar.getInstance();
            datePickerDialog2 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    /**
                     * Method ini dipanggil saat kita selesai memilih tanggal di DatePicker
                     */

                    /**
                     * Set Calendar untuk menampung tanggal yang dipilih
                     */
                    Calendar newDate = Calendar.getInstance();
                    newDate.set(year, monthOfYear, dayOfMonth);

                    /**
                     * Update TextView dengan tanggal yang kita pilih
                     */
                    tvDateResult2.setText("Check Out : "+dateFormatter.format(newDate.getTime()));
                }

            },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

            /**
             * Tampilkan DatePicker dialog
             */
            datePickerDialog2.show();
        }




//        @BindView() w(R.id.btnOpenDatePicker)
//        Button btnOpenDatePicker;
//        @BindView(R.id.tvTanggal)
//        TextView tvTanggal;
//
//        Calendar myCalendar;
    }

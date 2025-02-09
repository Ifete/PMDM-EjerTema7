package com.example.ejertema7.ejer7_5;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ejertema7.R;
import com.example.ejertema7.ejer7_1y7_2.MainActivity;
import com.example.ejertema7.ejer7_3.Ejer7_3;
import com.example.ejertema7.ejer7_6.Ejer7_6_Intent;

import java.util.Calendar;

public class Ejer7_5_DatePicker extends AppCompatActivity {

    //Creamos el menú para ver los diferentes ejercicios
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_ejer7,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker);

        Button dateButton = findViewById(R.id.btnDatePicker);
        dateButton.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    (view, year1, month1, dayOfMonth) ->
                            Toast.makeText(Ejer7_5_DatePicker.this, "Fecha seleccionada: " + dayOfMonth + "/" + (month1 + 1) + "/" + year1, Toast.LENGTH_SHORT).show(),
                    year, month, day);
            datePickerDialog.show();
        });
    }

    //Opciones para cambiar la vista con el menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.ejer7_1:
                Intent abrirEjer7_1 = new Intent(this, MainActivity.class);
                this.startActivity(abrirEjer7_1);
                return false;
            case R.id.ejer7_3:
                Intent abrirEjer7_3 = new Intent(this, Ejer7_3.class);
                this.startActivity(abrirEjer7_3);
                return false;
            case R.id.ejer7_5:
                Intent abrirEjer7_5 = new Intent(this, Ejer7_5_DatePicker.class);
                this.startActivity(abrirEjer7_5);
                return false;
            case R.id.ejer7_6:
                Intent abrirEjer7_6 = new Intent(this, Ejer7_6_Intent.class);
                this.startActivity(abrirEjer7_6);
                return false;
            default:
                return false;
        }
    }

}

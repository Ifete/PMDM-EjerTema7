package com.example.ejertema7.ejer7_6;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ejertema7.R;
import com.example.ejertema7.ejer7_1y7_2.MainActivity;
import com.example.ejertema7.ejer7_3.Ejer7_3;
import com.example.ejertema7.ejer7_5.Ejer7_5_DatePicker;

import java.util.Calendar;

public class Ejer7_6_Intent extends AppCompatActivity {

    //Creamos el menú para ver los diferentes ejercicios
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_ejer7,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        Button openBrowserButton = findViewById(R.id.btnOpenBrowser);
        openBrowserButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(intent);
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

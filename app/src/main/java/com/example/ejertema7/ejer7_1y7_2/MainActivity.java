package com.example.ejertema7.ejer7_1y7_2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ejertema7.R;
import com.example.ejertema7.ejer7_3.Ejer7_3;
import com.example.ejertema7.ejer7_5.Ejer7_5_DatePicker;
import com.example.ejertema7.ejer7_6.Ejer7_6_Intent;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Preferencias";

    //Creamos el menú para ver los diferentes ejercicios
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_ejer7,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botón que abre las preferencias
        Button prefsButton = findViewById(R.id.btnPreferences);
        prefsButton.setOnClickListener(v -> openSettings());

        // Botón que muestra los valores de las preferencias
        Button showPrefsButton = findViewById(R.id.btnShowPrefs);
        showPrefsButton.setOnClickListener(v -> showPreferences());

        // Botón que muestra el TOAST
        Button showToastButton = findViewById(R.id.btnShowToast);
        showToastButton.setOnClickListener(v -> showCustomToast());

    }

    // Métdo para abrir la pantalla de preferencias
    private void openSettings() {
        startActivity(new Intent(this, SettingsActivity.class));
    }

    // Métdo para mostrar las preferencias en el Log
    private void showPreferences() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = preferences.getString("username", "No definido");
        boolean notifications = preferences.getBoolean("notifications", false);

        Log.d(TAG, "Usuario: " + username);
        Log.d(TAG, "Notificaciones: " + notifications);

        // También se puede mostrar un Toast
        Toast.makeText(this, "Revisa el Log", Toast.LENGTH_SHORT).show();

    }

    // Métdo para mostrar el toast personalizado ejercicio 7_2
    private void showCustomToast() {
        LayoutInflater inflater = getLayoutInflater();
        android.widget.LinearLayout layout = (android.widget.LinearLayout) inflater.inflate(R.layout.toast_layout, null);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
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
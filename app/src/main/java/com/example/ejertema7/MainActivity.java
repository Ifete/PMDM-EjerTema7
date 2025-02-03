package com.example.ejertema7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Preferencias";
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

    // Método para abrir la pantalla de preferencias
    private void openSettings() {
        startActivity(new Intent(this, SettingsActivity.class));
    }

    // Método para mostrar las preferencias en el Log
    private void showPreferences() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = preferences.getString("username", "No definido");
        boolean notifications = preferences.getBoolean("notifications", false);

        Log.d(TAG, "Usuario: " + username);
        Log.d(TAG, "Notificaciones: " + notifications);

        // También se puede mostrar un Toast
        Toast.makeText(this, "Revisa el Log", Toast.LENGTH_SHORT).show();

    }

    // Método para mostrar el toast
    private void showCustomToast() {
        LayoutInflater inflater = getLayoutInflater();
        android.widget.LinearLayout layout = (android.widget.LinearLayout) inflater.inflate(R.layout.toast_layout, null);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

}
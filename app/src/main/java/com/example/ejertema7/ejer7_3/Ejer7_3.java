package com.example.ejertema7.ejer7_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ejertema7.R;
import com.example.ejertema7.ejer7_1y7_2.MainActivity;
import com.example.ejertema7.ejer7_5.Ejer7_5_DatePicker;
import com.example.ejertema7.ejer7_6.Ejer7_6_Intent;

public class Ejer7_3 extends AppCompatActivity {
    //Creamos el menú para ver los diferentes ejercicios
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_ejer7,menu);
        return true;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);

        SeekBar seekBar = findViewById(R.id.seekBar);
        Button btnToastPosition = findViewById(R.id.btnToastPosition);

        btnToastPosition.setOnClickListener(v -> {
            int position = seekBar.getProgress();

            Toast toast = new Toast(getApplicationContext());
            View toast_view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.toast_layout, null);
            toast.setView(toast_view);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, position);
            toast.show();
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

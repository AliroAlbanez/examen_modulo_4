package com.example.aboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aboutme.databinding.ActivityMainBinding;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Timber.i("Actividad Creada");



    }

    //metodo utilizado ya que el clicklistener generaba error al quedar el boton como null, llamamos desde el xml
    public void onClickFriend(View v) {
        Intent intent=new Intent(MainActivity.this, ContactActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onResume(){
        super.onResume();
        Timber.i("Actividad en Resumen");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Timber.i("Actividad en Pausa");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Timber.i("Actividad Iniciada");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Timber.d("Actividad en Detenida");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Timber.d("Actividad Destruida");
    }
}
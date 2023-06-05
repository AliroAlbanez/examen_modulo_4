package com.example.aboutme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import timber.log.Timber;
import com.example.aboutme.databinding.ActivityContactBinding;
public class ContactActivity extends AppCompatActivity {
    private  ActivityContactBinding binding;
    private ImageButton linkid;
    private ImageButton whatsapp;
    private Button escribir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Timber.i("Actividad Creada");

        linkid=binding.botonLinkId;
        whatsapp=binding.botonWtsApp;
        escribir=binding.botonEscribir;

        linkid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.linkedin.com/"; // URL de la página web que deseas abrir
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));

                startActivity(intent);
            }
        });

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "1234563340"; // Número de teléfono al que deseas enviar un mensaje

                // Crea el URI con el número de teléfono en el formato adecuado
                Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=" + phoneNumber);

                // Crea el intent con la acción ACTION_SEND y establece el URI
                Intent intent = new Intent(Intent.ACTION_SEND, uri);

                // Establece el tipo de contenido del mensaje como texto plano
                intent.setType("text/plain");

                // Verifica si WhatsApp está instalado en el dispositivo antes de iniciar la actividad
                PackageManager packageManager = getPackageManager();
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(ContactActivity.this, "WhatsApp no está instalado", Toast.LENGTH_SHORT).show();
                }

            }
        });

        escribir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mostrarFragmento();

            }
        });

    }

    private void mostrarFragmento() {

        // Crea una instancia del fragmento MessageFragment
        MessageFragment fragment = new MessageFragment();
        // Obtiene el administrador de fragmentos
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Inicia una transacción de fragmento
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // Reemplaza el contenido del contenedor con el fragmento MessageFragment
        transaction.replace(binding.container.getId(), fragment);
        // Opcional: añade la transacción a la pila de retroceso
        transaction.addToBackStack(null);
        // Realiza la transacción
        transaction.commit();
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
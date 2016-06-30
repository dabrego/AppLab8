package com.example.applab8.applab8;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class DisplayMessageActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.applab8.applab8.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Get the intent and assign it to a local variable
        Intent intent = getIntent();
        //Extract the message delivered by MyActivity with the getStringExtra() method.
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);

        textView.setTextSize(32);
        textView.setText("Hola " +message +" ¿Aceptas las condiciones?" );

        Button btnAceptar = (Button) findViewById(R.id.btn_aceptar);
        btnAceptar.setVisibility(View.VISIBLE);
        Button btnCancelar = (Button) findViewById(R.id.btn_cancelar);
        btnCancelar.setVisibility(View.VISIBLE);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);
    }

    public void sendAceptar(View view){
        // Creas objeto intent donde alojas el parametro DisplayMessageActivity.class
        Intent intent = new Intent(this, MainActivity.class);
        String message = "Aceptadas";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void sendCancelar(View view){
        // Creas objeto intent donde alojas el parametro DisplayMessageActivity.class
        Intent intent = new Intent(this, MainActivity.class);
        String message = "Rechazadas";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}


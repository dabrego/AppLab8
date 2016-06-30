package com.example.applab8.applab8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.applab8.applab8.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the intent and assign it to a local variable
        Intent intent = getIntent();
        //Extract the message delivered by DisplayMessageActivity with the getStringExtra() method.
        String message = intent.getStringExtra(DisplayMessageActivity.EXTRA_MESSAGE);

        if(message != null){
            // Setting the results
            TextView textView = (TextView) findViewById(R.id.result);
            textView.setVisibility(View.VISIBLE);
            textView.setText("Condiciones del Contrato: "+message);
        }


    }

    public void sendMessage(View view){
        // Creas objeto intent donde alojas el parametro DisplayMessageActivity.class
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}

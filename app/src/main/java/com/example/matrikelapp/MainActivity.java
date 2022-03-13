package com.example.matrikelapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button berechnen = (Button) findViewById(R.id.BerechnenButton);
        final Button abschicken = (Button) findViewById(R.id.AbschickenButton);
        final TextView anweisung = (TextView) findViewById(R.id.Anweisung);
        final TextView antwortServer = (TextView) findViewById(R.id.AntwortServer);
        final EditText eingabe = (EditText) findViewById(R.id.EingabeMatrNr);

        Client handy = new Client(); //startet server
        handy = new Client();
        new Thread(handy).start();


        abschicken.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        //rufe sendInputUser / run auf!!
                    }
                }

        );
        berechnen.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        //calc Methode aufrufen
                    }
                }

        );


//client call my.start();
    }


}

    //calcMatr.z
    //aendern
    CharSequence matrnr = eingabe.getText();
    char[] matarr = matnr.toString().toCharacterArray();
    int[] arr = charArrayToIntArray(matarr);

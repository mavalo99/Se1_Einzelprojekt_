package com.example.matrikelapp;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.Math;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button berechnen = (Button) findViewById(R.id.BerechnenButton);
        final Button abschicken = (Button) findViewById(R.id.AbschickenButton);
        final TextView anweisung = (TextView) findViewById(R.id.Anweisung);
        final TextView antwortServer = (TextView) findViewById(R.id.AntwortServer);
        final EditText eingabe = (EditText) findViewById(R.id.EingabeMatrNr);

        Client handy = new Client(); //startet server
        new Thread(handy).start();

        Client finalHandy = handy;

        abschicken.setOnClickListener(
                new Button.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    public void onClick(View v) {


                        String matrNr = eingabe.toString(); //eingabe wird in String gespeichert
                        finalHandy.sendInputUser(matrNr); // nimmt Matrikelnummer entgegen / ruft in sendI.. Client auf

                        String responseServer = finalHandy.modifiedSentence; //
                        antwortServer.setText("Connection: ✅" + "\n" + responseServer);

                    }
                }
        );


        berechnen.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        String i = calcMatr(eingabe);
                        eingabe.setText(i);


                        // final TextView response = eingabe;


                    }
                }
        );


    }

    public String calcMatr(EditText eingabe) {
        int x = 0;
        int y = 0;

        //Übertragung eingabe in Sequence -> Array
        CharSequence matrNr = eingabe.getText();
        char[] matarr = matrNr.toString().toCharArray();

        // von char[] zu int[]
        int[] arr = new int[matarr.length];
        for (int d = 0; d < arr.length; d++) {
            arr[d] = Character.getNumericValue(matarr[d]);
        }

        // Range definineren
        int max = 9;
        int min = 0;
        int range = max - min + 1;

        // Zahlen von 0-9 (Array) generieren
        for (int f = 0; f < 9; f++) {
            int rdm = (int) (Math.random() * range) + min;


            for (int i = rdm; i < arr.length ; i++) {
                x = arr[i];
                for (int j = rdm; j > arr.length / 2; j--) {
                    y = arr[j];

                    if ((x % i) > 1 && (y % j) > 1 && (arr[i] != arr[j])) {

                        String zahl1 = Integer.toString(arr[i]);
                        String zahl2 = Integer.toString(arr[j]);
                        String loe = "Index1: " + zahl1 + " Index2: " + zahl2;
                        return loe;

                    }
                }
            }
        }
        String tt = "fail";
        return tt;
    }

}
/*
Prüfen, ob zwei beliebige Ziffern existieren die einen gemeinsamen Teiler > 1 haben.
        Werden zwei Ziffern mit gemeinsamem Teiler gefunden,
        soll deren Index ausgegeben werden.
*/



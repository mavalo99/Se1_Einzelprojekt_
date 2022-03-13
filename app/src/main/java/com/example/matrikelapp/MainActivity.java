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


        Client finalHandy = handy;
        abschicken.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        //rufe sendInputUser / run auf!! -> modifiedsentence
                        String matrNr = eingabe.toString(); //eingegtippte wird in String und dann der
                        finalHandy.sendInputUser(matrNr);

                        String responseServer = finalHandy.modifiedSentence; //
                        TextView answer = findViewById(R.id.AntwortServer);
                        answer.setText(responseServer);
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


    }


}

    //calcMatr


    CharSequence matrnr = eingabe.getText();
    char[] matarr = matnr.toString().toCharacterArray();
    int[] arr = charArrayToIntArray(matarr);

    public void calcMatr() {
        int x = 0;
        int y = 0;
        int z = 1;
        while () {
            for (int i = 0; i < arr.length / 2; i++) {
                z++;
                x = arr[i];
                int a = z / x;
                for (int j = arr.length; j > arr.length / 2; j--) {
                    x = arr[j];
                }
            }
        }
    }

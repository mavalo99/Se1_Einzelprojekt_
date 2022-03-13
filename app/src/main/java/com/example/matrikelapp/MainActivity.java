package com.example.matrikelapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.Math;

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
                        calcMatr(eingabe);

                    }
                }

        );


    }


    //calcMatr


    public int calcMatr(EditText eingabe) {
        int x = 0;
        int y = 0;

        //Übertragung eingabe in Sequence -> Array
        CharSequence matrNr = eingabe.getText();
        char[] matarr = matrNr.toString().toCharArray();

        // von char[] zu int[]
        int[] arr = new int[matarr.length];
        for (int d = 0; d < arr.length; d++){
            arr[d] = Character.getNumericValue(matarr[d]);
        }

            // Range definineren
        int max = 9;
        int min = 0;
        int range = max - min + 1;

        // Zahlen von 0-9 (Array) generieren
        for (int f = 0; f < 9; f++) {
            int rdm = (int) (Math.random() * range) + min;


            for (int i = rdm; i < arr.length; i++) {
                x = arr[i];
                for (int j = rdm; j > arr.length / 2; j--) {
                    y = arr[j];

                    if ((x % i) == 0 && (y % j) == 0) {

                        return arr[i];

                    }
                }
            }
        }
        return 1;
    }
}



package com.example.matrikelapp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client implements Runnable{
    private volatile String inputUser;
    Socket socket;
    String modifiedSentence; //Antwort vom Server
    String sentence; //Eingabe sent als bytestram

    public void run() { //stellt eine Verbindung zum Host her
        try {

            socket = new Socket("se2-isys.aau.at", 53212);
            DataOutputStream sentByUser = new DataOutputStream(socket.getOutputStream()); //Verbindung

            BufferedReader incomingFuser = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader incomingFserver = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            sentence = incomingFuser.readLine();

            sentByUser.writeBytes(inputUser + "\n"); //für den Beginn des Einlesens \n macht das es ausgeführt wird

            modifiedSentence = incomingFserver.readLine(); //Nachricht vom Server zurück bekommen
            sentByUser.close();
            socket.close();

        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void sendInputUser(String inpuse) {
        this.inputUser = inpuse; //Matrikelnummer wird reingespeichert
        run(); //wird aufgerufen/ausgeführt
    }
}



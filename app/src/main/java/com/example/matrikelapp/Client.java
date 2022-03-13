package com.example.matrikelapp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client implements Runnable{
    private String inputUser;
    Socket socket;
    String modifiedSentence; //Antwort vom Server


    public void run() {
        try {
            String sentence; //Eingabe sent als bytestram


            socket = new Socket("se2-isys.aau.at", 53212);
            DataOutputStream sentByUser = new DataOutputStream(socket.getOutputStream());

            BufferedReader incomingFuser = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader incomingFserver = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            sentence = incomingFuser.readLine();

            sentByUser.writeBytes(inputUser + "\n"); //für den Beginn des Einlesens

            modifiedSentence = incomingFserver.readLine();
            sentByUser.close();
            socket.close();

        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void sendInputUser(String iu) {
        this.inputUser = iu;
        run();
    }
}



package com.example.matrikelapp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client implements Runnable{
    private String inputUser;
    Socket socket;



    public void run() {
        try {
            String sentence; //Eingabe sent als bytestram
            String modifiedSentence; //Antwort vom Server
            //  String serversantwort;

            socket = new Socket("ddfsfdf", 4545);
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



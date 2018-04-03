package com.itesm;/*
 * tech.aabo.reader.Mercury4ReaderThread.java
 *
 * Created on 19 de noviembre de 2008, 01:59 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.io.IOException;

/**
 *
 * @author L00308163   Dr. Raul Crespo Saucedo
 */
public class Mercury4ReaderThread extends Thread {

    private Principal app;
    MercuryReader reader;

    public Mercury4ReaderThread(Principal app, MercuryReader reader) {
        this.app=app;
        this.reader = reader;
    }

    public void run() {
        while(true) {
            try {
                String response = reader.getBuffer().readLine();
                if(response.length()!=0){
                    app.show(response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
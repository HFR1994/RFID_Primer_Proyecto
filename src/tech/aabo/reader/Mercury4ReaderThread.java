package tech.aabo.reader;/*
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

    private Reader app;
    MercuryReader reader;

    /** Creates a new instance of tech.aabo.reader.Mercury4ReaderThread */
    public Mercury4ReaderThread(Reader app, MercuryReader reader) {
        this.app=app;
        this.reader = reader;
    }

    public void run() {
        while(true) {
            try {
                String response = reader.getBuffer().readLine();
                if(response.length()!=0 && response.equals("0x00000020")){
                    app.show(response);
                }else if(response.contains("0x11112222333344445555DDDD")){
                    app.piston();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
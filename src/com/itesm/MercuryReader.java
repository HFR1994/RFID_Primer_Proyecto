package com.itesm;
import java.io.*;
import java.net.*;

public class MercuryReader {

    private Principal app;
    private Socket socket = null;
    private PrintWriter readerOut = null;
    private BufferedReader readerIn = null;
    private Mercury4ReaderThread thread;

    public MercuryReader(Principal app){
        this.app = app;
        init();
    }
    public void init(){
        // Connect to a networked reader, use the following:
        try {
            connect();
        } catch (UnknownHostException ex) {
            app.error("Errors: " + ex.toString());
        } catch (IOException ex) {
            app.error("Error1: " + ex.toString());
        }

        thread = new Mercury4ReaderThread(app, this);
        thread.setName("ThingMagic Mercury4 Reader Thread");
        thread.setDaemon(true);
        thread.start();
    }

    public synchronized void connect() throws UnknownHostException, IOException {
        socket = new Socket("10.0.0.101", 8080);
        readerOut = new PrintWriter(socket.getOutputStream(), true);
        readerIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public synchronized void doCommand(String query) {
        readerOut.println(query);
    }

    public BufferedReader getBuffer() {
        return readerIn;
    }

}

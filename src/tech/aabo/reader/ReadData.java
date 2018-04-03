package tech.aabo.reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.TimerTask;

public class ReadData extends TimerTask {

    private MercuryReader m4reader;

    public ReadData(MercuryReader m4reader) {
        this.m4reader=m4reader;
    }

    @Override
    public void run() {
        m4reader.doCommand("SELECT data FROM io WHERE type = 0 and mask = 0x20;");
        //m4reader.doCommand("UPDATE io SET data = 0x00 WHERE type = 0 and mask = 0x04;");
        //m4reader.simulatedReturn();
    }

}

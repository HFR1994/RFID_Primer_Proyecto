package tech.aabo.reader;

import java.io.IOException;
import java.util.Timer;

public class Reader{
    private MercuryReader m4reader;
    final String[] value = new String[1];

    public static void main(String [] args) throws IOException {
        new Reader();
    }

    public Reader() throws IOException {
        Timer timer = new Timer();
        m4reader = new MercuryReader(this);
        //m4reader.doCommand("UPDATE io SET data = 0x00 WHERE type = 0 and mask = 0x04;");

        timer.schedule(new ReadData(m4reader), 0, 1000);
        //new ReadData(m4reader).run();

    }

    public void show(String response) throws Exception {
        System.out.println("Recibi: "+response);
        m4reader.doCommand("SELECT data FROM tag_data WHERE protocol_id='GEN2' AND antenna_id=1 AND mem_bank=1 AND block_number=2 AND block_count=6;");
    }

    public void error(String response){
        System.out.println("No lei nada");
    }

    public void piston() throws Exception {
        System.out.println("Ejecuto Piston");
        m4reader.doCommand("UPDATE io SET data = 0xFF WHERE type = 0 and mask = 0x10;");
        Thread.sleep(1000);
        m4reader.doCommand("UPDATE io SET data = 0x00 WHERE type = 0 and mask = 0x10;");
    }
}

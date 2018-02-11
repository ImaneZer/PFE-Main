import gnu.io.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kalcha800e on 30/11/17.
 */
public class TestMain {
    public static void main(String[] args) throws PortInUseException, NoSuchPortException, UnsupportedCommOperationException, IOException, InterruptedException {
        CommPortIdentifier id = null;
        SerialPort port;
        InputStream in;
        OutputStream out;


        id = CommPortIdentifier.getPortIdentifier("/dev/ttyUSB0");

        port = (SerialPort) id.open("ecouteur", 1000);

        port.setSerialPortParams(19200,
                SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);


        in = port.getInputStream();


        out = port.getOutputStream();



/*
        while(true) {
            out.write((byte) 0xFD);

            Thread.sleep(1000);



            Thread.sleep(1000);
        }
*/

        /*for (int i = 0; i < 12; i++) {
            char c = (char) in.read();
            String s = Integer.toHexString(c).toUpperCase();
            String I = "0x"+(s.length() == 1?"0":"")+ s +":";
            System.out.println(I);
        }*/

        Boolean tagPresented = false;
        do {

            System.out.println();
            out.write((byte) 0xFA);
            Thread.sleep(1000);
            while (in.available() != 0) {
                tagPresented = true;
                System.out.print(in.read());

            }
        } while (true);
    }
}

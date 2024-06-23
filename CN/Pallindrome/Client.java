package CN.Pallindrome;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket();

        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter: ");
        String out = key.readLine();

        while (!out.equalsIgnoreCase("close")) {
            DatagramPacket send = new DatagramPacket(out.getBytes(), out.length(), InetAddress.getLocalHost(), 1234);
            ds.send(send);

            byte[] buffer = new byte[20];
            DatagramPacket receive = new DatagramPacket(buffer, buffer.length);
            ds.receive(receive);
            System.out.println(new String(receive.getData()));

            System.out.println("\nEnter: ");
            out = key.readLine();
        }
        ds.close();
    }
}

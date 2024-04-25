package CN.UDP_SimpleSocket;

import java.net.*;

class Server{
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket(3000);
        byte[] b = new byte[100];
        DatagramPacket dp = new DatagramPacket(b, b.length);
        ds.receive(dp);
        String str = new String(b);
        System.out.println("Received -> " + str);
        ds.close();
    }
}
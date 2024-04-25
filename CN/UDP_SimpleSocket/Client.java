package CN.UDP_SimpleSocket;

import java.net.*;

class Client{
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket();
        byte[] b = "This is udp client".getBytes();
        int port = 3000;
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket dp = new DatagramPacket(b, b.length, ip, port);
        ds.send(dp);
        ds.close();
    }
}
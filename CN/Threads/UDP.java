package CN.Threads;

import java.io.*;
import java.net.*;

class Server extends Thread {
    public void run() {
        try {
            DatagramSocket ds = new DatagramSocket(3000);
            System.out.println("Server started...");
            DatagramPacket input, output;
            byte[] buffer;
            BufferedReader keyBoard = new BufferedReader(new InputStreamReader(System.in));
            String msg, res;
            do{
                buffer = new byte[256];
                input = new DatagramPacket(buffer, buffer.length);
                ds.receive(input);
                msg = new String(input.getData(), 0, input.getLength());
                if(msg.equalsIgnoreCase("close")){
                    break;
                }
                System.out.println("Client: "+msg);
                System.out.print("(Server) Enter message: ");
                res = keyBoard.readLine();
                output = new DatagramPacket(res.getBytes(), res.length(), input.getAddress(), input.getPort());
                ds.send(output);
            }while(!res.equalsIgnoreCase("close"));
            ds.close();
            System.out.println("Closing server...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Client extends Thread {
    public void run() {
        try {
            DatagramSocket ds = new DatagramSocket();
            System.out.println("Openning port...");
            DatagramPacket input, output;
            byte[] buffer;
            InetAddress address = InetAddress.getLocalHost();
            BufferedReader keyBoard = new BufferedReader(new InputStreamReader(System.in));
            String msg = "", res = "";
            System.out.print("(Client) Enter message: ");
            msg = keyBoard.readLine();
            while(!msg.equalsIgnoreCase("close")){
                output = new DatagramPacket(msg.getBytes(), msg.length(), address, 3000);
                ds.send(output);
                buffer = new byte[256];
                input = new DatagramPacket(buffer, buffer.length);
                ds.receive(input);
                res = new String(input.getData(), 0, input.getLength());
                if(res.equalsIgnoreCase("close")){
                    break;
                }
                System.out.println("Server: "+res);
                System.out.print("(Client) Enter message: ");
                msg = keyBoard.readLine();
            }
            if(!res.equalsIgnoreCase("close")){
                output = new DatagramPacket(msg.getBytes(), msg.length(), address, 3000);
                ds.send(output);
            }
            ds.close();
            System.out.println("Closing port...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class UDP {
    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client();

        server.start();
        client.start();
    }
}

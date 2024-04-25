package CN.Threads;

import java.io.*;
import java.net.*;

class Server extends Thread {
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(3000);
            Socket s = ss.accept();
            System.out.println("Server started...");
            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            BufferedReader keyBoard = new BufferedReader(new InputStreamReader(System.in));
            String msg, res;
            do{
                msg = input.readLine();
                if(msg.equalsIgnoreCase("close")){
                    break;
                }
                System.out.println("Client: "+msg);
                System.out.print("(Server) Enter message: ");
                res = keyBoard.readLine();
                pw.println(res);
            }while(!res.equalsIgnoreCase("close"));
            ss.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Closing server...");
        }
    }
}

class Client extends Thread {
    public void run() {
        try {
            Socket s = new Socket("localhost", 3000);
            System.out.println("Openning port...");
            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            BufferedReader keyBoard = new BufferedReader(new InputStreamReader(System.in));
            String msg = "", res = "";
            System.out.print("(Client) Enter message: ");
            msg = keyBoard.readLine();
            while(!msg.equalsIgnoreCase("close")){
                pw.println(msg);
                res = input.readLine();
                if(res.equalsIgnoreCase("close")){
                    break;
                }
                System.out.println("Server: "+res);
                System.out.print("(Client) Enter message: ");
                msg = keyBoard.readLine();
            }
            if(!res.equalsIgnoreCase("close")){
                pw.println(msg);
            }
            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Closing port...");
        }
    }
}

public class TCP {
    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client();
        server.start();
        client.start();
    }
}

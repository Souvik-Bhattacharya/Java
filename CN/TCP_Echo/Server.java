package CN.TCP_Echo;

import java.io.*;
import java.net.*;
import java.util.*;

class Server{
    private static ServerSocket serverSocket;
    private static final int PORT = 3000;
    public static void main(String[] args){
        System.out.println("Openning port...");
        try {
            serverSocket = new ServerSocket(PORT);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        do{
            handleClient();
        }while(true);
    }
    private static void handleClient(){
        Socket link = null;
        try {
            link = serverSocket.accept();
            Scanner input = new Scanner(link.getInputStream());
            PrintWriter output = new PrintWriter(link.getOutputStream(), true);
            int numMessages = 0;
            String message = input.nextLine();
            while(!message.equals("CLOSE")){
                System.out.println("Message received");
                numMessages++;
                output.println("SERVER> Message" + numMessages + ": " + message);
                message = input.nextLine();
            }
            output.println(numMessages + " messages received");
            input.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }finally{
            try {
                System.out.println("***Closing Connection***");
                link.close();
            } catch(Exception e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
    }
}
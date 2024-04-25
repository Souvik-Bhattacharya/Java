package CN.TCP_Echo;

import java.io.*;
import java.net.*;
import java.util.*;

class Client{
    private static InetAddress host;
    private static final int PORT = 3000;
    public static void main(String[] args){
        System.out.println("Openning port...");
        try {
            host = InetAddress.getLocalHost();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        accessServer();
    }
    private static void accessServer(){
        Socket link = null;
        try {
            link = new Socket(host, PORT);
            Scanner input = new Scanner(link.getInputStream());
            PrintWriter output = new PrintWriter(link.getOutputStream(), true);
            Scanner userEntry = new Scanner(System.in);
            String message, response;
            do{
                System.out.print("Enter message: ");
                message = userEntry.nextLine();
                output.println(message);
                response = input.nextLine();
                System.out.println(response);
            }while(!message.equals("CLOSE"));
            input.close();
            userEntry.close();
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
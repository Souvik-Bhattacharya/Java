package CN.Fibonacci;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("localhost", 3000);

        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String inputMsg, outputMsg;

        System.out.println("\nEnter the number: ");
        outputMsg = keyRead.readLine();

        while (!outputMsg.equalsIgnoreCase("close")) {
            pw.println(outputMsg);
            inputMsg = receiveRead.readLine();
            System.out.println("server: "+inputMsg);
            System.out.println("\nEnter the number: ");
            outputMsg = keyRead.readLine();
        }
        s.close();
    }
}

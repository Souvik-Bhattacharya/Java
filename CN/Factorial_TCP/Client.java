package CN.Factorial_TCP;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("localhost", 3000);
        BufferedReader keyBoard = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number: ");
        String input, fact;
        input = keyBoard.readLine();
        while(!input.equalsIgnoreCase("close")){
            PrintStream pw = new PrintStream(s.getOutputStream(), true);
            pw.println(input);
            pw.flush();
            BufferedReader res = new BufferedReader(new InputStreamReader(s.getInputStream()));
            fact = res.readLine();
            System.out.println("The factorial is: " + fact);
            System.out.print("Enter the number: ");
            input = keyBoard.readLine();
        }
        PrintStream pw = new PrintStream(s.getOutputStream(), true);
        pw.println(input);
        pw.flush();
        System.out.println("Connection closed...");
        s.close();
    }
}

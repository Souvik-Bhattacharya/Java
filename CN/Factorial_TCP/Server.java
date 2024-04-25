package CN.Factorial_TCP;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Server started...");
        Socket s = ss.accept();
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String msg, res;
        msg = input.readLine();
        while(!msg.equalsIgnoreCase("close")){
            System.out.println("Received number is: " + msg);
            int number = Integer.parseInt(msg);
            int factorial = 1;
            for(int i = 2; i <= number; i++){
                factorial *= i;
            }
            res = String.valueOf(factorial);
            PrintStream pw = new PrintStream(s.getOutputStream(), true);
            pw.println(res);
            pw.flush();
            msg = input.readLine();
        }
        System.out.println("Connection closed...");
        s.close();
        ss.close();
    }
}

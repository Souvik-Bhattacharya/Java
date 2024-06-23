package CN.Fibonacci;

import java.net.*;
import java.io.*;

class Fibonacci extends Thread{
   private int fibonacci(int in){
        if(in <= 1) return in;
        else return fibonacci(in-1) + fibonacci(in-2);
    }

    public void run(){
        try {
            ServerSocket ss = new ServerSocket(3000);
            Socket s = ss.accept();

            BufferedReader receiveRead = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

            String inputMsg = "", outputMsg = "";
            
            while(!inputMsg.equalsIgnoreCase("close")){
                inputMsg = receiveRead.readLine();
                if(inputMsg.equalsIgnoreCase("close")) break;
                int in = Integer.parseInt(inputMsg);
                int out = fibonacci(in);
                outputMsg = String.valueOf(out);
                pw.println(outputMsg);
            }
            
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Server{
    public static void main(String[] args) {
        Fibonacci fs = new Fibonacci();
        fs.start();
    }
}
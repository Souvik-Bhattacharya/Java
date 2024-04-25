package CN.TCP_SimpleSocket;

import java.net.*;
import java.io.*;

public class Server{
	public static void main(String args[]){
		try{
			System.out.println("...Waiting for Client...");
			ServerSocket server = new ServerSocket(3000);
			Socket sc = server.accept();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
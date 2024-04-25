package CN.TCP_SimpleSocket;

import java.net.*;

public class Server{
	public static void main(String args[]){
		try{
			System.out.println("...Waiting for Client...");
			ServerSocket server = new ServerSocket(3000);
			Socket sc = server.accept();
			sc.close();
			server.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
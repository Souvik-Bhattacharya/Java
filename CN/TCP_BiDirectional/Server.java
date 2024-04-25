package CN.TCP_BiDirectional;

import java.net.*;
import java.io.*;

public class Server{
	public static void main(String args[]) throws Exception{
			ServerSocket sc = new ServerSocket(3000);
			System.out.println("Server Ready");
			Socket s = sc.accept();
			BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
			OutputStream os = s.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
			InputStream is = s.getInputStream();
			BufferedReader receiveRead = new BufferedReader(new InputStreamReader(is));			
			String receiveMsg, sendMsg = "";
			while(!sendMsg.equalsIgnoreCase("close")){
				if((receiveMsg = receiveRead.readLine()) != null){
					System.out.println("Client: "+receiveMsg);
				}
				sendMsg = keyRead.readLine();
				pw.println(sendMsg);
				pw.flush();
			}
			System.out.println("Connection closed by server");
			sc.close();
	}
}
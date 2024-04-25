package CN.TCP_BiDirectional;

import java.net.*;
import java.io.*;

public class Client{
	public static void main(String args[]) throws Exception{
			Socket sc = new Socket("127.0.0.1", 3000);
			BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
			OutputStream os = sc.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
			InputStream is = sc.getInputStream();
			BufferedReader receiveRead = new BufferedReader(new InputStreamReader(is));			
			System.out.println("Start the chat, type and press Enter key");
			String receiveMsg, sendMsg = "";
			while(!sendMsg.equalsIgnoreCase("close")){
				sendMsg = keyRead.readLine();
				pw.println(sendMsg);
				pw.flush();
				if((receiveMsg = receiveRead.readLine()) != null){
					System.out.println("Server: "+receiveMsg);
				}
			}
			System.out.println("Connection closed by client");
			sc.close();
	}
}
package CN.TCP_SimpleSocket;

import java.net.*;
import java.io.*;

public class Client{
	public static void main(String args[]){
		try{
			Socket theSocket = new Socket("localhost", 3000);
			System.out.println("...Find Server...");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
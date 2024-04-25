package CN.UDP_BiDirectional;

import java.io.*;
import java.net.*;

public class Server 
{
    public static void main(String[] args) 
    throws SocketException, IOException 
    {
        
         DatagramSocket serverSocket = new DatagramSocket(9876);

      while(true) 
        {
          byte[] receivebuffer = new byte[1024];
          byte[] sendbuffer  = new byte[1024];

          DatagramPacket recvdpkt = new DatagramPacket(receivebuffer, receivebuffer.length);
          serverSocket.receive(recvdpkt);
          
          //get the ip address and port no for client
          InetAddress IP = recvdpkt.getAddress();
          int portno = recvdpkt.getPort();

          //receive client message converted into string
          String clientdata = new String(recvdpkt.getData());

          //print the client message
          System.out.println("\nClient : "+ clientdata);
          
          //printing the caption of server for type the message
          System.out.print("\nServer : ");
          
          //create a buffer for keyboard input from user
          BufferedReader serverRead = new BufferedReader(new InputStreamReader (System.in) );
          String serverdata = serverRead.readLine();
          
          //typecasting the user message into bytes
          sendbuffer = serverdata.getBytes();
          
          //create a datagram and send the message to client 
          DatagramPacket sendPacket = new DatagramPacket(sendbuffer, sendbuffer.length, IP,portno);
          serverSocket.send(sendPacket); 
         
          if(serverdata.equalsIgnoreCase("bye"))
          {
              System.out.println("connection ended by server");
              break;
          }
      }
        //close the connection
        serverSocket.close();
    }
            
}

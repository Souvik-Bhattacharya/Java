package CN.UDP_BiDirectional;

import java.io.*;
import java.net.*;

public class Client {
  public static void main(String[] args)
      throws SocketException, IOException {

    // create a bufferedreader object for keyboard input by the user
    BufferedReader clientRead = new BufferedReader(new InputStreamReader(System.in));

    // get the address of host to send
    InetAddress IP = InetAddress.getByName("127.0.0.1");

    // create datagram client socket
    DatagramSocket clientSocket = new DatagramSocket();

    while (true) // true
    {
      // create two byte object for receiving and sending msg
      byte[] sendbuffer = new byte[1024];
      byte[] receivebuffer = new byte[1024];

      // client caption showing for type the user message
      System.out.print("\nClient: ");
      String clientData = clientRead.readLine();

      // typecasting into bytes the user message
      sendbuffer = clientData.getBytes();

      // create a datagram packet to send
      DatagramPacket sendPacket = new DatagramPacket(sendbuffer, sendbuffer.length, IP, 9876);

      // send the datagram packet through socket to the server
      clientSocket.send(sendPacket);

      if (clientData.equalsIgnoreCase("bye")) {
        System.out.println("Connection ended by client");
        break;
      }

      // create the datagram packet for incoming message of client
      DatagramPacket receivePacket = new DatagramPacket(receivebuffer, receivebuffer.length);

      // receive the message from socket
      clientSocket.receive(receivePacket);

      // converted the message into string
      String serverData = new String(receivePacket.getData());

      // print the converted message by captionning server due to message is coming
      // from the server
      System.out.print("\nServer: " + serverData);

    }
    // close the connection
    clientSocket.close();
  }

}
package CN.UDP_Echo;

import java.io.*;
import java.net.*;
import java.util.*;
public class Client
{
  private static InetAddress host;
  public static final int PORT = 1234;
  private static DatagramSocket datagramSocket;
  private static DatagramPacket inPacket, ouPacket;
  private static byte[] buffer;
  public static void main (String[]args)
  {
	try
	{
	  host = InetAddress.getLocalHost ();
	} catch (UnknownHostException e)
	{
	  System.out.println ("Host ID not found");
	  System.exit (1);
	}
	accessServer ();
  }
  private static void accessServer ()
  {
	try
	{
	  datagramSocket = new DatagramSocket ();
	  Scanner userEntry = new Scanner (System.in);
	  String message = "", response = "";
	  do
		{
		  System.out.println ("Enter message:");
		  message = userEntry.nextLine ();
		  if (!message.equalsIgnoreCase ("CLOSE"))
			{
			  ouPacket =
				new DatagramPacket (message.getBytes (), message.length (),
									host, PORT);
			  datagramSocket.send (ouPacket);
			  buffer = new byte[256];
			  inPacket = new DatagramPacket (buffer, buffer.length);
			  datagramSocket.receive (inPacket);
			  response =
				new String (inPacket.getData (), 0, inPacket.getLength ());
			  System.out.println ("Server> " + response);
			}
		}
	  while (!message.equals ("CLOSE"));
	  userEntry.close();
	}
	catch (IOException e)
	{
	  e.printStackTrace ();
	}
	finally
	{
	  System.out.println ("Connection closed by server.");
	  datagramSocket.close ();
	}
  }
}

package CN.Pallindrome;

import java.net.*;

public class Server {
    private static boolean checkPallindrome(String msg){
        String rev = "";
        char[] in = msg.toCharArray();
        for(char c : in){
            rev = c+rev;
        };
        return rev.equals(msg);
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket(1234);

        byte[] buffer = new byte[20];
        DatagramPacket receive = new DatagramPacket(buffer, buffer.length);
        ds.receive(receive);
        String in = new String(receive.getData());

        String out;
        
        while(!in.equalsIgnoreCase("close")){
            boolean res = checkPallindrome(in);
            System.out.println(res);
            if(res) out = "Pallindrome";
            else out = "Not a pallindrome";
            DatagramPacket send = new DatagramPacket(out.getBytes(), out.length(), receive.getAddress(), receive.getPort());
            ds.send(send);

            receive = new DatagramPacket(buffer, buffer.length);
            ds.receive(receive);
            in = new String(receive.getData());
        }
        ds.close();
    }
}

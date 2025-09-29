/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task;

import java.math.BigInteger;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author HELLO
 */
public class EAuhmQ1k {
    public static void execute() {
        
        String Server = "203.162.10.109";
        
        Integer Server_port = 2207;
        
        String studentCode = "B22DCCN759";
        String qCode = "EAuhmQ1k";
        
        DatagramSocket socket = null;
        
        try{
            socket = new DatagramSocket();
            InetAddress Address = InetAddress.getByName(Server);
            String message = ";" + studentCode + ";" + qCode;
            System.out.println(message);
            socket.send(new DatagramPacket(
                    message.getBytes(),
                    message.getBytes().length,
                    Address,
                    Server_port
            ));
            //
            byte[] buffer = new byte[8192];
            DatagramPacket receivePacket = new DatagramPacket(buffer,
                    buffer.length);
            socket.receive(receivePacket);
            
            String receive_data = new String(receivePacket.getData(),0,receivePacket.getLength());
            String[] data = receive_data.split(";");
            System.out.println(receive_data);
            
            BigInteger a = new BigInteger(data[1]);
            BigInteger b = new BigInteger(data[2]);
            
            
            String finalString = data[0] + ";" + a.add(b) + "," + a.subtract(b);
            System.out.println(finalString);
            socket.send(new DatagramPacket(
                    finalString.getBytes(),
                    finalString.getBytes().length,
                    Address,
                    Server_port
            ));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(socket != null && !socket.isClosed()){
                socket.close();
            }
        }
        
    }
}

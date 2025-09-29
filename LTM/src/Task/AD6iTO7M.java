/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task;

import UDP.Product;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author HELLO
 */
public class AD6iTO7M {
    static public void execute_task() {
        String Server = "203.162.10.109";
        
        Integer Server_port = 2208;
        
        String studentCode = "B22DCCN759";
        String qCode = "AD6iTO7M";
        
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
            
            String data = new String(receivePacket.getData(), 0, receivePacket.getLength());
            String[] data2 = data.split(";");
            String requestId = data2[0];
            System.out.println(data2[1]);
            List<String> s = new ArrayList<>(Arrays.asList(data2[1].split("\\s+")));
            s.sort(String.CASE_INSENSITIVE_ORDER.reversed());
            
            
            for(int i = 0 ; i< s.size(); i++){
                System.out.println(s.get(i));
            }
            String solvedData = String.join(",", s);
            
            
            solvedData.trim();
            String send_message = requestId + ";" + solvedData;
            socket.send(new DatagramPacket(
                    send_message.getBytes(),
                    send_message.getBytes().length,
                    Address,
                    Server_port
            ));
            System.out.println(send_message);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(socket != null && !socket.isClosed()){
                socket.close();
            }
        }
    }
}

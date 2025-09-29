/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import static java.util.Arrays.sort;

/**
 *
 * @author HELLO
 */
public class ZoF6rc1y {
    static public void execute_task() {
        String Server = "203.162.10.109";
        
        Integer Server_port = 2207;
        
        String studentCode = "B22DCCN759";
        String qCode = "ZoF6rc1y";
        
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
            System.out.println(data);
            String[] arr = data2[1].split(",");
            System.out.println(arr.length);
            int[] num_arr = new int[arr.length];
            for(int i = 0 ; i < arr.length; i++){
                num_arr[i] = Integer.parseInt(arr[i]);
                System.out.println(num_arr[i]);
            }
            sort(num_arr);
            String send_message = requestId + ";" + num_arr[num_arr.length-2] + "," + num_arr[1];
            socket.send(new DatagramPacket(
                    send_message.getBytes(),
                    send_message.getBytes().length,
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task;

import UDP.Customer;
import UDP.Product;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author HELLO
 */
public class MiDSaQ6C {
    static public void execute_task_3() {
        String Server = "203.162.10.109";
        
        Integer Server_port = 2209;
        
        String studentCode = "B22DCCN759";
        String qCode = "MiDSaQ6C";
        
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
            byte[] buffer = new byte[4096];
            DatagramPacket receivePacket = new DatagramPacket(buffer,
                    buffer.length);
            socket.receive(receivePacket);
            
            String requestId = new String(receivePacket.getData(), 0, 8);
            System.out.println(requestId);
            ByteArrayInputStream bais = new ByteArrayInputStream(receivePacket.getData(), 
                    8,
                    receivePacket.getLength() - 8
            );
            
            
            
            Customer c;
            try(ObjectInputStream ois = new ObjectInputStream(bais);){
                c = (Customer) ois.readObject();
            }
            System.out.println(c);
            
            
            String dob = c.getDayOfBirth();
            String[] d = dob.split("-");
            String temp = d[0];
            d[0] = d[1];
            d[1] = temp;
            c.setDayOfBirth(String.join("/", d));
            String name = c.getName();
            String[] words = name.split("\\s+");
            String fixedName = words[words.length - 1].toUpperCase() + ",";
            for(int i = 0; i < words.length - 1; i ++){
                fixedName = fixedName + " "
                        + words[i].substring(0,1).toUpperCase() 
                        + words[i].substring(1).toLowerCase();
            }
            String userName = "";
            for(int i = 0; i < words.length - 1; i ++){
                userName = userName + words[i].substring(0,1);
            }
            userName = userName + words[words.length - 1];
            userName = userName.toLowerCase();
            System.out.println(userName);
            c.setName(fixedName);
            c.setUserName(userName);
            System.out.println(c);
            //
            byte[] finalData = new byte[4096];
            
            ByteArrayOutputStream customerBAOS = new ByteArrayOutputStream();
            ObjectOutputStream customerOOS = new ObjectOutputStream(customerBAOS);
            customerOOS.writeObject(c);
            customerOOS.flush();
            customerOOS.close();
            
            ByteArrayOutputStream output_dataBAOS = new ByteArrayOutputStream();
            output_dataBAOS.write(requestId.getBytes());
            output_dataBAOS.write(customerBAOS.toByteArray());
            finalData = output_dataBAOS.toByteArray();
            socket.send(new DatagramPacket(
                    finalData,
                    finalData.length,
                    Address,
                    Server_port));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(socket != null && !socket.isClosed()){
                socket.close();
            }
        }
    }
}

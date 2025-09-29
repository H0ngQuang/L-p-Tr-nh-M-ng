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

/**
 * je23s0tw - UDP - Object
 *
 */
public class je23s0tw {

    static public void execute_task_2() {
        String Server = "203.162.10.109";
        int Server_Port = 2209;
        String studentCode = "B22DCCN759";
        String qCode = "je23s0tw";

        DatagramSocket socket = null;

        try {

            socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName(Server);

            String message = ";" + studentCode + ";" + qCode;
            byte[] sendData = message.getBytes();
            socket.send(new DatagramPacket(sendData,
                    sendData.length,
                    address,
                    Server_Port));
            

            byte[] receiveData = new byte[8192];
            DatagramPacket receivePacket = new DatagramPacket(
                    receiveData,
                    receiveData.length);
            socket.receive(receivePacket);
       
            String requestId = new String(receivePacket.getData(), 0, 8);

            

            ByteArrayInputStream bais = new ByteArrayInputStream(
                    receivePacket.getData(),
                    8,
                    receivePacket.getLength() - 8);
            
             Product p;
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {
                p = (Product) ois.readObject();
            }
            
            String[] words = p.getName().split("\\s+");
            String n = words[words.length-1];
            for( int i = 1; i < words.length - 1; i++ ){
                n = n + " " + words[i];
            }
            n = n + " " + words[0];
            p.setName(n.trim());
            StringBuilder s = new StringBuilder(String.valueOf(p.getQuantity()));
            s.reverse();
            p.setQuantity(Integer.parseInt(s.toString()));
            
            
            ByteArrayOutputStream productBAOS = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(productBAOS);
            
            oos.writeObject(p);
            oos.flush();
            oos.close(); 
            ByteArrayOutputStream finalBAOS = new ByteArrayOutputStream();
            
            finalBAOS.write(requestId.getBytes());
            
            finalBAOS.write(productBAOS.toByteArray());
            byte[] finalData = finalBAOS.toByteArray();
            socket.send(new DatagramPacket(
                    finalData,
                    finalData.length,
                    address,
                    Server_Port
            ));

            
            
            
        } catch (IOException | ClassNotFoundException e) {
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
                System.out.println("closed!");
            }
        }
    }
}

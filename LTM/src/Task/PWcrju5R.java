/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task;

import UDP.Employee;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author HELLO
 */
public class PWcrju5R {
    public static void execute() {
        
        String Server = "203.162.10.109";
        
        Integer Server_port = 2209;
        
        String studentCode = "B22DCCN759";
        String qCode = "PWcrju5R";
        
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
            
            String requestId = new String(receivePacket.getData(),0,8);
            System.out.println(requestId);
            
            ByteArrayInputStream employeeBAIS = new ByteArrayInputStream(receivePacket.getData(),
                    8,
                    receivePacket.getLength() - 8
            );
            ObjectInputStream employeeOIS = new ObjectInputStream(employeeBAIS);
            Employee e = (Employee) employeeOIS.readObject();
            System.out.println(e);
            
            String[] name = e.getName().split("\\s+");
            for(int i = 0; i < name.length; i++){
                name[i] = name[i].substring(0,1).toUpperCase() + name[i].substring(1).toLowerCase();
            }
            e.setName(String.join(" ", name).trim());
            
            String[] date = e.getHireDate().split("-");
            double x = 0;
            x += (date[0].charAt(0) - '0');
            x += (date[0].charAt(1) - '0');
            x += (date[0].charAt(2) - '0');
            x += (date[0].charAt(3) - '0');
            x /= 100;
            e.setSalary(e.getSalary()*(1+x));
            System.out.println(x);
            
            String temp = date[0];
            date[0] = date[2];
            date[2] = temp;
            
            e.setHireDate(String.join("/", date));
            System.out.println(e);
            
            
            ByteArrayOutputStream objectBAOS = new ByteArrayOutputStream();
            ObjectOutputStream objectOOS = new ObjectOutputStream(objectBAOS);
            objectOOS.writeObject(e);
            objectOOS.flush();
            ByteArrayOutputStream finalBAOS = new ByteArrayOutputStream();
            finalBAOS.write((requestId).getBytes());
            finalBAOS.write(objectBAOS.toByteArray());
            
            socket.send(new DatagramPacket(
                    finalBAOS.toByteArray(),
                    finalBAOS.toByteArray().length,
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

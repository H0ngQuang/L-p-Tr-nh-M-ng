/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task;

import UDP.Student;
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
public class SHWnWx6h {
    public static void execute() {
        
        String Server = "203.162.10.109";
        
        Integer Server_port = 2209;
        
        String studentCode = "B22DCCN759";
        String qCode = "SHWnWx6h";
        
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
            
            ByteArrayInputStream studentBAIS = new ByteArrayInputStream(receivePacket.getData(),
                    8,
                    receivePacket.getLength() - 8
            );
            ObjectInputStream studentOIS = new ObjectInputStream(studentBAIS);
            Student s = (Student) studentOIS.readObject();
            System.out.println(s);
            
            
            String[] name = s.getName().split("\\s+");
            for(int i = 0 ;i < name.length; i++){
                name[i] = name[i].substring(0,1).toUpperCase() + name[i].substring(1).toLowerCase();
                System.out.println(name[i]);
            }
            s.setName(String.join(" ", name).trim());
            
            String email = name[name.length-1];
            for(int i = 0 ; i < name.length - 1; i++){
                email = email + name[i].substring(0,1);
            }
            email += "@ptit.edu.vn";
            email = email.toLowerCase();
            s.setEmail(email);
            
            System.out.println(s);
            
            
            ByteArrayOutputStream studentBAOS = new ByteArrayOutputStream();
            ObjectOutputStream studentOOS = new ObjectOutputStream(studentBAOS);
            studentOOS.writeObject(s);
            studentOOS.flush();
            ByteArrayOutputStream finalBAOS = new ByteArrayOutputStream();
            finalBAOS.write((requestId).getBytes());
            finalBAOS.write(studentBAOS.toByteArray());
            
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

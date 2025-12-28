/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import java.io.*;
import java.net.*;
import java.util.*;
import UDP.*;
/**
 *
 * @author admin
 */
public class O_Employee {
    public static String format1(String s){
        String []tmp = s.trim().split(" ");
        String res ="";
        for(String i : tmp){
            res += Character.toUpperCase(i.charAt(0)) + i.substring(1).toLowerCase();
            res += " ";
        }return res.trim();
    
    }
    public static double format2(double x, String s){
        String []tmp = s.trim().split("-");
        int dis = 0;
        for(char c : tmp[0].toCharArray()) {dis += c -'0';}
        double res = x + (x *dis/100);
        return  res;
    }
    public static String format3(String s){
        String []tmp = s.trim().split("-");
        return tmp[2]+"/"+tmp[1]+"/"+tmp[0];
    }
    public static void main(String[] args)  throws  Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP =2209;
        String code = ";B22DCCN604;dkfPZCwY";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(),sA,sP);
        socket.send(dpGui);
        
        byte [] buffer= new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        
        String reId= new String(dpNhan.getData(),0,8);
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(),8,dpNhan.getLength()-8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Employee em = (Employee) ois.readObject();
        
        
        em.setName(format1(em.getName()));
        em.setSalary(format2(em.getSalary(), em.getHireDate()));
        em.setHireDate(format3(em.getHireDate()));
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(em);
        oos.flush();
        
        byte[] sendData = new byte[8+baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGui1 = new DatagramPacket(sendData, sendData.length,sA,sP);
        socket.send(dpGui1);
          
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task2;
import UDP.Employee;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class test {
    public static String format1(String s ){
        String []ss = s.trim().split(" ");
        String res = "";
        for(String w : ss){
            res += Character.toUpperCase(w.charAt(0)) + w.substring(1).toLowerCase() + " ";
        }
        return res.trim();
    }
    public static double format2(double sum, String s ){
        String []ss = s.trim().split("-");
        int x =0;
        for(char c : ss[0].toCharArray()){
            x += c -'0';
        }
        return sum += (double) sum *x /100;
    }
    public static String format3(String s){
        String []ss = s.trim().split("-");
        return ss[2] +"/"+ss[1] +"/"+ss[0];
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        String code = ";B22DCCN604;dkfPZCwY";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA,sP);
        socket.send(dpGui);
        
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        
        String reId = new  String (dpNhan.getData(),0,8);
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(),8,dpNhan.getLength()-8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Employee employee = (Employee) ois.readObject();
        
        employee.setName(format1(employee.getName()));
        employee.setSalary(format2(employee.getSalary(), employee.getHireDate()));
        employee.setHireDate(format3(employee.getHireDate()));
        
        ByteArrayOutputStream baos= new ByteArrayOutputStream();
        ObjectOutputStream  oos = new ObjectOutputStream(baos);
        oos.writeObject(employee);
        oos.flush();
        
        byte []sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0,8);
        System.arraycopy(baos.toByteArray(),0, sendData, 8,baos.size());
        DatagramPacket dpGui1 = new DatagramPacket(sendData,sendData.length,sA,sP);
        socket.send(dpGui1);
        
    }
}

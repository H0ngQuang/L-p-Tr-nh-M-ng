/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task2;
import UDP.Employee;
import java.io.*;
import java.util.*;
import java.net.*;
/**
 *
 * @author Admin
 */
public class KApXQtlo {
    public static void main(String[] args)throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        
        String code =";B22DCCN652;KApXQtlo";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(),sA,sP);
        socket.send(dpGui);
        
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        
        String reId = new String(dpNhan.getData(),0,8);
        System.out.println("Request ID: " + reId);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(),8,dpNhan.getLength()-8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Employee employee = (Employee) ois.readObject();
        System.out.println(employee);
        
        String name = employee.getName();
        Double salary = employee.getSalary();
        String hireDate = employee.getHireDate();
        String[] tmpname = name.trim().toLowerCase().split("\\ ");
        name = "";
        for(String x : tmpname){
            name += Character.toUpperCase(x.charAt(0)) + x.substring(1) + " ";
        }
        employee.setName(name.trim());
        String[] d = hireDate.trim().split("\\-");
        int incre = 0;
        for(char c : d[0].toCharArray()){
             incre += c - '0';
        }
        salary = salary +   (double)salary*incre/100;
        employee.setSalary(salary);
        hireDate =  d[2] + "/" +d[1] +"/" +d[0];
        employee.setHireDate(hireDate);
        System.out.println(employee);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(employee);
        oos.flush();
        
        byte[] sendData = new byte[8 + baos.size()];
        System.arraycopy(reId.getBytes(),0,sendData,0,8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task2;
import java.net.*;
import UDP.Customer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *
 * @author Admin
 */
public class PcfXxRSj {
    public static String  format (String s){
        String []tmp = s.trim().split(" ");
        String res ="";
        res += tmp[tmp.length-1].toUpperCase() + ", ";
        for(int i =0;i<tmp.length-1;i++){
            res+= Character.toUpperCase(tmp[i].charAt(0))+ tmp[i].substring(1).toLowerCase() + " ";
        }
        return res.trim();
    }
    public static String format1(String s){
         String []tmp = s.trim().split("-");
        
        return tmp[1] + "/" +tmp[0] + "/" + tmp[2];
       
    }
    public static String format2 (String s){
        String []tmp = s.trim().toLowerCase().split(" ");
        String res ="";
        for(int i =0;i<tmp.length-1;i++){
            res += tmp[i].charAt(0);
        }
        res += tmp[tmp.length-1];
        return res ;
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;  
        String code = ";B22DCCN652;PcfXxRSj";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(),code.length(),sA,sP);
        socket.send(dpGui);
        
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        
        String reId = new String(dpNhan.getData(),0,8);
        System.out.println("Request ID: " + reId);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(),8,dpNhan.getLength()-8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Customer cus = (Customer) ois.readObject();
        System.out.println(cus);
        cus.setUserName(format2(cus.getName()));
        cus.setName(format(cus.getName()));
        cus.setDayOfBirth(format1(cus.getDayOfBirth()));
        
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(cus);
        oos.flush();
        
        byte[] sendData = new byte[8+baos.size()];
        System.arraycopy(reId.getBytes(),0,sendData,0,8);
        System.arraycopy(baos.toByteArray(),0,sendData,8,baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData,sendData.length,sA,sP);
        socket.send(dpGuiLai);
    }
}

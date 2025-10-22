/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task2;

import UDP.Book;
import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class nXVf0t0O {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        
        String code = ";B22DCCN652;nXVf0t0O";
        DatagramPacket dpGui =new DatagramPacket(code.getBytes(),code.length(),sA,sP);
        socket.send(dpGui);
        
        byte []buffer=  new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        
        String reId = new String(dpNhan.getData(),0,8);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(),8,dpNhan.getLength()-8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Book book = (Book) ois.readObject();
        book.setTitle(formatTitle(book.getTitle()));
        book.setAuthor(formatAuthor(book.getAuthor()));
        book.setIsbn(formatisbn(book.getIsbn()));
        book.setPublishDate(formatpublishDate(book.getPublishDate()));
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(book);
        oos.flush();
        
        byte[] sendData = new byte[8+baos.size()];
        System.arraycopy(reId.getBytes(),0,sendData,0,8);
        System.arraycopy(baos.toByteArray(),0,sendData,8,baos.size());
        DatagramPacket dpGuiLai= new DatagramPacket(sendData,sendData.length,sA,sP);
        socket.send(dpGuiLai);
    }
    public static String formatTitle(String s){
        String[] tmp = s.trim().split(" ");
        String res = "";
        for(String w : tmp){
        res += Character.toUpperCase(w.charAt(0)) + w.substring(1).toLowerCase() + " ";
        }
        return res.trim();
    }
    public static String formatAuthor(String s ){
       String[] tmp = s.trim().split(" ");
       String res = tmp[0].toUpperCase() + ", ";
       for(int i =1;i<tmp.length;i++){
           res += Character.toUpperCase(tmp[i].charAt(0)) + tmp[i].substring(1).toLowerCase() + " ";
       }
       return res.trim();
    }
    public static String formatisbn(String s){
        return s.substring(0,3) + "-" +  s.substring(3,4) + "-" + s.substring(4,6) + "-" + s.substring(6,12) + "-" +s.substring(12);
    }
    public static String formatpublishDate(String s ){
         String[] tmp = s.trim().split("-");
         return tmp[1]+"/" + tmp[0];
    }
  
    
}

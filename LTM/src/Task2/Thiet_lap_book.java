/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task2;

import UDP.Book;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author admin
 */
public class Thiet_lap_book {
    public static String format1(String s){
        String res="";
        String []tmp = s.trim().split(" ");
        for(String w : tmp ){
            res +=  Character.toUpperCase(w.charAt(0)) + w.substring(1).toLowerCase() + " ";
        }
        return res.trim();
    }
    public static String format2(String s){
        String []tmp = s.trim().split(" ");
        String res=tmp[0].toUpperCase() + ", ";

        for(int i =1;i<tmp.length;i++ ){
            String w =tmp[i];
            res +=  Character.toUpperCase(w.charAt(0)) + w.substring(1).toLowerCase() + " ";
        }
        return res.trim();
    }
    public static String format3 (String str){
//        String[] s = str.trim().split("-");
        return str.substring(0,3) + "-" + str.substring(3,4) + "-" + str.substring(4,6) + "-" + str.substring(6,12) + "-"+ str.substring(12) ;
    }
    public static String format4 (String str){
        String[] s = str.trim().split("-");
        return s[1] +"/" + s[0];
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        String code = ";B22DCCN652;RAO63Tdq";
        int sP = 2209;
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(),sA,sP);
        socket.send(dpGui);
        
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        
        String reId = new String(dpNhan.getData(),0,8);
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(),8,dpNhan.getLength()-8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Book book = (Book) ois.readObject();
        
        book.setTitle(format1(book.getTitle()));
        book.setAuthor(format2(book.getAuthor()));
        book.setIsbn(format3(book.getIsbn()));
        book.setPublishDate(format4(book.getPublishDate()));
    
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(book);
        oos.flush();
        
        byte []sendData = new byte[8+ baos.size()];
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
         System.arraycopy(baos.toByteArray(), 0, sendData, 8,baos.size());
         DatagramPacket dpGui1 = new DatagramPacket(sendData, sendData.length,sA,sP);
         socket.send(dpGui1);

    }
}

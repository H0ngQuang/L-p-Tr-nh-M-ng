/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskTCP;

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
 * @author HELLO
 */
public class yiFUOMdA {
    public static void execute() {
        
        String Server = "203.162.10.109";
        
        Integer Server_port = 2209;
        
        String studentCode = "B22DCCN759";
        String qCode = "yiFUOMdA";
        
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
            
            ByteArrayInputStream bookBAIS = new ByteArrayInputStream(receivePacket.getData(),
                    8,
                    receivePacket.getLength() - 8
            );
            ObjectInputStream bookOIS = new ObjectInputStream(bookBAIS);
            Book b = (Book) bookOIS.readObject();
            System.out.println(b);
            
            String[] title = b.getTitle().split("\\s+");
            for(int i = 0; i < title.length; i++){
                title[i] = title[i].substring(0,1).toUpperCase() + title[i].substring(1).toLowerCase();
            }
            b.setTitle(String.join(" ", title).trim());
            String[] author = b.getAuthor().split("\\s+");
            author[0] = author[0].toUpperCase() + ",";
            for(int i = 1; i < author.length ;i ++){
                author[i] = author[i].substring(0,1).toUpperCase() + author[i].substring(1).toLowerCase();
            }
            b.setAuthor(String.join(" ", author));
            StringBuilder isbn = new StringBuilder(b.getIsbn());
            isbn.insert(12, "-");
            isbn.insert(6, "-");
            isbn.insert(4, "-");
            isbn.insert(3, "-");
            b.setIsbn(isbn.toString());
            String[] date = b.getPublishDate().split("-");
            b.setPublishDate(date[1] + "/" + date[0]);
            System.out.println(b);
            
            
            ByteArrayOutputStream bookBAOS = new ByteArrayOutputStream();
            ObjectOutputStream bookOOS = new ObjectOutputStream(bookBAOS);
            bookOOS.writeObject(b);
            bookOOS.flush();
            ByteArrayOutputStream finalBAOS = new ByteArrayOutputStream();
            finalBAOS.write((requestId).getBytes());
            finalBAOS.write(bookBAOS.toByteArray());
            
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

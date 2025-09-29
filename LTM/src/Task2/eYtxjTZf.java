/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task2;

import UDP.Product;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Admin
 */
public class eYtxjTZf {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        String code = ";B22DCCN652;eYtxjTZf";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        
        byte [] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        
        byte[] data = new byte[1024];
        int len = data.length;
        String requestId = new String(data,0,8);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);

        
        Product p;
        ObjectInputStream reader= new ObjectInputStream(bais);
;
        p = (Product) reader.readObject();
        
        String fixedName = fixName(p.getName());
        int fixedQuantity = fixQuantiry(p.getQuantity());
        Product fixed = new Product(p.getId(),p.getCode(),fixedName,fixedQuantity);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(fixed);
        oos.flush();
        
        byte[] sendData = new byte[8+baos.size()];
        System.arraycopy(requestId.getBytes(),0,sendData,0,8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);

        
    }
    public static String fixName(String s){
        String res= "";
        String[] tmp = s.trim().split(" ");
        String temp = tmp[0];
        tmp[0] = tmp[s.length()-1];
        tmp[s.length()-1] =temp;
        for(int i =0;i<tmp.length;i++){
            res += tmp[i] + " ";
        }
        return  res;
    }
    public static int fixQuantiry(int n){
        int res = 0;
        while(n>0){
            res+= n%10;
            n/=10;
        }
        return res;
    }
    
}

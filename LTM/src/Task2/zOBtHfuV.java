/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task2;

import java.math.BigInteger;
import java.net.DatagramSocket;
import java.net.*;

/**
 *
 * @author Admin
 */
public class zOBtHfuV {
    public static void main(String[] args)throws  Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        
        String code = ";B22DCCN652;zOBtHfuV";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(),code.length(),sA,sP);
        socket.send(dpGui);
        
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        
        String s = new String(dpNhan.getData());
        System.out.println(s);
        String []tmp = s.trim().split("\\;");
        BigInteger a = new BigInteger(tmp[1]);
        BigInteger b = new BigInteger(tmp[2]);
        BigInteger sum = a.add(b);
        BigInteger diff = a.subtract(b);
        String res = tmp[0]+";" + sum + ","+ diff;
        System.out.println(res);
        DatagramPacket dpGuiLai = new DatagramPacket(res.getBytes(),res.length(),sA,sP);
        socket.send(dpGuiLai);
    }
}

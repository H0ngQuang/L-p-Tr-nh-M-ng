/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Admin
 */
public class h4uyMDaS {
        public static void main(String[] args) throws Exception {
            DatagramSocket socket=  new DatagramSocket();
            InetAddress sA = InetAddress.getByName("203.162.10.109");
            int sP = 2208;
            String code = ";B22DCCN652;h4uyMDaS";
            DatagramPacket dpGui = new DatagramPacket(code.getBytes(),code.length(),sA,sP);
            socket.send(dpGui);
            
            byte []buffer = new byte[1024];
            DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
            socket.receive(dpNhan);
            
            String s = new String(dpNhan.getData());
            System.out.println(s);
            String []tmp = s.trim().split(";");
            String s1 = tmp[0], s2  = tmp[1];
            String []tmpS = s2.trim().split("\\s+");
            s2 = "";
            for(String x: tmpS) s2+=Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
            String res = s1+ ";" + s2;
            System.out.println(res);
                    
//
            DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
            socket.send(dpGui1);

    }
}

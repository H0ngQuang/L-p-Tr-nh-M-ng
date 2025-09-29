/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Admin
 */
public class hr8ZDEes {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
            DatagramSocket socket = new DatagramSocket();
            InetAddress sA = InetAddress.getByName("203.162.10.109");
            int sP = 2207;
            String code = ";B22DCCN652;hr8ZDEes";
            DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
            socket.send(dpGui);
            byte []buffer = new byte[1024];
            DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
            socket.receive(dpNhan);
            
            String s = new String(dpNhan.getData());
            System.out.println(s);

            String []line = s.trim().split(";");
            String s0 = line[0];
            String[] a = line[1].trim().split(",");
            int min = Integer.parseInt(a[0]);
            int max = min ;
            for(int i=0;i<50;i++){
                int x = Integer.parseInt(a[i]);
                if(x > max) max = x;
                if(x < min) min = x;
            }
            String res =s0 +";" +max +"," + min;
            System.out.println(res);

            DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(),res.length(),sA,sP);
            socket.send(dpGui1);
    }
}

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
import java.util.TreeSet;

/**
 *
 * @author Admin
 */
public class sd8NoxBH {
    public static void main(String[] args) throws Exception {
            DatagramSocket socket = new DatagramSocket();
            InetAddress sA = InetAddress.getByName("203.162.10.109");
            int sP = 2207;
            String code = ";B22DCCN652;sd8NoxBH";
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
            TreeSet<Integer> se = new TreeSet<>();
            
            for(String i : a){
                se.add(Integer.parseInt(i));
            }
            int min = se.first();
            int max = se.last();
            int min2= se.higher(min);
            int max2 = se.lower(max);
            String res =s0 +";" +max2 +"," + min2;
            System.out.println(res);

            DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(),res.length(),sA,sP);
            socket.send(dpGui1);
    }
}

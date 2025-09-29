package Task2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Comparator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class nrBhU5z6 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        String code = ";B22DCCN652;nrBhU5z6";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(),sA,sP);
        socket.send(dpGui);
        
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
        socket.receive(dpNhan);
        
        String s= new String(dpNhan.getData());
        System.out.println(s);
        
        String []line = s.trim().split(";");
        String s0 = line[0];
        String[] a = line[1].trim().split(" ");
        
        Comparator<String> compare = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            // So sánh ngược theo từ điển (z -> a)
            return s2.toLowerCase().compareTo(s1.toLowerCase());
        }};
        Arrays.sort(a,compare);
        String tmp = "";
        for(int i =0;i<a.length;i++){ tmp+= a[i]; if(i!= a.length-1) tmp+=","; }
        String res= s0 +";"+tmp;
        System.out.println(res);
        
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(),res.length(),sA,sP);
        socket.send(dpGui1);   
        



    }
}

package Task2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class nrBhU5z6 {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        
        String code = ";B22DCCN652;nrBhU5z6";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(),code.length(),sA,sP);
        socket.send(dpGui);
        
        byte [] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
       
        String s = new String(dpNhan.getData());
        String[] line = s.trim().split(";");
        String[] tmp = line[1].trim().split(" ");
        List<String> a = new ArrayList<>();
        for(String i : tmp){a.add(i);}
        Comparator<String> compare = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                return s2.toLowerCase().compareTo(s1.toLowerCase());
            }
        };
        Arrays.sort(tmp,compare);
        Collections.sort(a, compare);
        String res = line[0] + ";";
        for(String w : tmp){ res = res + w + ",";}
        res = res.substring(0,res.length()-1);
        
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(),res.length(),sA,sP);
        socket.send(dpGui1);
    }
}

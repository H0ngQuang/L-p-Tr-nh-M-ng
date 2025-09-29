package UDP;

import java.util.*;
import java.io.*;
import java.net.*;
public class h4uyMDaS {
    public static void main(String[] args) throws Exception {
        DatagramSocket socker   = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("192.168.0.107");
        int sP = 2208;
        String code =";B22DCCN652;h4uyMDaS";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socker.send(dpGui);
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socker.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI=  sTmp[0];
        String s = sTmp[1];
        // Chuan hoa
        String [] tmpS = s.trim().split("\\s+");
        s="";
        for(String x : tmpS) s +=Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        String res= rI +";" + s;
        System.out.println(res);
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socker.send(dpGui1);
    }
}


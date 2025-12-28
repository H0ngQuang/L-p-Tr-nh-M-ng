/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task2;

import java.net.*;
import java.util.HashMap;
import java.util.*;

/**
 *
 * @author admin
 */
public class D_Xu_ly_chuoi_xao_tron {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        String code = ";B22DCCN036;lpIg2wc4";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(),sA,sP);
        socket.send(dpGui);
        
        byte[] buffer= new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        
        String line = new String(dpNhan.getData());
        String[] tmp = line.trim().split(";");
        int n = tmp.length;
        String []s = tmp[1].trim().split(",");
        HashMap<Integer,String> mp = new HashMap();
        for(String w : s){
            String []i = w.trim().split(":");
            mp.put(Integer.valueOf(i[1]),i[0]);
        }
        String res ="";
        for (int i = 1; i <= mp.size(); i++) {
            res +=mp.get(i);
            if (i < mp.size()) res+= ",";
        }
        res = tmp[0] + ";"+ res;
        DatagramPacket dpGui1 =  new DatagramPacket(res.getBytes(), res.length(),sA,sP);
        socket.send(dpGui1);
    }
}

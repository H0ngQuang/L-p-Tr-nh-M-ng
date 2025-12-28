/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task2;

import java.net.*;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Cua_so_truot {
    public static void main(String[] args) throws Exception {
       DatagramSocket socket = new DatagramSocket();
       InetAddress sA = InetAddress.getByName("203.162.10.109");
       int sP =2207;
       String code = ";B22DCCN652;qztPs90W";
       DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(),sA,sP);
       socket.send(dpGui);
       
       byte [] buffer = new byte[1024];
       DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
       socket.receive(dpNhan);
       
       String line = new String(dpNhan.getData());
       String []s = line.trim().split(";");
       int n = Integer.valueOf(s[1]);
       int k = Integer.valueOf(s[2]);
       String[] arr = s[3].split(",");
       ArrayList<Integer> a = new ArrayList<>();
       for(String w : arr){
           a.add(Integer.valueOf(w));
       }
       String res= s[0] +";";
       for(int i =0;i<=n-k;i++){
           int max =a.get(i);
           for(int j =i+1 ;j<i+k;j++){
               if(a.get(j) > max){
                   max =a.get(j);
               }
           }
           res += max+"," ;
       }
       res = res.substring(0,res.length()-1);
       DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(),sA,sP);
       socket.send(dpGui1);
       socket.close();
    }
   
}

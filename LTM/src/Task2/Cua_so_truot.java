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
        String code = ";B22DCCN604;BdpYQwGi";
        int sP = 2207;
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(),sA,sP);
        socket.send(dpGui);
        
        byte []buffer= new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        
        String s = new String(dpNhan.getData());
        String[] line = s.trim().split(";");
        String[] s1 = line[3].trim().split(",");
        ArrayList<Integer> a = new ArrayList<>();
         ArrayList<Integer> b = new ArrayList<>();

        for(String i : s1){
            a.add(Integer.valueOf(i));
        }
        int n = Integer.valueOf(line[1]);
        int k = Integer.valueOf(line[2]);
        for(int i=0;i<=n-k;i++){
            int max =a.get(i);
            for(int j=i+1;j<i+k;j++){
                if(a.get(j) > max){
                max = a.get(j);
                }
            }
            b.add(max);
            
        }
        String res = line[0] + ";";
        for(int i : b){
            res += i + ",";
        }
        res =res.substring(0,res.length()-1);
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(),res.length(),sA,sP);
        socket.send(dpGui1);
    }
   
}

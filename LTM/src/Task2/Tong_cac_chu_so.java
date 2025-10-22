/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author admin
 */
public class Tong_cac_chu_so {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA= InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        String code = ";B22DCCN652;N0A89bPs";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(),sA,sP);
        socket.send(dpGui);
        
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
        socket.receive(dpNhan);
        
        String s = new String(dpNhan.getData());
        String []line = s.trim().split(";");
        int sum =0;
        for(char c : line[1].toCharArray()){
            sum += (c-'0');
            }
        String res = line[0]+";" +sum;
        DatagramPacket dpGui1= new DatagramPacket(res.getBytes(),res.length(),sA,sP);
        socket.send(dpGui1);
    }
}

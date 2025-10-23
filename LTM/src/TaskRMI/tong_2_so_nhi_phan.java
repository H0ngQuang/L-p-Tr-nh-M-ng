/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;

import java.net.*;

/**
 *
 * @author Admin
 */
public class tong_2_so_nhi_phan {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP =2208;
        String code =";B22DCCN471;rwObCr2h";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(),sA,sP);
        socket.send(dpGui);
        
        byte []buffer= new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        
    }
}

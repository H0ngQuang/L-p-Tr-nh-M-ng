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
public class Loai_bo_ki_tu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket=  new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        String code = ";B22DCCN652;GfFHugud";
        int sP = 2208;
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(),code.length(),sA,sP);
        socket.send(dpGui);
    
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        
        String s = new String(dpNhan.getData());
        String []str = s.trim().split(";");
        int []cnt = new int[256];
        for(char c : str[2].toCharArray()){
            cnt[c]++;
        }String res = "";
        for(char c : str[1].toCharArray()){
            if(cnt[c] > 0){
                continue;
            }
            res +=c;
        }
        res = str[0] + ";"+res;
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(),res.length(),sA,sP);
        socket.send(dpGui1);
    }
}

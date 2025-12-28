/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskTCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class B_Vi_tri_CB {
     public static void main(String[] args)  throws  Exception{
        Socket socket = new Socket("203.162.10.109",2208);
        InputStream reader = socket.getInputStream();
        OutputStream writer = socket.getOutputStream();
        String code = "B21DCCN169;TL9Pol9D";
        writer.write(code.getBytes());
        writer.flush();
        
        byte[] buffer = new byte[1024];
        int readline = reader.read(buffer);
        String s = new String (buffer,0,readline);
    
        String []ss = s.trim().split(",");
        ArrayList<Integer>a = new ArrayList<>();
        int sum =0;
        for(String i : ss){
            a.add(Integer.valueOf(i));
            sum += Integer.valueOf(i);
        }
        int n= a.size();
        int pos =-1,dolech =Integer.MAX_VALUE,tongphai=0,tongtrai=0,ress =0;
        
        for(int i=1;i<n-1;i++){
            int tong1=0;
            for(int j=0;j<i;j++) tong1 += a.get(j);
            int tong2 = sum -tong1;
            int hieu = Math.abs(tong2-tong1);
            if(hieu <dolech){
                dolech=hieu;
                tongtrai =tong1;
                tongphai = tong2;
                pos = i;
                ress= dolech;
            }
        }
        String res = pos +"," +tongtrai+","+tongphai+","+ress;
        writer.write(res.getBytes());
        writer.flush();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskTCP;
import java.util.*;
import java.net.*;
import java.io.*;


/**
 *
 * @author admin
 */
public class B_Tong_x2TBC {
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
        for(String i : ss){
            a.add(Integer.valueOf(i));
        }
        Collections.sort(a);
        int sum =0;
        for(int i : a) sum += i;
        double tbc =(double) sum/a.size();
        int n = a.size();
        double kc=Double.MAX_VALUE,n1=0,n2=0;
        for(int i=0;i<n;i++){
            for(int j =i+1;j<n;j++){
                int su = a.get(i) + a.get(j);
                double hieu = Math.abs(su - 2*tbc);
                if(hieu < kc ){
                    kc = hieu;
                    n1=a.get(i);
                    n2=a.get(j);
                }
            }
        }
        writer.write((n1+"," +n2).getBytes());
        writer.flush();
    }
}

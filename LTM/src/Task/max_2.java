/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author admin
 */
public class max_2 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2206);
        InputStream reader = socket.getInputStream();
        OutputStream writer = socket.getOutputStream();
        writer.write("B22DCCN568;HqFLCUMJ".getBytes());

        byte [] buffer = new byte[1024];
        int readLine = reader.read(buffer);
        String s = new String(buffer,0,readLine);
      
        String[] tmp = s.trim().split(",");
        ArrayList<Integer> a = new ArrayList<>();
        TreeSet<Integer> se = new TreeSet<>();
        for(String w : tmp ){
            Integer x = Integer.valueOf(w);
            a.add(x);
            se.add(x);
        }
        int max2 = se.lower(se.last());
        int idx =-1;
        for(int i =0;i<a.size();i++){
            if(a.get(i) == max2) {
                idx = i;
                break;
            }
        }
        String res =(max2 +"," + idx);
        writer.write(res.getBytes());
        writer.flush();
      }
}



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
 * @author Admin
 */
public class Chuoi_con_tang_dai_nhat {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2206);
        InputStream reader = socket.getInputStream();
        OutputStream writer = socket.getOutputStream();
        
        writer.write("B22DCCN604;WMgL8yn8".getBytes());
        
        byte[] buffer = new byte[1024];
        int bytesline = reader.read(buffer);
        String line = new String(buffer,0,bytesline);
        ArrayList<Integer> a = new ArrayList<>();
        String[] tmp = line.trim().split(",");
        for(String i : tmp) a.add(Integer.parseInt(i));
        
    }
}

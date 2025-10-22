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
public class Chuoi_tu_so_nguyen {
    
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2206);
        InputStream reader = socket.getInputStream();
        OutputStream writer = socket.getOutputStream();
        writer.write("B22DCCN568;HqFLCUMJ".getBytes());
        
        byte [] buffer = new byte[1024];
        int readLine = reader.read(buffer);
        String line = new String(buffer,0,readLine);
        int n = Integer.valueOf(line);
        List<Integer> seq = new ArrayList<>();
        seq.add(n);
        while(n!=1) {
            if(n%2==0) n /=2;
            else n = 3*n+1;
            seq.add(n);
        }
        String res ="";
        for(int i : seq) res += i + " ";
        res= res.substring(0,res.length()-1);
        res += "; " + seq.size();
        writer.write(res.getBytes());
        writer.flush();
    }
}

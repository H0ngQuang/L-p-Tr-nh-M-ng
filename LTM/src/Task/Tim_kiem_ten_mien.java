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
public class Tim_kiem_ten_mien {
    public static void main(String[] args)throws Exception{
        
        Socket socket = new Socket("203.162.10.109",2208);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        writer.write("B22DCCN568;q6ThQ9s2");
        writer.newLine();
        writer.flush();
        
        String line = reader.readLine();
        String[] s = line.trim().split(",");
        String res ="";
        for(String i  : s){
            String x = i.trim();
            if(x.endsWith(".edu")) res += x + ", ";
        }
        res = res.substring(0,res.length()-2);
        writer.write(res);
         writer.newLine();
         writer.flush();
    }
}

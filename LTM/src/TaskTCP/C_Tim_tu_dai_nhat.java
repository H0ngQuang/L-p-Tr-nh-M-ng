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
public class C_Tim_tu_dai_nhat {
    public static void main(String[] args)throws Exception{
        Socket socket = new Socket("203.162.10.109",2208);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        writer.write("B21DCCN036;2uG0lQGi");
        writer.newLine();
        writer.flush();
        
        // String s = reader.readLine();
        String s ="I am learning programming in Java";
        String []a = s.trim().split(" ");
        String ans =a[0];
        int res= a[0].length();
        int pos =1;
        for(int i=1;i<a.length;i++){
            if(a[i].length()>res){
                res= a[i].length();
                ans = a[i];
                pos = s.indexOf(a[i]);
            }
        }
        System.out.println(ans);
        System.out.println(pos);
        writer.write(ans);
        writer.newLine();
        writer.flush();
        
        writer.write(pos+"");
        writer.newLine();
        writer.flush();
    }
}

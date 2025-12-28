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
public class C_tach_chieu {
    public static void main(String[] args)throws Exception{
        Socket socket = new Socket("203.162.10.109",2208);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        writer.write("B21DCCN036;2uG0lQGi");
        writer.newLine();
        writer.flush();
        
        String s = reader.readLine();
        String s1="",s2="";
        for(char c : s.toCharArray()){
            if(Character.isDigit(c) || Character.isLetter(c)){
                s1 += c;
            }else s2 += c;
        }
        writer.write(s1);
        writer.newLine();
        writer.flush();
        
        writer.write(s2);
        writer.newLine();
        writer.flush();
    }
}

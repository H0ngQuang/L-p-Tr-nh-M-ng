/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author admin
 */
public class B_Sap_xep_chuoi {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2208);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        writer.write("B21DCCN036;2uG0lQGi");
        writer.newLine();
        writer.flush();
        
        String ss = reader.readLine();
        String []s = ss.trim().split(" ");
        ArrayList<String> a = new ArrayList();
        for(String w : s) a.add(w);
        Collections.sort(a, new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                return s1.length() - s2.length();
            }
        });
        String res ="";
        for(String w : a) res += w + ", ";
        res = res.substring(0,res.length()-2);
 writer.write(res);
        writer.newLine();
        writer.flush();
    }
    
}

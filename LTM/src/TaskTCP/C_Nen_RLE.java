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
public class C_Nen_RLE {
    public static String DaoXau(String s){
        String res ="";
        for(int i = s.length() - 1;i>=0;i--) {
            res+= s.charAt(i);
        }
        return res;
    }
    public static String nenRLE(String s){
        int cnt =1;
        String res ="";
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                cnt ++;
            }
            else{ 
                res += s.charAt(i-1);
                res += cnt;
                cnt =1;
            }
        }
        res += s.charAt(s.length()-1);
        res +=cnt;
        return res;
    
    }
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2208);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        writer.write("B21DCCN036;2uG0lQGi");
        writer.newLine();
        writer.flush();
        
        String ss = reader.readLine();
        String []s = ss.trim().split(" ");
        ArrayList<String>a = new ArrayList<>();
        for(String w : s){
            a.add(nenRLE(DaoXau(w)));
        }
        String res = "";
        for(String w : a) res += w + " ";
        res = res.trim();
        
        writer.write(res);
        writer.newLine();
        writer.flush();
    }
}

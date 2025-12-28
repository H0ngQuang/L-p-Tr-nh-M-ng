/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskTCP;

import java.io.*;
import java.net.*;
import TCP.Laptop;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class testTCP {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream reader = socket.getInputStream();
        OutputStream writer = socket.getOutputStream();
        writer.write("B22DCCN604;rF2aMpwc".getBytes());
        writer.flush();
        
        byte []buffer = new byte[1024];
        int readline = reader.read(buffer);
        String line = new String(buffer,0,readline);
        String []s = line.trim().split(",");
        ArrayList<Integer> a = new ArrayList<>();
        for(String w : s){
            a.add(Integer.valueOf(w));
        }
        int n = a.size();
        int []f = new int[n];
        int []trace = new int[n];
        for(int i =0;i<n;i++){
            f[i] = 1;
            trace[i]=-1;
        }
        for(int i=0;i<n;i++){
            for(int j =0;j<i;j++){
                if(a.get(j) < a.get(i) && f[i]< f[j]+1){
                    f[i] = f[j]+1;
                    trace[i] =j;
                }
            }
        }
        int max =0,id=-1;
        for (int i=0;i<n;i++){
            if(f[i] > max){
                max =f[i];
                id =i;
            }
        } ArrayList<Integer> b = new ArrayList<>();
        while(id!=-1){
            b.add(a.get(id));
            id = trace[id];
        }
        String res ="";
        for(int i = b.size()-1;i>=0;i--){
            res += b.get(i) + ",";
        }
        res =res.substring(0,res.length()-1);
        res += ";" + max ;
        writer.write(res.getBytes());
        writer.flush();
        socket.close();
    }   
}

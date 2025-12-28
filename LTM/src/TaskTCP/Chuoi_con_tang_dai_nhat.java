/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskTCP;

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
        
        writer.write("B22DCCN604;rF2aMpwc".getBytes());
        
        byte []buffer = new byte[1024];
        int readline = reader.read(buffer);
        String s = new String (buffer,0, readline);
        String []num = s.trim().split(",");
        int n= num.length;
        int [] a = new int[n];
        for(int i =0;i<n;i++){
            a[i] = Integer.parseInt(num[i]);
        }
        int []f = new int[n];
        int []trace = new int [n];
        int max =0,id= 0;
        for (int i =0;i<n;i++){
            f[i] =1;
            trace[i] =-1;
        }
        for(int i =0;i<n;i++){
            for (int j =0;j<i;j++){
                if(a[j]< a[i] && f[j] +1 > f[i]){
                    f[i] = f[j] +1;
                    trace[i] = j;
                }
            }
        }
        for (int i =0;i<n;i++){
            if(f[i] > max ){
                max = f[i];
                id = i;
            }
        }
        List<Integer> lis= new ArrayList<>();
        while(id != -1){
            lis.add(a[id]);
            id = trace[id];
        }
        String res ="";
        for(int i =lis.size()-1;i>=1;i--){
            res += lis.get(i)+",";
        }
        res += lis.get(0) + ";" + lis.size();
        writer.write(res.getBytes());
        writer.flush();
        
    }
}

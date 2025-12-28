/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskTCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class quay_lui_ve_1 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2206);
        InputStream reader = socket.getInputStream();
        OutputStream writer = socket.getOutputStream();
        writer.write("B22DCCN711;KWGIOfoO".getBytes());
        
        byte []buffer = new byte[1024];
        int readline = reader.read(buffer);
        String line = new String(buffer,0,readline);
        int n = Integer.valueOf(line);
        ArrayList<Integer> a = new ArrayList<>();
        a.add(n);
        while(n>1){
            if(n%2==0) n/=2;
            else n=n*3+1;
            a.add(n);
        }
        String res ="";
        for(int i : a) res += i + " ";
        res =res.substring(0,res.length()-1);
        res +="; " + a.size();
        writer.write(res.getBytes());
        writer.flush();
    }
}

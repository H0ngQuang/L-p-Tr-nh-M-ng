/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskTCP;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author admin
 */
public class Day_con_khong_lap_dai_nhat {
    public static void main(String[] args) throws Exception{
    Socket socket = new Socket("203.162.10.109",2206);
    InputStream reader = socket.getInputStream();
    OutputStream writer = socket.getOutputStream();
    writer.write("B22DCCN568;HqFLCUMJ".getBytes());

    byte [] buffer = new byte[1024];
    int readLine = reader.read(buffer);
    String s = new String(buffer,0,readLine);
    String res = "", cur = "";
    for(char c : s.toCharArray()){
        if( cur.indexOf(c)!=-1){
            cur = cur.substring(cur.indexOf(c)+1);
        }
        cur +=c;
        if(cur.length() > res.length()) res = cur;
        
    }
            String anss  = res + ";" + res.length();
            writer.write(res.getBytes())
    
                    ;writer.flush();}
}

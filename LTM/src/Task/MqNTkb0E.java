/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class MqNTkb0E {
    public static void main(String[] args) throws Exception{
        String server = "203.162.10.109";
        int port = 2206;
        String studentCode = "B22DCCN652";
        String qCode = "MqNTkb0E";
        Socket socket = new Socket (server,port);
        InputStream reader = socket.getInputStream();
        OutputStream writer = socket.getOutputStream();
        writer.write((studentCode+";" + qCode).getBytes());
        writer.flush();
        byte []buffer = new byte[1024];
        int bytesRead = reader.read(buffer);
        String line = new String(buffer,0,bytesRead).trim();
        String[] tmp = line.split("\\|");
        int sum =0;
        for(String i : tmp){
        sum += Integer.valueOf(i);
        }
        String res = sum + "";
        writer.write(res.getBytes());
        writer.flush();
        
    }
}

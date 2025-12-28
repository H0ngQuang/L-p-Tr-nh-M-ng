/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskTCP;

import java.io.*;
import java.net.*;
import java.util.*;
/**
/**
 *
 * @author admin
 */
public class chuoi_sang_nhi_phan {
    public static void main(String[] args)throws Exception{
        Socket socket = new Socket("203.162.10.109",2207);
        DataInputStream reader = new DataInputStream(socket.getInputStream());
        DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
                writer.writeUTF("B22DCCN568;FKhow09D");
                writer.flush();
        
        Integer n = reader.readInt();
        String s = Integer.toBinaryString(n);
        writer.writeUTF(s);
        writer.flush();
    }
}

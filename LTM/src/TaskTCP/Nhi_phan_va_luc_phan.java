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
public class Nhi_phan_va_luc_phan {
   public static void main(String[] args)throws Exception{
        Socket socket = new Socket("203.162.10.109",2207);
        DataInputStream reader = new DataInputStream(socket.getInputStream());
        DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
                writer.writeUTF("B22DCCN735;9fhRFXtp");
                writer.flush();
        Integer n = reader.readInt();
        String s1 = Integer.toBinaryString(n);
        String s2 = Integer.toHexString(n);
        writer.writeUTF(s1+";"+s2.toUpperCase());
        writer.flush();
   }
}

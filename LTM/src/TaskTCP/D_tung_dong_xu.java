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
public class D_tung_dong_xu {
    public static void main(String[] args) throws Exception{
        
        Socket socket = new Socket("203.162.10.109",2207);
        DataInputStream reader = new DataInputStream(socket.getInputStream());
        DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
        writer.writeUTF("B22DCCN652;dmadqwqwd");
        writer.flush();
        
        int n = reader.readInt();
        int [] a = new int[n];
        int []cnt = new int [256];
        for(int i =0;i<n;i++){
            a[i]=reader.readInt();
            cnt[a[i]]++;
        }String res ="";
        for(int i =1;i<=6;i++){
            writer.writeDouble((double) cnt[i]/n);
        }
        writer.flush();
    }
}

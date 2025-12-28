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
public class D_PhuongSai {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2207);
        DataInputStream reader = new DataInputStream(socket.getInputStream());
        DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
        writer.writeUTF("B22DCCN652;dmadqwqwd");
        writer.flush();
        int n= reader.readInt();
        int []a = new int[n];
        int sum=0;
        for(int i=0;i<n;i++){ 
            a[i] =reader.readInt();
            sum += a[i];
        }
        double dbc =(double )sum /n;
        double psai =0;
        for(int i=0;i<n;i++){
            psai += (dbc-a[i]) *(dbc -a[i]);
                
        }
       
        writer.writeInt(sum);
        writer.flush();
        writer.writeDouble(dbc);
        writer.flush();
        writer.writeDouble(psai);
        writer.flush();
    }
}

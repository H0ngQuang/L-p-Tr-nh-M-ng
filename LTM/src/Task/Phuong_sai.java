/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author admin
 */
public class Phuong_sai {
     public static void main(String[] args) throws Exception{
        String code = "B22DCCN652;dCNDHojG";
        Socket socket = new Socket("203.162.10.109",2207);
        DataInputStream reader = new DataInputStream(socket.getInputStream());
        DataOutputStream writer = new DataOutputStream (socket.getOutputStream());
        writer.writeUTF(code);
        writer.flush();
        
        int n = reader.readInt();
        int []a = new int[n];
        for(int i =0;i<n;i++) a[i] = reader.readInt();
        int sum =0;
        for(int i =0;i<n;i++) sum += a[i];
        double tbc = sum/n;
        double psai = 0;
        for(int i=0;i<n;i++) psai += (a[i]-tbc) *(a[i]-tbc);
        psai /=n;
        writer.writeInt(sum);
        writer.flush();
        writer.writeDouble(tbc);
        writer.flush();
        writer.writeDouble(psai);
        writer.flush();
    }
}

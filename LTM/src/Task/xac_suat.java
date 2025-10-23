/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.*;

/**
 *
 * @author admin
 */
public class xac_suat {
    public static void main(String[] args)throws  Exception{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN370;PpWEQ6F0";
        out.writeUTF(code); out.flush();
        int n = in.readInt();
        int []a = new int[n];
        for(int i = 0;i<n;i++){ a[i] = in.readInt();}
        int [] cnt = new int[105];
        for(int x : a) cnt[x]++;
        for(int i =1;i<=6;i++){
            out.writeFloat((float)cnt[i]/n);
            out.flush();
        }
    }
}

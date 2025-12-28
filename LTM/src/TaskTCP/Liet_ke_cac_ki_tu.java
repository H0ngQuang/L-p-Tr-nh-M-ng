/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskTCP;

import java.io.*;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author admin
 */
public class Liet_ke_cac_ki_tu {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("203.162.10.109",2208);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("B22DCCN604;e8ufOcmB");
        writer.newLine();
        writer.flush();
        
        String s = reader.readLine();
        int [] cnt = new int[256];
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c))
            cnt[c]++;
        }
        String res = "";
        for(char c : s.toCharArray()){
            if(cnt[c] > 1){
                res +=c +":" + cnt[c] + ",";
                cnt[c]=0;
            }
        }
        writer.write(res);
         writer.newLine();
        writer.flush();
    }
}

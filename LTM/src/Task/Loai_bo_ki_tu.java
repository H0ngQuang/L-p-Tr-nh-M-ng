/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class Loai_bo_ki_tu {
    public static void main(String[] args) throws Exception{
        String server=  "203.162.10.109";
        int port = 2208;
        String studentCode = "B22DCCN652";
        String qCode = "1oRWaY0o";
        
        Socket socket = new Socket(server,port);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        writer.write(studentCode + ";" + qCode);
        writer.newLine();
        writer.flush();
        
        String s = reader.readLine();
        String res = "";
        int []cnt = new int[10005];
        for(char x: s.toCharArray()){ 
            if(Character.isAlphabetic(x)) cnt[x]++;
        }
        for(char x: s.toCharArray()){ 
            if(cnt[x] > 0){
                res+=x;
                cnt[x] = 0;
            }
        }
        writer.write(res);
        writer.newLine(); 
        writer.flush();

    }
}

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
 * @author HELLO
 */
public class FixdzOfT {
    public static void run() {
        
        String server = "203.162.10.109"; 
        int port = 2207;
        String studentCode = "B22DCCN759";
        String qCode = "FixdzOfT";

        try(Socket socket = new Socket(server, port)){
            
            DataInputStream reader = new DataInputStream(socket.getInputStream());
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
           
            writer.writeUTF(studentCode + ";" + qCode);
            writer.flush();
            
            int k = reader.readInt();
            System.out.println(k);
            String[] s = reader.readUTF().split(",");
            
            for(int i = 0; i < s.length; i += k){
                int left = i;
                int right = Math.min(i + k - 1, s.length - 1);
                while(left < right){
                    String temp = s[left];
                    s[left] = s[right];
                    s[right] = temp;
                    left++;
                    right--;
                }
            }
            
            writer.writeUTF(String.join(",", s));
            writer.flush();
            System.out.println(String.join(",", s));
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}

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
public class YLk2Ofi4 {
    public static void run() {
        
        String server = "203.162.10.109"; 
        int port = 2207;
        String studentCode = "B22DCCN759";
        String qCode = "YLk2Ofi4";

        try(Socket socket = new Socket(server, port)){
            
            DataInputStream reader = new DataInputStream(socket.getInputStream());
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
           
            writer.writeUTF(studentCode + ";" + qCode);
            writer.flush();
            
            int a = reader.readInt();
            int b = reader.readInt();
            
            writer.writeInt(a+b);
            writer.flush();
            writer.writeInt(a*b);
            writer.flush();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}

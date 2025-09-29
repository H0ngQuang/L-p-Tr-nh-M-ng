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
 * @author Gearvn
 */
public class xooZGulo {
    public static void main(String[] args) {
        
        String server = "203.162.10.109"; 
        int port = 2207;
        String studentCode = "B22DCCN759";
        String qCode = "xooZGulo";

        try(Socket socket = new Socket(server, port)){
            
            DataInputStream reader = new DataInputStream(socket.getInputStream());
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
           
            writer.writeUTF(studentCode + ";" + qCode);
            writer.flush();
            
            
            String[] s = reader.readUTF().split(",");
            
            int sum = Math.abs(Integer.parseInt(s[0]) - Integer.parseInt(s[1]));
            int incr;
            if (Integer.parseInt(s[0]) < Integer.parseInt(s[1])){
                incr = 1;
            }else{
                incr = 0;
            }
            int r = 0;
            for(int i = 1; i < s.length - 1; i++){
                sum += Math.abs(Integer.parseInt(s[i]) - Integer.parseInt(s[i+1]));
                System.out.println(Integer.parseInt(s[i])+ " " +Integer.parseInt(s[i+1]));
                if(Integer.parseInt(s[i]) < Integer.parseInt(s[i+1]) && incr == 0){
                    r++;
                    incr = 1;
                }
                if(Integer.parseInt(s[i]) > Integer.parseInt(s[i+1]) && incr == 1){
                    r++;
                    incr = 0;
                }
            }
            
            writer.writeInt(r);
            writer.flush();
            writer.writeInt(sum);
            writer.flush();
            
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}

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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HELLO
 */
public class Mix7yn73 {
    public static String solve(String s){
        StringBuilder r = new StringBuilder();
        int count = 1;
        char current = s.charAt(s.length()-1);
        for(int i = s.length()-2; i >= 0; i--){
            if(current == s.charAt(i)){
                count++;
            } else {
                r.append(current);
                if (count > 1) {
                    r.append(count);
                }
                count = 1;
                current = s.charAt(i);
            }
        }
        r.append(current);
        if(count > 1){
            r.append(count);
        }
        
        
        return r.toString();
    }
    public static void run() {
        
        String server = "203.162.10.109"; 
        int port = 2208;
        String studentCode = "B22DCCN759";
        String qCode = "Mix7yn73";

        try(Socket socket = new Socket(server, port)){
            
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            writer.write(studentCode + ";" + qCode);
            writer.newLine();
            writer.flush();
            System.out.println(studentCode + ";" + qCode);
            String s = new String(reader.readLine());
            System.out.println(s);
            String[] w = s.split("\\s+");
            List<String> result = new ArrayList<>();
            for(int i = 0; i < w.length; i++){
                result.add(solve(w[i]));
                
            }
            
            writer.write(String.join(" ", result));
            writer.newLine();
            writer.flush();
            System.out.println(String.join(" ", result));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}

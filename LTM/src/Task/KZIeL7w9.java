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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author HELLO
 */
public class KZIeL7w9 {
    public static void run() {
        
        String server = "203.162.10.109"; 
        int port = 2208;
        String studentCode = "B22DCCN759";
        String qCode = "KZIeL7w9";

        try(Socket socket = new Socket(server, port)){
            
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            writer.write(studentCode + ";" + qCode);
            writer.newLine();
            writer.flush();
            System.out.println(studentCode + ";" + qCode);
            String s = new String(reader.readLine());
            System.out.println(s);

            List<String> result = new ArrayList<>(Arrays.asList(s.split("\\s+")));
            Collections.sort(result, (a,b) -> {
                 return Integer.compare(a.length(), b.length());
        
            });
            
            writer.write(String.join(", ", result));
            writer.newLine();
            writer.flush();
            System.out.println(String.join(", ", result));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}

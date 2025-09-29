/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Task;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Gearvn
 */
public class yWzDiDVu {

    public static String readLine(InputStream in, int t) throws IOException, InterruptedException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        long start = System.currentTimeMillis();
        
        while(true){
            if(in.available() > 0){
                int b = in.read();
                if(b == -1 && b == '\n') break;
                if(b != '\r') baos.write(b);
            }
            
            
            
            if(System.currentTimeMillis() - start > t) break;
            Thread.sleep(10);
        }
        return baos.toString();
        
    }

    public static void main(String[] args) {
        String server = "203.162.10.109";
        int port = 2206;
        String studentCode = "B22DCCN759";
        String qCode = "yWzDiDVu";
        
        try(Socket socket = new Socket(server, port)){
            
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            
            out.write((studentCode + ";" + qCode).getBytes());
            
            String data = readLine(in, 4000);
            System.out.println(data);
            int sum = 0;
            for(String s : data.split("\\|")){
                sum += Integer.parseInt(s.trim());
            }
            out.write(String.valueOf(sum).getBytes());
            System.out.println(sum);
        }catch(Exception e){
            e.printStackTrace();
        }

            
    }
    
}

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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gearvn
 */
public class _6ZUyZpfh  {

    private static String readLine(InputStream in, int timeoutMs) throws IOException, InterruptedException{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        long start = System.currentTimeMillis();

        while (true) {
            if (in.available() > 0) {
                int b = in.read();
                if (b == -1 || b == '\n') {
                    break;
                }
                if (b != '\r') {
                    baos.write(b);
                }
            }

            if (System.currentTimeMillis() - start > timeoutMs) {
                // Hết thời gian
                break;
            }

            Thread.sleep(10); // tránh vòng lặp bận
        }

        return baos.toString();
    }

    public static void main(String[] args) {
       String server = "203.162.10.109";
       int port = 2206;
       String studentCode = "B22DCCN759";
       String qCode = "6ZUyZpfh";
       
       try(Socket socket = new Socket(server, port)){
           InputStream in = socket.getInputStream();
           OutputStream out = socket.getOutputStream();
           
           
           
           out.write((studentCode + ";" + qCode).getBytes());
           out.flush();
           String data = readLine(in,3000);
           System.out.println(data);
           String[] nums1 = data.split(",");
           List<Integer> l = new ArrayList<>();
  
           for(String num : nums1){
               l.add(Integer.parseInt(num));
           }
           int sum = 0;
           for(Integer n: l){
               sum +=n;
           }
           int avr = sum/l.size()*2;
           int m = Integer.MAX_VALUE;
        
           for(Integer n: l){
               sum +=n;
           }
           System.out.println(data);
           System.out.println(sum);
           out.write(String.valueOf(sum).getBytes());
           socket.close();
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    
}

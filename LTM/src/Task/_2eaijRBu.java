package Task;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Gearvn
 */
public class _2eaijRBu {

    
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
    public static int nt(String s){
        int n = Integer.parseInt(s.trim());
        System.out.println(n);
        if(n < 2) return 0;
        for(int i = 2; i*i < n + 1; i++){
            if(n % i == 0) return 0;
        }
        return n;
    }
    public static void main(String[] args) {
        String server = "203.162.10.109";
        int port = 2206;
        String studentCode = "B22DCCN759";
        String qCode = "2eaijRBu";
        
        try(Socket socket = new Socket(server, port)){
            
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            
            out.write((studentCode + ";" + qCode).getBytes());
            
            String data = readLine(in, 3000);
            System.out.println(data);
            int sum = 0;
            for(String s : data.split(",")){
                sum += nt(s);
            }
            out.write(String.valueOf(sum).getBytes());
            System.out.println(sum);
        }catch(Exception e){
            e.printStackTrace();
        }

            
    }
    
}

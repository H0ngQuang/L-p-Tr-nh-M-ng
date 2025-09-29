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
public class _9aNjQqGW {

    public static String readLine(InputStream in, int time) throws IOException, InterruptedException{
        long start = System.currentTimeMillis();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while(true){
            if(in.available() > 0){
                baos.write(in.read());
            }
            
            if(System.currentTimeMillis() - start > time){
                break;
            }
            Thread.sleep(10);
            
        }
        return baos.toString();
    }
    public static void main(String[] args) {
        String server = "203.162.10.109";
        String studentCode = "B22DCCN759";
        int port = 2206;
        String qCode = "9aNjQqGW";
        
        try(Socket socket = new Socket(server, port)){
            
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            
            out.write((studentCode + ";" + qCode).getBytes());
            
            String data = readLine(in, 4500);
            
            String[] nums = data.split(",");
            
            int sum = 0;
            for(String num : nums){
                sum += Integer.parseInt(num);
            }
            
            int cur = 0;
            int l = 0;
            int r = sum - l - Integer.parseInt(nums[1]);
            int s = 0;
            for(int i = 1 ; i < nums.length ; i++){
                s += Integer.parseInt(nums[i-1]);
                
                int c = Math.abs(s - (sum - s - Integer.parseInt(nums[i])));
                
                if(c < Math.abs(l-r)){
                    l = s;
                    r = sum - s - Integer.parseInt(nums[i]);
                    cur=i;
                }
            }
            
            System.out.println(cur);
            System.out.println(l);
            System.out.println(r);
            out.write((cur + "," + l + "," + r + "," + (Math.abs(l-r))).getBytes());
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
    
}

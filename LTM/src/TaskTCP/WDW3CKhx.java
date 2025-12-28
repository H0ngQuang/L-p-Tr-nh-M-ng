/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TaskTCP;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Gearvn
 */
public class WDW3CKhx {


    public static void main(String[] args)throws IOException {
        String server = "203.162.10.109";
        String studentCode = "B22DCCN652";
        int port = 2206;
        String qCode = "WDW3CKhx";
        
        Socket socket = new Socket(server, port);
            
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
            
        out.write((studentCode + ";" + qCode).getBytes());
        out.flush();
       
        // b
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String received = new String(buffer,0,bytesRead).trim();
        String[] temp = received.split(",");
        ArrayList<Integer> nums = new ArrayList<>();
        for(String s : temp){
            Integer n = Integer.parseInt(s);
            nums.add(n);
        }
        double sum =0;
        for(int n : nums){
        sum += n;}
        double avg = sum / nums.size();
        double target = 2 *avg;
        int n1 = nums.get(0),n2 = nums.get(1);
        double compare = Math.abs((n1+n2) - target);
        for(int i =0;i<nums.size();i++){
            for(int j =i+1;j<nums.size();j++){
                int a = nums.get(i);
                int b= nums.get(j);
                double diff= Math.abs((a+b)- target);
                if(diff< compare){
                    compare = diff;
                    n1 = a;
                    n2 = b;
                }
            }
        }
        if(n1 > n2 ){
            int tmp = n1;
            n1 = n2;
            n2 = tmp;
        }
        String res = n1 + "," + n2;
        out.write(res.getBytes());
        out.flush();
        socket.close();
        System.err.println("Da gui" + res);
    }
    
}

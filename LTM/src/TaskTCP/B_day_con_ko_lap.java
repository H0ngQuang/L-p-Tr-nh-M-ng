/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskTCP;
import java.io.*;
import java.net.*;
/**
 *
 * @author admin
 */
public class B_day_con_ko_lap {
     public static void main(String[] args) throws Exception {
        // Kết nối server TCP
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        // Gửi mã sinh viên / token
        String code = "B21DCCN214;HyHAk4P5";
        out.write(code.getBytes());
        out.flush();

        // Nhận dữ liệu từ server
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        System.out.println("Chuỗi nhận từ server: " + s);
        
        int max = 0;
        String res = "";
                
        for(int i=0;i<s.length();i++){
            boolean[] check = new boolean[256];
            String tmp= "";
            for(int j =i;j<s.length();j++){
                char c= s.charAt(j);
                if(check[c]) break;
                check[c]=true;
                tmp +=c;
            }
            if(tmp.length() > res.length()){
                max =tmp.length();
                res = tmp;
            }
        }
        res = res +";" + max;
        System.out.println("Kết quả: " + res);

        out.write(res.getBytes());
        out.flush();
    }
}

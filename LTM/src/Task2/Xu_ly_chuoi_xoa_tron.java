/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task2;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author admin
 */
public class Xu_ly_chuoi_xoa_tron {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP =2207;
        String code = ";B22DCCN568;0b26o6B1";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(),code.length(),sA,sP);
        socket.send(dpGui);
        
         byte []buffer = new byte[1024];
         DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
         socket.receive(dpNhan);
         
        String s = new String(dpNhan.getData());
        String[] line = s.trim().split(";");
        String []pair = line[1].trim().split(",");
        String []res = new String[pair.length];
        for(String i : pair){
            String []s1 = i.trim().split(":");
            res[Integer.valueOf(s1[1]) -1 ] = s1[0];
        }
        String ans = line[0]+";";
        for(String w : res){
            ans += w + ",";
        }ans = ans.substring(0,ans.length()-1);
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(),ans.length(),sA,sP);
        socket.send(dpGui1);

    }
}
//
//[Mã câu hỏi (qCode): 0b26o6B1].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:
//
//a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN009;F3E8B2D4".
//
//b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;string", với:
//--- requestId là chuỗi ngẫu nhiên duy nhất.
//--- string là một chuỗi chứa các chuỗi con bị thay đổi vị trí. Ví dụ: "veM3xgA1g:4,IPFfgEanY:5,aWXlSzDwe:2,PHupvPc:3,PR3gH8ahN:6,UEEKHLIt:7,M6dpWTE:1"
//
//c. Xử lý chuỗi xáo trộn và gửi về chuỗi sau khi sắp xếp: "requestId;string". Ví dụ chuỗi đã được xử lý: "M6dpWTEaWXlSzDwePHupvPcveM3xgA1gIPFfgEanYPR3gH8ahNUEEKHLIt"
//
//d. Đóng socket và kết thúc chương trình.
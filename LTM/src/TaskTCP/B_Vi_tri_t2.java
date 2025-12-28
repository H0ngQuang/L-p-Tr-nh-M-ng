/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskTCP;
import java.util.*;
import java.net.*;
import java.io.*;
/**
 *
 * @author admin
 */
public class B_Vi_tri_t2 {
      public static void main(String[] args)  throws  Exception{
        Socket socket = new Socket("203.162.10.109",2208);
        InputStream reader = socket.getInputStream();
        OutputStream writer = socket.getOutputStream();
        String code = "B21DCCN169;TL9Pol9D";
        writer.write(code.getBytes());
        writer.flush();
        
        byte[] buffer = new byte[1024];
        int readline = reader.read(buffer);
        String s = new String (buffer,0,readline);
        
        ArrayList<Integer> a  = new ArrayList<>();
        TreeSet<Integer> se = new TreeSet<>();
        String []ss =s.trim().split(",");
        for(String i : ss){
            a.add(Integer.valueOf(i));
        }
        for(int i : a) se.add(i);
        int max2 = se.lower(se.last());
        String res = max2 +",";
        for(int i =0;i<a.size();i++){
            if(a.get(i) ==  max2) {
                res += i;
            }
        }   
        writer.write(res.getBytes());
        writer.flush();
      }
}
/*
[Mã câu hỏi (qCode): 0lhEivaG].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2206 (thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác tới server ở trên sử dụng các luồng byte (InputStream/OutputStream) để trao đổi thông tin theo thứ tự: 
a.	Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;2B3A6510"
b.	Nhận dữ liệu từ server là một chuỗi các giá trị số nguyên được phân tách nhau bởi ký tự ",". Ví dụ: 1,3,9,19,33,20
c.	Tìm và gửi lên server giá trị lớn thứ hai cùng vị trí xuất hiện của nó trong chuỗi.Ví dụ: 20,5
d.	Đóng kết nối và kết thúc chương trình.
*/
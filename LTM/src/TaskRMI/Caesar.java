/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class Caesar {
    public static void main(String[] args) throws  Exception{
        Socket socket = new Socket("203.162.10.109",2207);
        String code = "B22DCCN471;F6aZ6yLs" ;
        DataInputStream reader = new DataInputStream(socket.getInputStream());
        DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
        writer.writeUTF(code);
                writer.flush();

        String s = reader.readUTF();
//        System.out.println(s);
        int n = reader.readInt();
        String res = "";
        for(char c : s.toCharArray()){
           if (c >= 'A' && c <= 'Z') { // chữ hoa
                    c = (char)((c - 'A' - n + 26) % 26 + 'A');
            } else if (c >= 'a' && c <= 'z') { // chữ thường
                    c = (char)((c - 'a' - n + 26) % 26 + 'a');
            } 
    
        res += c;
        }
        writer.writeUTF(res);
        writer.flush();
    }
}
//[Mã câu hỏi (qCode): F6aZ6yLs].  Mật mã caesar, còn gọi là mật mã dịch chuyển, để giải mã thì mỗi ký tự nhận được sẽ được thay thế bằng một ký tự cách nó một đoạn s. Ví dụ: với s = 3 thì ký tự “A” sẽ được thay thế bằng ký tự “D”.
//Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2207 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng chương trình client tương tác với server trên, sử dụng các luồng byte (DataInputStream/DataOutputStream) để trao đổi thông tin theo thứ tự:
//a.	Gửi một chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;D68C93F7"
//b.	Nhận lần lượt chuỗi đã bị mã hóa caesar và giá trị dịch chuyển s nguyên
//c.	Thực hiện giải mã ra thông điệp ban đầu và gửi lên Server
//d.	Đóng kết nối và kết thúc chương trình.
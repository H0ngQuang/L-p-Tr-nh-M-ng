/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Admin
 */
public class chuoi_con_tang_dai_nhat_1 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109",2206);
        InputStream reader = socket.getInputStream();
        OutputStream writer = socket.getOutputStream();
        writer.write("B22DCCN735;zQPeFQw9".getBytes());
        writer.flush();
        byte [] buffer = new byte[1024];
        int readline = reader.read(buffer);
        String s = new String(buffer,0,readline);
        String []line = s.trim().split(",");
        int n = line.length;

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line[i].trim());
        }
        int []dp = new int[n];
        int []trace = new int[n];
        int maxlen = 1, endIndex = 0;
        Arrays.fill(dp,1);
        Arrays.fill(trace, -1);
        for(int i =0;i<n;i++){
            for(int j =0;j<i;j++){
                if(a[i]> a[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j]+1;
                    trace[i] =j;
                }
            }
            if(dp[i] > maxlen){
                maxlen = dp[i];
                endIndex = i;
            }
        }
        List<Integer> seq = new ArrayList<>();
        while(endIndex!= -1){
            seq.add(a[endIndex]);
            endIndex = trace[endIndex];
        }
        String res ="";
        for(int i =seq.size()-1;i>=0;i--){
            res += seq.get(i) + ",";
            
        }
        res= res.substring(0,res.length()-1);
        res+=";" + seq.size();
        writer.write(res.getBytes());
        writer.flush();
    }
}

//[Mã câu hỏi (qCode): zQPeFQw9].  Một chương trình server hỗ trợ kết nối qua giao thức TCP tại cổng 2206 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu xây dựng chương trình client thực hiện kết nối tới server sử dụng luồng byte dữ liệu (InputStream/OutputStream) để trao đổi thông tin theo thứ tự:
//    a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;76B68B3B".
//    b. Nhận dữ liệu từ server là một chuỗi các giá trị số nguyên được phân tách bởi ký tự ",". Ví dụ: 5,10,20,25,50,40,30,35.
//    c. Tìm chuỗi con tăng dần dài nhất và gửi độ dài của chuỗi đó lên server theo format "chuỗi tăng dài nhất; độ dài". Ví dụ: 5,10,20,25,50;5
//    d. Đóng kết nối và kết thúc chương trình.
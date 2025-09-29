/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task;

import java.io.*;
import java.net.*;
import java.util.*;

public class Wy2roR5J {
    public static void main(String[] args) {
        String studentCode = "B22DCCN652";
        String qCode = "Wy2roR5J";
        int port = 2208;
        String server = "203.162.10.109";

        try (Socket socket = new Socket(server, port)) {
            // Timeout đọc 5s theo đề
//            socket.setSoTimeout(5000);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // a) Gửi "studentCode;qCode"
            writer.write(studentCode + ";" + qCode);
            writer.newLine();
            writer.flush();
            System.out.println("Đã gửi: " + studentCode + ";" + qCode);

            // b) Nhận danh sách tên miền từ server
            String domainsLine = reader.readLine();
            if (domainsLine == null) {
                System.err.println("Khong nhan duoc du lieu tu server.");
                return;
            }
            System.out.println("Nhan duoc tu server " + domainsLine);

            // c) Lọc tên miền .edu (giữ nguyên format tách theo dấu phẩy)
            String[] parts = domainsLine.split(",");
            List<String> a = new ArrayList<>();
            for (String x : parts) {
                if (x == null) continue;
                x = x.trim();
                if (x.toLowerCase().endsWith(".edu")) {
                    a.add(x);
                }
            }

            // Ghép và gửi lại
            String respones = String.join(",", a);
            writer.write(respones);
            writer.newLine();
            writer.flush();
            System.out.println("Đã gửi lại tên miền .edu: " + respones);

            // d) Kết thúc: try-with-resources sẽ tự đóng kết nối
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package Task;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class JQy2zo5J {
    public static void main(String[] args) {
        String server = "230.162.10.109"; 
        int port = 2208;
        String stucode = "B22DCCN652"; // Mã sinh viên
        String qcode = "JQy2zo5J";      // Mã câu hỏi

        try (Socket socket = new Socket(server, port)) {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 1️⃣ Gửi mã sinh viên + mã câu hỏi
            writer.write(stucode + ";" + qcode);
            writer.newLine(); // gửi dòng mới để server đọc đúng
            writer.flush();

            // 2️⃣ Nhận chuỗi từ server
            String data = reader.readLine();
            System.out.println("Chuỗi nhận từ server: " + data);

            // 3️⃣ Tách các từ theo khoảng trắng
            String[] words = data.trim().split("\\s+");

            // 4️⃣ Sắp xếp theo độ dài, giữ thứ tự xuất hiện khi cùng độ dài
            List<String> wordList = Arrays.asList(words);
            wordList.sort(Comparator.comparingInt(String::length));

            // 5️⃣ Ghép lại thành chuỗi phân tách bằng ", "
            String result = String.join(", ", wordList);

            // 6️⃣ Gửi kết quả lên server
            writer.write(result);
            writer.newLine();
            writer.flush();

            System.out.println("Danh sách gửi lên server: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

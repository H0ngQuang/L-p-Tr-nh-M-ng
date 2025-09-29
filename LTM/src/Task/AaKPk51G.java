package Task;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class AaKPk51G {

    public static void main(String[] args) throws IOException {
        String server = "203.162.10.109";
        int port = 2207;
        String studentCode = "B22DCCN652";
        String qCode = "AaKPk51G";

        // Thời gian chờ tối đa cho mỗi lần đọc: 5 giây
        Socket socket = new Socket (server,port);
       
        DataInputStream reader = new DataInputStream(socket.getInputStream());
        DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
           
        writer.writeUTF(studentCode + ";" + qCode);
        writer.flush();
        
        Integer n = reader.readInt();
        
        String oct = Integer.toOctalString(n);
        String hex = Integer.toHexString(n).toUpperCase();
        
        writer.writeUTF(oct + ";" + hex);
        writer.flush();

        System.out.println("Received decimal: " + n);
        System.out.println("Sent: " + oct + ";" + hex);
        socket.close();
    }
}

import UDP.Student;
import java.io.*;
import java.net.*;

public class U5zjLzpn{
    public static String formatName(String s){
        String []tmp = s.trim().split(" ");
        String res = "";
        for(String w : tmp){
            res += Character.toUpperCase(w.charAt(0)) + w.substring(1).toLowerCase() + " ";
            
        }
        return res.trim();
    }
    public static String email(String s){
        String []tmp = s.trim().toLowerCase().split(" ");
        String res = tmp[tmp.length-1];
        for(int i=0;i<tmp.length-1;i++){
            res +=tmp[i].charAt(0);
        }
        return res += "@ptit.edu.vn";
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B22DCCN652;U5zjLzpn";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer,buffer.length);
        socket.receive(dpNhan);
        
        String reID = new String(dpNhan.getData(),0,8);
        System.out.println(reID);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(),8,dpNhan.getLength());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Student stu = (Student) ois.readObject();
        
        stu.setEmail(email(stu.getName()));
        stu.setName(formatName(stu.getName()));

        System.out.println(stu);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(stu);
        oos.flush();
        
        byte []sendData = new byte[8+ baos.size()];
        System.arraycopy(reID.getBytes(),0,sendData,0,8);
        System.arraycopy(baos.toByteArray(),0,sendData,8,baos.size());
        DatagramPacket dpguiLai = new DatagramPacket(sendData, sendData.length,sA,sP);
        socket.send(dpguiLai);
    }
}
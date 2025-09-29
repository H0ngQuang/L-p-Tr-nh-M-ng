package UDP;
import java.util.*;
import java.io.*;
import java.net.*;

public class U5zjLzpn {
    public static String ChuanHoa (String s){
        s=s.trim();
        s= s.toLowerCase();
        String a[] = s.split("\\s+");
        String res="";
        for(String x : a){
            res+= Character.toUpperCase(x.charAt(0));
            res+= x.substring(1);
            res+= " ";
        }
        res=  res.substring(0,res.length()-1);
        return res;
    }      
    public static String ChuanHoaEmail(String s){
        s=s.trim();
        s=s.toLowerCase();
        String a[]= s.split("\\s+");
        String res="";
        res+=  a[a.length-1];
        for(int i=0;i<a.length-1;i++){
            res+= a[i].charAt(0);
        }
        res+= "@ptit.edu.vn";
        return res;
    }  
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("192.168.0.106");
        int  p = 2209;
        String code =";B22DCCN652;U5zjLzpn";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(),ip,p);
        socket.send(dpGui);

        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        String rq = new String (dpNhan.getData(),0,8);
        System.out.println(rq);

        String s = new String (dpNhan.getData(),8,dpNhan.getLength()-8);
        System.out.println("Request=" + rq);

        ByteArrayInputStream input = new ByteArrayInputStream(dpNhan.getData(),8,dpNhan.getLength()-8);
        ObjectInputStream ois = new ObjectInputStream(input);
        student sv = (student)ois.readObject();
        System.out.println(sv);

        sv.name = ChuanHoa(sv.name);
        sv.email = ChuanHoaEmail(sv.email);
        System.out.println(sv);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(output); 
        oos.writeObject(sv);
        oos.flush();

        byte gui2[] = new byte[8 + output.size()];
        System.arraycopy(rq.getBytes(), 0, gui2, 0, 8);
        System.arraycopy(output.toByteArray(), 0, gui2, 8, output.size()); 

        DatagramPacket guiLai = new DatagramPacket(gui2, gui2.length, ip, p);
        socket.send(guiLai);
        socket.close();
    }
}

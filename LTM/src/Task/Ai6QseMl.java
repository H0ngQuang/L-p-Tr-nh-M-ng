/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task;
import TCP.Address;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
/**
 *
 * @author Admin
 */
public class Ai6QseMl {
    public static void main(String[] args) throws Exception {
        String server = "203.162.10.109";
        int port = 2209;
        String studentCode = "B22DCCN652";
        String qCode = "Ai6QseMl";
        Socket socket = new Socket(server,port);
        ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());
        writer.flush();
        ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());
        writer.writeObject(studentCode + ";" + qCode);
        writer.flush();
        //b
        Object obj = reader.readObject();
        Address a = (Address) obj;
        
        String address=  a.getAddressLine();
        String PostalCode = a.getPostalCode();
        
        address = formataddress(address);
        PostalCode = formatCode(PostalCode);
        
        a.setAddressLine(address);
        a.setPostalCode(PostalCode);
        
        writer.writeObject(a);
        writer.flush();
        socket.close();
    }
    public static String formataddress(String s){
        String[] parts = s.trim().split("\\s+");
        String res ="";
        for(String w : parts){
            if(!w.equals("")){
                res += Character.toUpperCase(w.charAt(0));
                for(int i =1;i<w.length();i++){
                    res += Character.toLowerCase(w.charAt(i));
                res+= " ";
            }
        }}
        return res.trim();
    }
    public static String formatCode(String s){
        String res ="";
        for(char c : s.toCharArray() ){
            if(Character.isDigit(c) || c == '-') {
                    res+=c;
            }
        }
        return res;
    }
}

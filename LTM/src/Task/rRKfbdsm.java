/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Task;

import static Task._9aNjQqGW.readLine;
import TCP.Address;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author Gearvn
 */
public class rRKfbdsm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String server = "203.162.10.109";
        String studentCode = "B22DCCN759";
        int port = 2209;
        String qCode = "rRKfbdsm";
        
        try(Socket socket = new Socket(server, port)){
       
            
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.flush();
            oos.writeObject(studentCode + ";" + qCode);
            oos.flush();
            
            
            
            ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
            Address a = (Address) oin.readObject();
            System.out.println(a);
            
            
            a.setAddressLine(nomalizeAddressLine(a.getAddressLine()));
            a.setPostalCode(nomalizePostalCode(a.getPostalCode()));
            System.out.println(a);
            oos.writeObject(a);
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
    
    public static String nomalizeAddressLine(String s){
        if(s==null || s.equals("")) return "";
        String cleaned = s.replaceAll("[^\\p{L}\\p{Nd}]", " ").trim();
        cleaned = cleaned.replaceAll("(?<=\\p{L})(?=\\p{Nd})", " ");
        cleaned = cleaned.replaceAll("(?<=\\p{Nd})(?=\\p{L})", " ");
        String[] ss = cleaned.split("\\s+");
        String r = "";
        for(String x : ss){
            r += x.substring(0, 1).toUpperCase();
            r += x.substring(1).toLowerCase();
            r += " ";
        }
        return r.trim();
    }
    
    public static String nomalizePostalCode(String s){
        s = s.replaceAll("[^\\p{Nd}\\-]", "");
        return s;
    }
    
}

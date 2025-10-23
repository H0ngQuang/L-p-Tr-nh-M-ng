/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task;
import java.io.*;
import java.net.Socket;
import java.util.*;

/**
 *
 * @author Admin
 */
public class Doi_chieu_bien_thien {
    public static void main(String[] args) throws Exception{
        String code = "B22DCCN652;dCNDHojG";
        Socket socket = new Socket("203.162.10.109",2207);
        DataInputStream reader = new DataInputStream(socket.getInputStream());
        DataOutputStream writer = new DataOutputStream (socket.getOutputStream());
        writer.writeUTF(code);
        writer.flush();
    }
}

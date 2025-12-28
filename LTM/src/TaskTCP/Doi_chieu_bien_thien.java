/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskTCP;
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
        
        String s =reader.readUTF();
        ArrayList<Integer>a = new ArrayList<>();
        String []tmp = s.trim().split(",");
        for(String x: tmp) a.add(Integer.parseInt(x.trim()));
        int dbt = 0;
        int n = a.size();
        for(int i=1;i<n;i++) dbt += Math.abs(a.get(i) - a.get(i-1));
        int doichieu =0;
        for(int i=1;i<n-1;i++){
            if((a.get(i) > a.get(i-1) && a.get(i) > a.get(i+1)) || (a.get(i) < a.get(i-1) && a.get(i) < a.get(i+1))) doichieu++;
        }
        writer.writeInt(doichieu);
        writer.writeInt(dbt);
        writer.flush();
    }
}

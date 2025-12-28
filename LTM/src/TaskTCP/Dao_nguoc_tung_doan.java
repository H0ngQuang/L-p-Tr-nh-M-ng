/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.*;

/**
 *
 * @author Admin
 */
public class Dao_nguoc_tung_doan {
    public static void main(String[] args) throws Exception{
        String code = "B22DCCN652;dCNDHojG";
        Socket socket = new Socket("203.162.10.109",2207);
        DataInputStream reader = new DataInputStream(socket.getInputStream());
        DataOutputStream writer = new DataOutputStream (socket.getOutputStream());
        writer.writeUTF(code);
                writer.flush();

        Integer k = reader.readInt();
        String s =reader.readUTF();
        ArrayList<Integer>a = new ArrayList<>();
        String []tmp = s.trim().split(",");
        for(String x: tmp) a.add(Integer.parseInt(x.trim()));
        int n = a.size();
        String res ="";
        for(int i=0;i<n;i+=k){
            int x = Math.min(i+k-1,n-1);
            for(int j = x; j>=i;j--){
                res += a.get(j) + ",";
            }
        }
        res = res.substring(0,res.length()-1);
        writer.writeUTF(res);
        writer.flush();
    }
}

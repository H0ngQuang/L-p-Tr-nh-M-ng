/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task;

import TCP.Laptop;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author admin
 */
public class Sua_doi_thong_tin_laptop {
    public static String format1(String s){
        String []tmp = s.trim().split(" ");
        String res = tmp[tmp.length-1] + " ";
        for(int i =1;i<tmp.length-1;i++){
            res +=tmp[i] + " ";
        }
        res += tmp[0];
        return res;
    }
    public static int format2(int n){
        int res = 0;
        while(n>0){
            res = res *10 + n%10;
            n/=10;
        }
        return res;
    }
    public static void main(String[] args)throws  Exception{
         Socket socket = new Socket("203.162.10.109",2209);
         ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());
         
         ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());
         writer.writeObject("B22DCCN652;Q5ZreXZ5");
         writer.flush();
         Object obj = reader.readObject();
         Laptop lap = (Laptop) obj;
         lap.setName(format1(lap.getName()));
         lap.setQuantity(format2(lap.getQuantity()));
         writer.writeObject(lap);
         writer.flush();
        socket.close();
    }
}

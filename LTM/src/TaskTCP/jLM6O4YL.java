/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskTCP;
import TCP.Product;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class jLM6O4YL {
    public static void main(String[] args) throws Exception {
        String server = "203.162.10.109";
        int port = 2209;
        String studentCode = "B22DCCN652";
        String qCode = "jLM6O4YL";
        Socket socket = new Socket(server,port);
        
        ObjectOutputStream reader = new ObjectOutputStream(socket.getOutputStream());
        reader.flush();
        ObjectInputStream writer = new ObjectInputStream(socket.getInputStream());
        
        reader.writeObject(studentCode + ";" + qCode);
        reader.flush();
        
        // b
        Object obj = writer.readObject();
        Product p = (Product) obj;
        
        int intPart = (int) Math.floor(p.getPrice());
        int discount = sumDigits(Math.abs(intPart));
        p.setDiscount(discount);
        
        reader.writeObject(p);
        reader.flush(); 
        System.out.println("Received: " + p.getName() + " price=" + p.getPrice());
        System.out.println("Computed discount = " + discount + " -> sent back.");
        
        socket.close();
    }
    private static int sumDigits(long n) {
        int s = 0;
        if (n == 0) return 0;
        while (n > 0) {
            s += (int) (n % 10);
            n /= 10;
        }
        return s;
    }
}

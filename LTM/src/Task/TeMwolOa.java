package Task;


import TCP.Product;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TeMwolOa {

    public static void main(String[] args) {
        String server = "203.162.10.109";
        String studentCode = "B22DCCN759";
        int port = 2209;
        String qCode = "TeMwolOa";

        try (Socket socket = new Socket(server, port)) {

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.flush();
            oos.writeObject(studentCode + ";" + qCode);
            oos.flush();

            ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
            Product a = (Product) oin.readObject();
            System.out.println(a);
            String price = String.valueOf((int)a.getPrice());
            int discount = 0;
            for(int i = 0; i< price.length(); i++){
                discount += price.charAt(i) - '0';
            }
            a.setDiscount(discount);
            System.out.println(a);
            oos.writeObject(a);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}

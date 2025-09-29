import java.io.*;
import java.net.*;

public class NormalClient {
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int port = 8080;
        try (Socket s = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"))) {

            out.write("Hello Server\n");
            
            out.flush();

            String resp = in.readLine();
            System.out.println("[NormalClient] Server: " + resp);
        }
    }
}

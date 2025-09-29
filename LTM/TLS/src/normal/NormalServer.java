import java.io.*;
import java.net.*;

public class NormalServer {
    public static void main(String[] args) throws Exception {
        int port = 8080;
        try (ServerSocket ss = new ServerSocket(port)) {
            System.out.println("[NormalServer] Listening on " + port + " ...");
            while (true) {
                try (Socket s = ss.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
                     BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"))) {

                    String line = in.readLine();
                    System.out.println("[NormalServer] Client says: " + line);
                    out.write("Echo (PLAINTEXT): " + line + "\n");
                    out.flush();
                }
            }
        }
    }
}

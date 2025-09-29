import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class TLSServer {
    public static void main(String[] args) throws Exception {
        String keyStorePath = "serverkeystore.jks";
        char[] password = "123456".toCharArray();
        int port = 8443;

        // Load server keystore (private key + certificate)
        KeyStore ks = KeyStore.getInstance("JKS");
        try (FileInputStream fis = new FileInputStream(keyStorePath)) {
            ks.load(fis, password);
        }

        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(ks, password);

        SSLContext sc = SSLContext.getInstance("TLSv1.2");
        sc.init(kmf.getKeyManagers(), null, null);

        SSLServerSocketFactory ssf = sc.getServerSocketFactory();
        try (SSLServerSocket server = (SSLServerSocket) ssf.createServerSocket(port)) {
            System.out.println("[TLSServer] Listening TLS on " + port + " ...");
            while (true) {
                try (SSLSocket socket = (SSLSocket) server.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                     BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"))) {

                    String line = in.readLine();
                    System.out.println("[TLSServer] Client says: " + line);
                    out.write("Echo (TLS): " + line + "\n");
                    out.flush();
                }
            }
        }
    }
}

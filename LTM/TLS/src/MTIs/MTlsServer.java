import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class MTlsServer {
    public static void main(String[] args) throws Exception {
        char[] pass = "123456".toCharArray();
        int port = 9443;

        // 1) Server keystore: server private key + cert
        KeyStore ks = KeyStore.getInstance("JKS");
        try (FileInputStream fis = new FileInputStream("serverkeystore.jks")) {
            ks.load(fis, pass);
        }
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(ks, pass);

        // 2) Server truststore: trust client certificate/CA
        KeyStore ts = KeyStore.getInstance("JKS");
        try (FileInputStream fis = new FileInputStream("servertruststore.jks")) {
            ts.load(fis, pass);
        }
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(ts);

        SSLContext sc = SSLContext.getInstance("TLSv1.2");
        sc.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

        SSLServerSocketFactory ssf = sc.getServerSocketFactory();
        try (SSLServerSocket server = (SSLServerSocket) ssf.createServerSocket(port)) {
            server.setNeedClientAuth(true);
            System.out.println("[MTlsServer] Listening mTLS on " + port + " ...");

            while (true) {
                try (SSLSocket socket = (SSLSocket) server.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                     BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"))) {

                    String line = in.readLine();
                    System.out.println("[MTlsServer] Client says: " + line);
                    out.write("Echo (mTLS): " + line + "\n");
                    out.flush();
                }
            }
        }
    }
}

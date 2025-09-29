import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class TLSClient {
    public static void main(String[] args) throws Exception {
        String trustStorePath = "clienttruststore.jks";
        char[] password = "123456".toCharArray();
        String host = "localhost";
        int port = 8443;

        // Load client truststore (server cert or CA to trust)
        KeyStore ts = KeyStore.getInstance("JKS");
        try (FileInputStream fis = new FileInputStream(trustStorePath)) {
            ts.load(fis, password);
        }
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(ts);

        SSLContext sc = SSLContext.getInstance("TLSv1.2");
        sc.init(null, tmf.getTrustManagers(), null);
        
        SSLSocketFactory sf = sc.getSocketFactory();
        try (SSLSocket s = (SSLSocket) sf.createSocket(host, port);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"));
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"))) {

            out.write("Hello over TLS\n");
            out.flush();

            String resp = in.readLine();
            System.out.println("[TLSClient] Server: " + resp);
        }
    }
}

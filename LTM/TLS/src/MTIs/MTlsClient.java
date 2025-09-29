import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class MTlsClient {
    public static void main(String[] args) throws Exception {
        char[] pass = "123456".toCharArray();
        String host = "localhost";
        int port = 9443;

        // 1) Client keystore: client private key + cert
        KeyStore clientKs = KeyStore.getInstance("JKS");
        try (FileInputStream fis = new FileInputStream("clientkeystore.jks")) {
            clientKs.load(fis, pass);
        }
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(clientKs, pass);

        // 2) Client truststore: trust server cert/CA
        KeyStore clientTs = KeyStore.getInstance("JKS");
        try (FileInputStream fis = new FileInputStream("clienttruststore.jks")) {
            clientTs.load(fis, pass);
        }
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(clientTs);

        SSLContext sc = SSLContext.getInstance("TLSv1.2");
        sc.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

        SSLSocketFactory sf = sc.getSocketFactory();
        try (SSLSocket s = (SSLSocket) sf.createSocket(host, port);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"));
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"))) {

            out.write("Hello over mTLS\n");
            out.flush();

            String resp = in.readLine();
            System.out.println("[MTlsClient] Server: " + resp);
        }
    }
}

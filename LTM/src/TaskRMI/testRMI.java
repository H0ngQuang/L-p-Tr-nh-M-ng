
package TaskRMI;
import RMI.*;
import RMI.ProductX;
import java.rmi.registry.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;




public class testRMI {
    public static void main(String[] args) throws Exception {
       Registry rg = LocateRegistry.getRegistry("203.162.10.109");
       ByteService sv = (ByteService) rg.lookup("RMIByteService");
       
       String key ="PTIT";
       byte[] a = sv.requestData("B22DCCN652", "yIXp8g6l");
       
       byte[] keyb = key.getBytes();
       int n = key.length();
       byte[] res = new byte[a.length];

       for(int i=0;i<a.length;i++){
           res[i] = (byte) (a[i] ^ keyb[i%4]);
         
       }
       sv.submitData("B22DCCN652", "yIXp8g6l",res);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskRMI;
import RMI.ByteService;
import java.rmi.registry.*;

/**
 *
 * @author Admin
 */
public class Phep_XOR {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109");
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte [] a = sv.requestData("B22DCCN604", "9a1dBUt0");
        
        String key = "PTIT";
        byte[] Bytekey = key.getBytes();
        byte[] encryp = new byte[a.length];
        
        for(int i =0;i<a.length;i++) encryp[i] = (byte) (a[i] ^ Bytekey[i%Bytekey.length]);
        sv.submitData("B22DCCN604", "9a1dBUt0",encryp);
    }
}
